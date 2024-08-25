package com.benj.falconfarm.biso;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
LOGGER
events
debug
player
screen
mixin -> watch packages
 */

public class FarmMod implements ModInitializer {
	public static final String MOD_ID = "farm";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean DEBUG = true;

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		// strting event listener to chat, when message is sent it run this function (onChatMessage)
		ClientSendMessageEvents.ALLOW_CHAT.register(this::onChatMessage);

		// starting event listener to a Tick, the Tick is something like a heart beat for the program
		// that run every 50 milisecond
		// container/

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			// here i check if the current screen is a container screen for example if i'm opening chest
			if (client.currentScreen instanceof GenericContainerScreen) {
				GenericContainerScreen containerScreen = (GenericContainerScreen) client.currentScreen;

				// here i check if the current screen is a MerchantScreen (the villager trade screen)
			}else if(client.currentScreen instanceof MerchantScreen){
				MinecraftClient mc = MinecraftClient.getInstance();
				MerchantScreen screen = (MerchantScreen) client.currentScreen;
//				LOGGER.info(screen.getScreenHandler().slots.get(0).getStack().getName().getString());
//				clickSlot(client, screen, 2);
			}
		});
	}
	private boolean onChatMessage(String s) {
		if(s.startsWith("!")){
			if(s.startsWith("!farm")){
				new Thread(() -> {
					String[] arr = s.split(" ");
					int count = Integer.valueOf(arr[arr.length-1]);
					try{
						while(count > 0) {
							FarmFunctions.compressedRowGoldToDiamond();
							FarmFunctions.diamondToGoldNuggets();
							FarmFunctions.goldenNuggetsToEmerald();
							FarmFunctions.emeraldToCompressedRowGold();
							FarmFunctions.putOneStackInPv();
							count--;
							Thread.sleep(10);
						}
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}).start();
			}else if(s.startsWith("!print")){
				new Thread(() -> {
					try{
						FarmFunctions.openShop();
						Thread.sleep(300);
						FarmFunctions.printAllSlots();
						Thread.sleep(10);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}).start();
			}else if(s.startsWith("!rawtoblock")){
				new Thread(() -> {
					String[] arr = s.split(" ");
					int count = Integer.valueOf(arr[arr.length-1]);
					LOGGER.info(""+count);
					try{
						while(count > 0) {
							FarmFunctions.rawGoldToBlockGold();
							Thread.sleep(100);
							count--;
						}
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}).start();
			}else if(s.startsWith("!rawtoignot")){
				new Thread(() -> {
					String[] arr = s.split(" ");
					int count = Integer.valueOf(arr[arr.length-1]);
					LOGGER.info(""+count);
					try{
						while(count > 0) {
							FarmFunctions.goldIngotToBlockGold();
							Thread.sleep(100);
							count--;
						}
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}).start();
			}
			return false;
		}
		LOGGER.info(s);
		return true;
	}
}