package com.benj.falconfarm;

import com.benj.falconfarm.util.Market;
import com.benj.falconfarm.util.Trade;
import com.benj.falconfarm.util.TreeNode;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.network.packet.c2s.play.SelectMerchantTradeC2SPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.village.TradeOffer;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.List;



public class FalconFarm implements ModInitializer {

	// Declare the client
	private static final MinecraftClient client = MinecraftClient.getInstance();
	public static final String MOD_ID = "tutorial";

	// Logger for console and log file
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// ----------------------------- Key Bindings -----------------------------
	// Container for key bindings and their corresponding functions
	private final Map<KeyBinding, Consumer<String>> keyBindings = new HashMap<>();

	// Register a new key binding and store it in the container
	private void registerKeyBinding(String translationKey, String categoryName, int keyCode, Consumer<String> action) {
		KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				translationKey,
				InputUtil.Type.KEYSYM,
				keyCode,
				categoryName
		));
		keyBindings.put(keyBinding, action);
	}

	public void loadAllKeyBinds()
	{
		registerKeyBinding("Random Message", "Chat", GLFW.GLFW_KEY_R, FalconFarm::sendRandomChatMessage);
		registerKeyBinding("Open Shop", "Farm", GLFW.GLFW_KEY_KP_MULTIPLY, FalconFarm::openShop);
		registerKeyBinding("Open PV", "Farm", GLFW.GLFW_KEY_SLASH, FalconFarm::openPV1);
		// make capslock keybinding
		registerKeyBinding("Testing Function", "Debug", GLFW.GLFW_KEY_Z, FalconFarm::testFunction);

		// Register tick event to listen for key presses
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			// Log the key presses
			keyBindings.forEach((keyBinding, action) -> {
				if (keyBinding.wasPressed()) action.accept("");
			});
		});
	}

	// ----------------------------- Custom Chat Commands -----------------------------
	// Container for custom chat commands and their corresponding functions
	private final Map<String, Consumer<String>> customCommands = new HashMap<>();

	// Register a new custom chat command and store it in the container
	private void registerCustomCommand(String command, Consumer<String> action) { customCommands.put(command, action); }

	// Handle incoming chat messages and trigger corresponding custom commands

	public void loadAllCustomCommands()
	{
		registerCustomCommand("!random", FalconFarm::sendRandomChatMessage);
		registerCustomCommand("!shop", FalconFarm::openShop);
		registerCustomCommand("!pv", FalconFarm::openPV1);
		registerCustomCommand("!test", FalconFarm::testFunction);
	}

	// ----------------------------- Chat Message Events -----------------------------

	private boolean onChatMessageSent(String message) {
		LOGGER.info("Received message: " + message);
		for (Map.Entry<String, Consumer<String>> entry : customCommands.entrySet()) {
			if (message.startsWith(entry.getKey())) {
				entry.getValue().accept(message);
				return false; // Prevent further processing of the message
			}
		}
		return true; // Allow the message to be processed normally if no command matches
	}

	private void onChatMessageReceived(Text messageText, SignedMessage signedMessage, GameProfile profile, MessageType.Parameters parameters, Instant timestamp) {
		// Log the message to the console
		LOGGER.info("Received chat message: " + messageText.getString());

		// Optionally log more details about the sender or message metadata
		if (profile != null) {
			LOGGER.info("Message sent by: " + profile.getName());
		}
	}

	public void loadChatEvents()
	{
		ClientSendMessageEvents.ALLOW_CHAT.register(this::onChatMessageSent);
		ClientReceiveMessageEvents.CHAT.register(this::onChatMessageReceived);
	}

	@Override
	public void onInitialize() {

		loadChatEvents();
		loadAllKeyBinds();
		loadAllCustomCommands();

	}

	// ----------------------------- Shop Functions -----------------------------
	public static int DELAY = 100;
	public static int SHOP_DELAY = 1000;
	public static int CONVERSION_DELAY = 50;

	public static void Sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void makeTrade(int offerIndex) {
		Sleep(DELAY);
		for(int i = 0; i < 50; i++){
			client.getNetworkHandler().sendPacket(new SelectMerchantTradeC2SPacket(offerIndex));
			Sleep(200);
			clickSlot(2, false);
			Sleep(50);
		}
	}



	public static int countItemInAllSlots(String name, int start) {
		MinecraftClient client = MinecraftClient.getInstance();
		DefaultedList<Slot> slots = getCurrentScreenSlots(client);

		if (slots == null) {
			return 0;
		}

		int count = 0;
		for (int i = start; i < slots.size(); i++) {
			if (slots.get(i).getStack().getName().getString().equals(name)) {
				count += slots.get(i).getStack().getCount();
			}
		}
		return count;
	}

	public static int countItemInAllSlots(String name) {
		return countItemInAllSlots(name, 0);
	}


	// Helper function to get slots based on the current screen
	private static DefaultedList<Slot> getCurrentScreenSlots(MinecraftClient client) {
		if (client.currentScreen instanceof GenericContainerScreen) {
			return ((GenericContainerScreen) client.currentScreen).getScreenHandler().slots;
		} else if (client.currentScreen instanceof MerchantScreen) {
			return ((MerchantScreen) client.currentScreen).getScreenHandler().slots;
		} else {
			return null;
		}
	}

	public static void clickSlot(int slotIndex, boolean forceScreenChange) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player == null || client.currentScreen == null) return;

		String firstScreen = "";
		if(forceScreenChange)
			firstScreen = client.currentScreen.toString();
		ScreenHandler screenHandler = null;

		if (client.currentScreen instanceof MerchantScreen) {
			screenHandler = ((MerchantScreen) client.currentScreen).getScreenHandler();
		} else if (client.currentScreen instanceof GenericContainerScreen) {
			screenHandler = ((GenericContainerScreen) client.currentScreen).getScreenHandler();
		}

		if (screenHandler != null) {
			client.interactionManager.clickSlot(
					screenHandler.syncId,
					slotIndex,
					0,
					SlotActionType.QUICK_MOVE,
					client.player
			);

			String secondScreen = client.currentScreen.toString();
			while(firstScreen == secondScreen) {
				clickSlot(slotIndex, forceScreenChange);
			}
		}
	}

	public static void waitForScreen(Class<?> screenClass) {
		MinecraftClient client = MinecraftClient.getInstance();
		while (!(screenClass.isInstance(client.currentScreen))) {
			Sleep(100);
		}
	}

	public static void waitForMerchantScreen()
	{
		waitForScreen(MerchantScreen.class);
	}

	public static void waitForGenericContainerScreen()
	{
		waitForScreen(GenericContainerScreen.class);;
	}

	public static void printAllSlots(){
		DefaultedList<Slot> slots = null;
		if(MinecraftClient.getInstance().currentScreen instanceof GenericContainerScreen){
			slots = ((GenericContainerScreen)(MinecraftClient.getInstance().currentScreen)).getScreenHandler().slots;
		}else if(MinecraftClient.getInstance().currentScreen instanceof MerchantScreen){
			slots = ((MerchantScreen)(MinecraftClient.getInstance().currentScreen)).getScreenHandler().slots;
		}
		if(slots == null){
			return;
		}
		LOGGER.info("-------------------");
		for(int i = 0; i < slots.size(); i++){
			if(slots.get(i) != null) {
				LOGGER.info(""+i+": "+slots.get(i).getStack().getName().getString());
			}
		}
		LOGGER.info("-------------------");
	}
	public static void printAllTrades(String fileName) {
		if (!(MinecraftClient.getInstance().currentScreen instanceof MerchantScreen)) {
			return; // Exit if the current screen is not a villager trade screen
		}

		// Get the list of trade offers (recipes)
		List<TradeOffer> offers = ((MerchantScreen) MinecraftClient.getInstance().currentScreen)
				.getScreenHandler().getRecipes();

		if (offers == null || offers.isEmpty()) {
			log("No trades available.", fileName);
			return;
		}

		log("---------- Villager Trades ----------", fileName);

		// Loop through all available trades
		for (int i = 0; i < offers.size(); i++) {
			TradeOffer offer = offers.get(i);

			// Get the first buy item details
			int firstPriceCount = offer.getOriginalFirstBuyItem().getCount();
			String firstPriceName = offer.getOriginalFirstBuyItem().getName().getString();

			// Get the second buy item details (if present)
			int secondPriceCount = offer.getSecondBuyItem().isEmpty() ? 0 : offer.getSecondBuyItem().get().count();
			String secondPriceName = offer.getSecondBuyItem().isEmpty() ? "None" : offer.getSecondBuyItem().get().toString();

			// Get the sell (output) item details
			int sellCount = offer.getSellItem().getCount();
			String sellName = offer.getSellItem().getName().getString();

			// Log all trade details
			log("Trade " + (i + 1) + ":", fileName);
			log("    First Item: " + firstPriceCount + " x " + firstPriceName, fileName);
			log("    Second Item: " + (secondPriceCount > 0 ? secondPriceCount + " x " + secondPriceName : "None"), fileName);
			log("    Result: " + sellCount + " x " + sellName, fileName);
			log("------------------------------------", fileName);
		}
	}

	private static void log(String message, String fileName) {
		if (fileName != null && !fileName.isEmpty()) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
				writer.write(message);
				writer.newLine();
			} catch (IOException e) {
				LOGGER.warn("Failed to write to file: " + e.getMessage());
			}
		} else {
			LOGGER.info(message);
		}
	}



	public static void bigAllTrades()
	{
		if(false) return;
		List<TreeNode> g1 = Arrays.asList(Market.compressOre_P2, Market.decompressOre_P2);
		List<TreeNode> g2 = Arrays.asList(Market.woodenSwords_P2, Market.stoneSwords_P2, Market.ironSwords_P2, Market.diamondSwords_P2, Market.netheriteSwords_P2);
		List<TreeNode> g3 = Arrays.asList(Market.leatherArmors_P2, Market.ironArmors_P2, Market.diamondArmors_P2, Market.netheriteArmors_P2);
		List<TreeNode> g4 = Arrays.asList(Market.woodenPickaxes_P2, Market.stonePickaxes_P2, Market.ironPickaxes_P2, Market.diamondPickaxes_P2, Market.netheritePickaxes_P2);
		List<TreeNode> g5 = Arrays.asList(Market.woodenAxes_P2, Market.stoneAxes_P2, Market.ironAxes_P2, Market.diamondAxes_P2, Market.netheriteAxes_P2);
		List<TreeNode> g6 = Arrays.asList(Market.foods_P2, Market.pvpUtilitys_P2, Market.shulkers_P2,  Market.potions_P2, Market.elytra_P2, Market.blocks_P2);

		List<TreeNode> All = Arrays.asList(Market.compressOre_P2, Market.decompressOre_P2, Market.woodenSwords_P2, Market.stoneSwords_P2, Market.ironSwords_P2, Market.diamondSwords_P2, Market.netheriteSwords_P2, Market.leatherArmors_P2, Market.ironArmors_P2, Market.diamondArmors_P2, Market.netheriteArmors_P2, Market.woodenPickaxes_P2, Market.stonePickaxes_P2, Market.ironPickaxes_P2, Market.diamondPickaxes_P2, Market.netheritePickaxes_P2, Market.woodenAxes_P2, Market.stoneAxes_P2, Market.ironAxes_P2, Market.diamondAxes_P2, Market.netheriteAxes_P2, Market.foods_P2, Market.pvpUtilitys_P2, Market.shulkers_P2,  Market.potions_P2, Market.elytra_P2, Market.blocks_P2);

		Thread thread = new Thread(() -> {
			List<TreeNode> turn = All;
			for(int i = 0; i < turn.size(); i++){
				List<String> path = turn.get(i).getPathFromRoot();
				LOGGER.info("Path of" + turn.get(i) + " is " + path);
				openShop();
				clickSlot(searchSlots(path.get(1), true), true);
				Sleep(1000);
				clickSlot(searchSlots(path.get(2), true), true);
				Sleep(1000);
				LOGGER.info("Trades of" + turn.get(i) );
				printAllTrades(path.get(2) +".txt");
				closeScreen();
				Sleep(1000);
			}
		});
		thread.start();
	}



	// ----------------------------- Helper Functions -----------------------------
	// Make function to send command
	private static void sendCommand(String command) {  client.player.networkHandler.sendChatCommand(command); }


	// Make function to send message
	private static void sendChatMessage(String message) {  client.player.networkHandler.sendChatMessage(message); }

	// ----------------------------- Functions -----------------------------
	// Send a random chat message
	private static void sendRandomChatMessage(String unused) {
		String[] messages = { "Hello guys!", "What's up everyone?", "Hey there!", "How's it going?", "Good day, folks!" };
		String randomMessage = messages[new Random().nextInt(messages.length)];
		sendChatMessage(randomMessage);
	}

	// Send the /shop command

	private static void openShop() {
		sendCommand("shop");
		waitForGenericContainerScreen();
	}

	public static void closeScreen(){
		MinecraftClient.getInstance().execute(()->{
			if(MinecraftClient.getInstance().currentScreen != null){
				MinecraftClient.getInstance().currentScreen.close();
			}
		});
	}
	private static void openShop(String unused) { sendCommand("shop"); }

	// Open PV 1
	private static void openPV1(String unused) { sendCommand("pv 1"); }

	public static int searchSlots(String name, boolean forceSearch) {
		int start = 0;
		MinecraftClient client = MinecraftClient.getInstance();
		DefaultedList<Slot> slots = null;

		if (client.currentScreen instanceof GenericContainerScreen) {
			slots = ((GenericContainerScreen) client.currentScreen).getScreenHandler().slots;
		} else if (client.currentScreen instanceof MerchantScreen) {
			slots = ((MerchantScreen) client.currentScreen).getScreenHandler().slots;
		} else {
			return -1;
		}

		// Search for the slot
		for (int i = start; i < slots.size(); i++) {
			if (name.equals(slots.get(i).getStack().getName().getString())) {
				return i;
			}
		}

		// If not found and force search is enabled, retry
		if (forceSearch) {
			Sleep(100);  // Small delay before retrying
			return searchSlots(name, true);  // Recursive call with forceSearch = true
		}

		// Return -1 if no slot is found and force search is not enabled
		return -1;
	}


	// Make Trade

	public static Slot getSlot(int index){
		if(MinecraftClient.getInstance().currentScreen instanceof GenericContainerScreen){
			return ((GenericContainerScreen)MinecraftClient.getInstance().currentScreen).getScreenHandler().slots.get(index);
		}else if(MinecraftClient.getInstance().currentScreen instanceof MerchantScreen){
			return ((MerchantScreen)MinecraftClient.getInstance().currentScreen).getScreenHandler().slots.get(index);
		}
		return null;
	}


	public static int countEmptySlots(int start){
		DefaultedList<Slot> slots = null;
		int count = 0;
		if(MinecraftClient.getInstance().currentScreen instanceof GenericContainerScreen){
			slots = ((GenericContainerScreen) MinecraftClient.getInstance().currentScreen).getScreenHandler().slots;
		}else if(MinecraftClient.getInstance().currentScreen instanceof MerchantScreen){
			slots = ((MerchantScreen) MinecraftClient.getInstance().currentScreen).getScreenHandler().slots;
		}else{
			return 0;
		}

		for(int i = start; i < slots.size(); i++){
			if(!slots.get(i).hasStack()){
				count++;
			}
		}
		return count;
	}


	// BuyItem
	private static void executeTrade(Trade item) {
		List<String> path = item.getPathFromRoot();
		openShop();
		clickSlot(searchSlots(path.get(1), true), true);
		clickSlot(searchSlots(path.get(2), true), true);
		makeTrade(item.TradeIndex-1);
		closeScreen();
	}

	// Test function to send a signed message
	private static void testFunction(String unused) {
		Thread thread = new Thread(() -> {
			for(int i = 0; i < 10; i++){
				executeTrade(Market.rawGoldToDiamond_t);
				executeTrade(Market.diamondToGoldNugget_t);
				executeTrade(Market.goldNuggetToEmerald_t);
				executeTrade(Market.emeraldToRawGold_t);
			}
		});
		thread.start();
	}
}
