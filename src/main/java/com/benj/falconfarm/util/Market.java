package com.benj.falconfarm.util;

import java.util.Arrays;
import java.util.List;

public class Market {
    public static TreeNode SHOP = new TreeNode("Root");
    public static TreeNode compressors_P1 = SHOP.addNode(new TreeNode("ᴄᴏᴍᴘʀᴇssᴏʀs"));
    public static TreeNode compressOre_P2 = compressors_P1.addNode(new TreeNode("ᴄᴏᴍᴘʀᴇss ᴏʀᴇ"));
    public static Trade cobblestoneToGoldNugget_t = compressOre_P2.addTrade(new Trade(1, "Cobblestone", 64, null, 0, "Golden Nugget", 1));
    public static Trade coalToGoldNugget_t = compressOre_P2.addTrade(new Trade(2, "Coal", 64, null, 0, "Golden Nugget", 2));
    public static Trade ironToGoldNugget_t = compressOre_P2.addTrade(new Trade(3, "Iron Ingot", 64, null, 0, "Golden Nugget", 3));
    public static Trade diamondToGoldNugget_t = compressOre_P2.addTrade(new Trade(4, "Diamond", 12, null, 0, "Golden Nugget", 5));
    public static Trade emeraldToGoldNugget_t = compressOre_P2.addTrade(new Trade(5, "Emerald", 12, null, 0, "Golden Nugget", 6));
    public static Trade ironToRawGold_t = compressOre_P2.addTrade(new Trade(7, "Iron Ingot", 64, "Iron Ingot", 32, "Raw Gold", 2));
    public static Trade diamondToRawGold_t = compressOre_P2.addTrade(new Trade(8, "Diamond", 64, null, 0, "Raw Gold", 3));
    public static Trade emeraldToRawGold_t = compressOre_P2.addTrade(new Trade(9, "Emerald", 64, null, 0, "Raw Gold", 6));
    public static Trade ironToGoldIngot_t = compressOre_P2.addTrade(new Trade(11, "Iron Ingot", 64, "Iron Ingot", 64, "Gold Ingot", 1));
    public static Trade diamondToGoldIngot_t = compressOre_P2.addTrade(new Trade(12, "Diamond", 64, "Diamond", 32, "Gold Ingot", 2));
    public static Trade emeraldToGoldIngot_t = compressOre_P2.addTrade(new Trade(13, "Emerald", 64, "Emerald", 32, "Gold Ingot", 3));
    public static Trade diamondToGoldBlock_t = compressOre_P2.addTrade(new Trade(15, "Diamond", 64, "Diamond", 64, "Gold Block", 1));
    public static Trade emeraldToGoldBlock_t = compressOre_P2.addTrade(new Trade(16, "Emerald", 64, "Emerald", 64, "Gold Block", 2));

    public static TreeNode decompressOre_P2 = compressors_P1.addNode(new TreeNode("ᴅᴇᴄᴏᴍᴘʀᴇss ᴏʀᴇ"));
    public static Trade goldNuggetToCobblestone_t = decompressOre_P2.addTrade(new Trade(1, "Gold Nugget", 1, null, 0, "Cobblestone", 64));
    public static Trade goldNuggetToCoal_t = decompressOre_P2.addTrade(new Trade(2, "Gold Nugget", 2, null, 0, "Coal", 64));
    public static Trade goldNuggetToIron_t = decompressOre_P2.addTrade(new Trade(3, "Gold Nugget", 3, null, 0, "Iron Ingot", 32));
    public static Trade goldNuggetToDiamond_t = decompressOre_P2.addTrade(new Trade(4, "Gold Nugget", 5, null, 0, "Diamond", 12));
    public static Trade goldNuggetToEmerald_t = decompressOre_P2.addTrade(new Trade(5, "Gold Nugget", 6, null, 0, "Emerald", 12));
    public static Trade rawGoldToIron_t = decompressOre_P2.addTrade(new Trade(7, "Raw Gold", 2, "Iron Ingot", 64, "Iron Ingot", 32));
    public static Trade rawGoldToDiamond_t = decompressOre_P2.addTrade(new Trade(8, "Raw Gold", 3, null, 0, "Diamond", 64));
    public static Trade rawGoldToEmerald_t = decompressOre_P2.addTrade(new Trade(9, "Raw Gold", 6, null, 0, "Emerald", 64));
    public static Trade goldIngotToIron_t = decompressOre_P2.addTrade(new Trade(11, "Gold Ingot", 1, "Iron Ingot", 64, "Iron Ingot", 64));
    public static Trade goldIngotToDiamond_t = decompressOre_P2.addTrade(new Trade(12, "Gold Ingot", 2, "Diamond", 64, "Diamond", 32));
    public static Trade goldIngotToEmerald_t = decompressOre_P2.addTrade(new Trade(13, "Gold Ingot", 3, "Emerald", 64, "Emerald", 32));
    public static Trade goldBlockToDiamond_t = decompressOre_P2.addTrade(new Trade(15, "Gold Block", 1, "Diamond", 64, "Diamond", 64));
    public static Trade goldBlockToEmerald_t = decompressOre_P2.addTrade(new Trade(16, "Gold Block", 2, "Emerald", 64, "Emerald", 64));



    public static TreeNode swords_P1 = SHOP.addNode(new TreeNode("sᴡᴏʀᴅs"));
    public static TreeNode woodenSwords_P2 = swords_P1.addNode(new TreeNode("ᴡᴏᴏᴅᴇɴ sᴡᴏʀᴅs"));
    public static Trade goldNuggetToWoodenSword_t = woodenSwords_P2.addTrade(new Trade(1, "Gold Nugget", 1, null, 0, "Wooden Sword", 1));
    public static Trade goldNuggetToWoodenSwordII_t = woodenSwords_P2.addTrade(new Trade(2, "Gold Nugget", 2, "Wooden Sword", 1, "Wooden Sword II", 1));
    public static Trade goldNuggetToWoodenSwordIII_t = woodenSwords_P2.addTrade(new Trade(3, "Gold Nugget", 4, "Wooden Sword", 1, "Wooden Sword III", 1));
    public static Trade goldNuggetToWoodenSwordIV_t = woodenSwords_P2.addTrade(new Trade(4, "Gold Nugget", 4, "Wooden Sword", 1, "Wooden Sword IV", 1));
    public static Trade goldNuggetToWoodenSwordV_t = woodenSwords_P2.addTrade(new Trade(5, "Gold Nugget", 5, "Wooden Sword", 1, "Wooden Sword V", 1));
    public static Trade goldNuggetToWoodenSwordVI_t = woodenSwords_P2.addTrade(new Trade(6, "Gold Nugget", 5, "Wooden Sword", 1, "Wooden Sword VI", 1));
    public static Trade goldNuggetToWoodenSwordVII_t = woodenSwords_P2.addTrade(new Trade(1, "Gold Nugget", 1, null, 0, "Wooden Sword VII", 1));
    public static Trade goldNuggetToWoodenSwordVIII_t = woodenSwords_P2.addTrade(new Trade(2, "Gold Nugget", 2, "Wooden Sword", 1, "Wooden Sword VIII", 1));
    public static Trade goldNuggetToWoodenSwordIX_t = woodenSwords_P2.addTrade(new Trade(3, "Gold Nugget", 4, "Wooden Sword", 1, "Wooden Sword IX", 1));
    public static Trade goldNuggetToWoodenSwordX_t = woodenSwords_P2.addTrade(new Trade(4, "Gold Nugget", 4, "Wooden Sword", 1, "Wooden Sword X", 1));
    public static Trade goldNuggetToWoodenSwordXI_t = woodenSwords_P2.addTrade(new Trade(5, "Gold Nugget", 5, "Wooden Sword", 1, "Wooden Sword XI", 1));
    public static Trade goldNuggetToWoodenSwordXII_t = woodenSwords_P2.addTrade(new Trade(6, "Gold Nugget", 5, "Wooden Sword", 1, "Wooden Sword XII", 1));
    public static TreeNode stoneSwords_P2 = swords_P1.addNode(new TreeNode("sᴛᴏɴᴇ sᴡᴏʀᴅs"));
    public static Trade goldNuggetToStoneSword_t = stoneSwords_P2.addTrade(new Trade(1, "Gold Nugget", 4, "Wooden Sword", 1, "Stone Sword", 1));
    public static Trade goldNuggetToStoneSwordII_t = stoneSwords_P2.addTrade(new Trade(2, "Gold Nugget", 4, "Stone Sword", 1, "Stone Sword II", 1));
    public static Trade goldNuggetToStoneSwordIII_t = stoneSwords_P2.addTrade(new Trade(3, "Gold Nugget", 5, "Stone Sword", 1, "Stone Sword III", 1));
    public static Trade rawgoldToStoneSwordIV_t = stoneSwords_P2.addTrade(new Trade(4, "RawGold", 1, "Stone Sword", 1, "Stone Sword IV", 1));
    public static Trade rawgoldToStoneSwordV_t = stoneSwords_P2.addTrade(new Trade(5, "RawGold", 2, "Stone Sword", 1, "Stone Sword V", 1));
    public static Trade rawgoldToStoneSwordVI_t = stoneSwords_P2.addTrade(new Trade(6, "RawGold", 4, "Stone Sword", 1, "Stone Sword VI", 1));
    public static TreeNode ironSwords_P2 = swords_P1.addNode(new TreeNode("ɪʀᴏɴ sᴡᴏʀᴅs"));
    public static TreeNode diamondSwords_P2 = swords_P1.addNode(new TreeNode("ᴅɪᴀᴍᴏɴᴅ sᴡᴏʀᴅs"));
    public static Trade goldIngotToDiamondSword_t = diamondSwords_P2.addTrade(new Trade(1, "Gold Ingot", 3, "Iron Sword", 1, "Diamond Sword", 1));
    public static Trade goldIngotToDiamondSwordII_t = diamondSwords_P2.addTrade(new Trade(2, "Gold Ingot", 4, "Diamond Sword", 1, "Diamond Sword II", 1));
    public static Trade goldIngotToDiamondSwordIII_t = diamondSwords_P2.addTrade(new Trade(3, "Gold Ingot", 6, "Diamond Sword", 1, "Diamond Sword III", 1));
    public static Trade goldBlockToDiamondSwordIV_t = diamondSwords_P2.addTrade(new Trade(4, "Gold Block", 2, "Diamond Sword", 1, "Diamond Sword IV", 1));
    public static Trade goldBlockToDiamondSwordV_t = diamondSwords_P2.addTrade(new Trade(5, "Gold Block", 4, "Diamond Sword", 1, "Diamond Sword V", 1));
    public static Trade goldBlockToDiamondSwordVI_t = diamondSwords_P2.addTrade(new Trade(6, "Gold Block", 6, "Diamond Sword", 1, "Diamond Sword VI", 1));
    public static TreeNode netheriteSwords_P2 = swords_P1.addNode(new TreeNode("ɴᴇᴛʜᴇʀɪᴛᴇ sᴡᴏʀᴅs"));
    public static Trade goldBlockToNetheriteSword_t = netheriteSwords_P2.addTrade(new Trade(1, "Gold Block", 8, "Diamond Sword", 1, "Netherite Sword", 1));
    public static Trade goldBlockToNetheriteSwordII_t = netheriteSwords_P2.addTrade(new Trade(2, "Gold Block", 10, "Netherite Sword", 1, "Netherite Sword II", 1));
    public static Trade goldBlockToNetheriteSwordIII_t = netheriteSwords_P2.addTrade(new Trade(3, "Gold Block", 12, "Netherite Sword", 1, "Netherite Sword III", 1));
    public static Trade goldBlockToNetheriteSwordIV_t = netheriteSwords_P2.addTrade(new Trade(4, "Gold Block", 14, "Netherite Sword", 1, "Netherite Sword IV", 1));
    public static Trade goldBlockToNetheriteSwordV_t = netheriteSwords_P2.addTrade(new Trade(5, "Gold Block", 16, "Netherite Sword", 1, "Netherite Sword V", 1));
    public static Trade goldBlockToNetheriteSwordVI_t = netheriteSwords_P2.addTrade(new Trade(6, "Gold Block", 18, "Netherite Sword", 1, "Netherite Sword VI", 1));


    public static TreeNode armors_P1 = SHOP.addNode(new TreeNode("ᴀʀᴍᴏʀs"));
    public static TreeNode leatherArmors_P2 = armors_P1.addNode(new TreeNode("ʟᴇᴀᴛʜᴇʀ ᴀʀᴍᴏʀs"));
    public static Trade goldNuggetToLeatherCap_t = leatherArmors_P2.addTrade(new Trade(1, "Gold Nugget", 1, null, 0, "Leather Cap", 1));
    public static Trade goldNuggetToLeatherTunic_t = leatherArmors_P2.addTrade(new Trade(2, "Gold Nugget", 1, null, 0, "Leather Tunic", 1));
    public static Trade goldNuggetToLeatherPants_t = leatherArmors_P2.addTrade(new Trade(3, "Gold Nugget", 1, null, 0, "Leather Pants", 1));
    public static Trade goldNuggetToLeatherBoots_t = leatherArmors_P2.addTrade(new Trade(4, "Gold Nugget", 1, null, 0, "Leather Boots", 1));
    public static Trade goldNuggetToLeatherCapII_t = leatherArmors_P2.addTrade(new Trade(5, "Gold Nugget", 4, "Leather Cap", 1, "Leather Cap II", 1));
    public static Trade goldNuggetToLeatherTunicII_t = leatherArmors_P2.addTrade(new Trade(6, "Gold Nugget", 4, "Leather Tunic", 1, "Leather Tunic II", 1));
    public static Trade goldNuggetToLeatherPantsII_t = leatherArmors_P2.addTrade(new Trade(7, "Gold Nugget", 4, "Leather Pants", 1, "Leather Pants II", 1));
    public static Trade goldNuggetToLeatherBootsII_t = leatherArmors_P2.addTrade(new Trade(8, "Gold Nugget", 4, "Leather Boots", 1, "Leather Boots II", 1));
    public static Trade goldNuggetToLeatherCapIII_t = leatherArmors_P2.addTrade(new Trade(9, "Gold Nugget", 6, "Leather Cap", 1, "Leather Cap III", 1));
    public static Trade goldNuggetToLeatherTunicIII_t = leatherArmors_P2.addTrade(new Trade(10, "Gold Nugget", 6, "Leather Tunic", 1, "Leather Tunic III", 1));
    public static Trade goldNuggetToLeatherPantsIII_t = leatherArmors_P2.addTrade(new Trade(11, "Gold Nugget", 6, "Leather Pants", 1, "Leather Pants III", 1));
    public static Trade goldNuggetToLeatherBootsIII_t = leatherArmors_P2.addTrade(new Trade(12, "Gold Nugget", 6, "Leather Boots", 1, "Leather Boots III", 1));
    public static Trade goldNuggetToLeatherCapIV_t = leatherArmors_P2.addTrade(new Trade(13, "Gold Nugget", 8, "Leather Cap", 1, "Leather Cap IV", 1));
    public static Trade goldNuggetToLeatherTunicIV_t = leatherArmors_P2.addTrade(new Trade(14, "Gold Nugget", 8, "Leather Tunic", 1, "Leather Tunic IV", 1));
    public static Trade goldNuggetToLeatherPantsIV_t = leatherArmors_P2.addTrade(new Trade(15, "Gold Nugget", 8, "Leather Pants", 1, "Leather Pants IV", 1));
    public static Trade goldNuggetToLeatherBootsIV_t = leatherArmors_P2.addTrade(new Trade(16, "Gold Nugget", 8, "Leather Boots", 1, "Leather Boots IV", 1));
    public static TreeNode ironArmors_P2 = armors_P1.addNode(new TreeNode("ɪʀᴏɴ ᴀʀᴍᴏʀs"));
    public static Trade rawgoldToIronHelmet_t = ironArmors_P2.addTrade(new Trade(1, "RawGold", 2, "Leather Cap", 1, "Iron Helmet", 1));
    public static Trade rawgoldToIronChestplate_t = ironArmors_P2.addTrade(new Trade(2, "RawGold", 2, "Leather Tunic", 1, "Iron Chestplate", 1));
    public static Trade rawgoldToIronLeggings_t = ironArmors_P2.addTrade(new Trade(3, "RawGold", 2, "Leather Pants", 1, "Iron Leggings", 1));
    public static Trade rawgoldToIronBoots_t = ironArmors_P2.addTrade(new Trade(4, "RawGold", 2, "Leather Boots", 1, "Iron Boots", 1));
    public static Trade rawgoldToIronHelmetII_t = ironArmors_P2.addTrade(new Trade(5, "RawGold", 4, "Iron Helmet", 1, "Iron Helmet II", 1));
    public static Trade rawgoldToIronChestplateII_t = ironArmors_P2.addTrade(new Trade(6, "RawGold", 4, "Iron Chestplate", 1, "Iron Chestplate II", 1));
    public static Trade rawgoldToIronLeggingsII_t = ironArmors_P2.addTrade(new Trade(7, "RawGold", 4, "Iron Leggings", 1, "Iron Leggings II", 1));
    public static Trade rawgoldToIronBootsII_t = ironArmors_P2.addTrade(new Trade(8, "RawGold", 4, "Iron Boots", 1, "Iron Boots II", 1));
    public static Trade goldIngotToIronHelmetIII_t = ironArmors_P2.addTrade(new Trade(9, "Gold Ingot", 3, "Iron Helmet", 1, "Iron Helmet III", 1));
    public static Trade goldIngotToIronChestplateIII_t = ironArmors_P2.addTrade(new Trade(10, "Gold Ingot", 3, "Iron Chestplate", 1, "Iron Chestplate III", 1));
    public static Trade goldIngotToIronLeggingsIII_t = ironArmors_P2.addTrade(new Trade(11, "Gold Ingot", 3, "Iron Leggings", 1, "Iron Leggings III", 1));
    public static Trade goldIngotToIronBootsIII_t = ironArmors_P2.addTrade(new Trade(12, "Gold Ingot", 3, "Iron Boots", 1, "Iron Boots III", 1));
    public static TreeNode diamondArmors_P2 = armors_P1.addNode(new TreeNode("ᴅɪᴀᴍᴏɴᴅ ᴀʀᴍᴏʀs"));
    public static Trade goldIngotToDiamondHelmet_t = diamondArmors_P2.addTrade(new Trade(1, "Gold Ingot", 4, "Iron Helmet", 1, "Diamond Helmet", 1));
    public static Trade goldIngotToDiamondChestplate_t = diamondArmors_P2.addTrade(new Trade(2, "Gold Ingot", 4, "Iron Chestplate", 1, "Diamond Chestplate", 1));
    public static Trade goldIngotToDiamondLeggings_t = diamondArmors_P2.addTrade(new Trade(3, "Gold Ingot", 4, "Iron Leggings", 1, "Diamond Leggings", 1));
    public static Trade goldIngotToDiamondBoots_t = diamondArmors_P2.addTrade(new Trade(4, "Gold Ingot", 4, "Iron Boots", 1, "Diamond Boots", 1));
    public static Trade goldIngotToDiamondHelmetII_t = diamondArmors_P2.addTrade(new Trade(5, "Gold Ingot", 6, "Diamond Helmet", 1, "Diamond Helmet II", 1));
    public static Trade goldIngotToDiamondChestplateII_t = diamondArmors_P2.addTrade(new Trade(6, "Gold Ingot", 6, "Diamond Chestplate", 1, "Diamond Chestplate II", 1));
    public static Trade goldIngotToDiamondLeggingsII_t = diamondArmors_P2.addTrade(new Trade(7, "Gold Ingot", 6, "Diamond Leggings", 1, "Diamond Leggings II", 1));
    public static Trade goldIngotToDiamondBootsII_t = diamondArmors_P2.addTrade(new Trade(8, "Gold Ingot", 6, "Diamond Boots", 1, "Diamond Boots II", 1));
    public static Trade goldBlockToDiamondHelmetIII_t = diamondArmors_P2.addTrade(new Trade(9, "Gold Block", 3, "Diamond Helmet", 1, "Diamond Helmet III", 1));
    public static Trade goldBlockToDiamondChestplateIII_t = diamondArmors_P2.addTrade(new Trade(10, "Gold Block", 3, "Diamond Chestplate", 1, "Diamond Chestplate III", 1));
    public static Trade goldBlockToDiamondLeggingsIII_t = diamondArmors_P2.addTrade(new Trade(11, "Gold Block", 3, "Diamond Leggings", 1, "Diamond Leggings III", 1));
    public static Trade goldBlockToDiamondBootsIII_t = diamondArmors_P2.addTrade(new Trade(12, "Gold Block", 3, "Diamond Boots", 1, "Diamond Boots III", 1));
    public static TreeNode netheriteArmors_P2 = armors_P1.addNode(new TreeNode("ɴᴇᴛʜᴇʀɪᴛᴇ ᴀʀᴍᴏʀs"));
    public static Trade goldBlockToNetheriteHelmet_t = netheriteArmors_P2.addTrade(new Trade(1, "Gold Block", 7, "Diamond Helmet", 1, "Netherite Helmet", 1));
    public static Trade goldBlockToNetheriteChestplate_t = netheriteArmors_P2.addTrade(new Trade(2, "Gold Block", 7, "Diamond Chestplate", 1, "Netherite Chestplate", 1));
    public static Trade goldBlockToNetheriteLeggings_t = netheriteArmors_P2.addTrade(new Trade(3, "Gold Block", 7, "Diamond Leggings", 1, "Netherite Leggings", 1));
    public static Trade goldBlockToNetheriteBoots_t = netheriteArmors_P2.addTrade(new Trade(4, "Gold Block", 7, "Diamond Boots", 1, "Netherite Boots", 1));
    public static Trade goldBlockToNetheriteHelmetII_t = netheriteArmors_P2.addTrade(new Trade(5, "Gold Block", 9, "Netherite Helmet", 1, "Netherite Helmet II", 1));
    public static Trade goldBlockToNetheriteChestplateII_t = netheriteArmors_P2.addTrade(new Trade(6, "Gold Block", 9, "Netherite Chestplate", 1, "Netherite Chestplate II", 1));
    public static Trade goldBlockToNetheriteLeggingsII_t = netheriteArmors_P2.addTrade(new Trade(7, "Gold Block", 9, "Netherite Leggings", 1, "Netherite Leggings II", 1));
    public static Trade goldBlockToNetheriteBootsII_t = netheriteArmors_P2.addTrade(new Trade(8, "Gold Block", 9, "Netherite Boots", 1, "Netherite Boots II", 1));
    public static Trade goldBlockToNetheriteHelmetIII_t = netheriteArmors_P2.addTrade(new Trade(9, "Gold Block", 11, "Netherite Helmet", 1, "Netherite Helmet III", 1));
    public static Trade goldBlockToNetheriteChestplateIII_t = netheriteArmors_P2.addTrade(new Trade(10, "Gold Block", 11, "Netherite Chestplate", 1, "Netherite Chestplate III", 1));
    public static Trade goldBlockToNetheriteLeggingsIII_t = netheriteArmors_P2.addTrade(new Trade(11, "Gold Block", 11, "Netherite Leggings", 1, "Netherite Leggings III", 1));
    public static Trade goldBlockToNetheriteBootsIII_t = netheriteArmors_P2.addTrade(new Trade(12, "Gold Block", 11, "Netherite Boots", 1, "Netherite Boots III", 1));
    public static Trade goldBlockToNetheriteHelmetIV_t = netheriteArmors_P2.addTrade(new Trade(13, "Gold Block", 13, "Netherite Helmet", 1, "Netherite Helmet IV", 1));
    public static Trade goldBlockToNetheriteChestplateIV_t = netheriteArmors_P2.addTrade(new Trade(14, "Gold Block", 13, "Netherite Chestplate", 1, "Netherite Chestplate IV", 1));
    public static Trade goldBlockToNetheriteLeggingsIV_t = netheriteArmors_P2.addTrade(new Trade(15, "Gold Block", 13, "Netherite Leggings", 1, "Netherite Leggings IV", 1));
    public static Trade goldBlockToNetheriteBootsIV_t = netheriteArmors_P2.addTrade(new Trade(16, "Gold Block", 13, "Netherite Boots", 1, "Netherite Boots IV", 1));

    public static TreeNode pickaxes_P1 = SHOP.addNode(new TreeNode("ᴘɪᴄᴋᴀxᴇs"));
    public static TreeNode woodenPickaxes_P2 = pickaxes_P1.addNode(new TreeNode("ᴡᴏᴏᴅᴇɴ ᴘɪᴄᴋᴀxᴇs"));
    public static Trade goldNuggetToWoodenPickaxe_t = woodenPickaxes_P2.addTrade(new Trade(1, "Gold Nugget", 1, null, 0, "Wooden Pickaxe", 1));
    public static Trade goldNuggetToWoodenPickaxeII_t = woodenPickaxes_P2.addTrade(new Trade(2, "Gold Nugget", 2, "Wooden Pickaxe", 1, "Wooden Pickaxe II", 1));
    public static Trade goldNuggetToWoodenPickaxeIII_t = woodenPickaxes_P2.addTrade(new Trade(3, "Gold Nugget", 4, "Wooden Pickaxe", 1, "Wooden Pickaxe III", 1));
    public static Trade goldNuggetToWoodenPickaxeIV_t = woodenPickaxes_P2.addTrade(new Trade(4, "Gold Nugget", 4, "Wooden Pickaxe", 1, "Wooden Pickaxe IV", 1));
    public static Trade goldNuggetToWoodenPickaxeV_t = woodenPickaxes_P2.addTrade(new Trade(5, "Gold Nugget", 5, "Wooden Pickaxe", 1, "Wooden Pickaxe V", 1));
    public static Trade goldNuggetToWoodenPickaxeVI_t = woodenPickaxes_P2.addTrade(new Trade(6, "Gold Nugget", 5, "Wooden Pickaxe", 1, "Wooden Pickaxe VI", 1));
    public static TreeNode stonePickaxes_P2 = pickaxes_P1.addNode(new TreeNode("sᴛᴏɴᴇ ᴘɪᴄᴋᴀxᴇs"));
    public static Trade goldNuggetToStonePickaxe_t = stonePickaxes_P2.addTrade(new Trade(1, "Gold Nugget", 4, "Wooden Pickaxe", 1, "Stone Pickaxe", 1));
    public static Trade goldNuggetToStonePickaxeII_t = stonePickaxes_P2.addTrade(new Trade(2, "Gold Nugget", 4, "Stone Pickaxe", 1, "Stone Pickaxe II", 1));
    public static Trade goldNuggetToStonePickaxeIII_t = stonePickaxes_P2.addTrade(new Trade(3, "Gold Nugget", 5, "Stone Pickaxe", 1, "Stone Pickaxe III", 1));
    public static Trade rawgoldToStonePickaxeIV_t = stonePickaxes_P2.addTrade(new Trade(4, "RawGold", 1, "Stone Pickaxe", 1, "Stone Pickaxe IV", 1));
    public static Trade rawgoldToStonePickaxeV_t = stonePickaxes_P2.addTrade(new Trade(5, "RawGold", 2, "Stone Pickaxe", 1, "Stone Pickaxe V", 1));
    public static Trade rawgoldToStonePickaxeVI_t = stonePickaxes_P2.addTrade(new Trade(6, "RawGold", 4, "Stone Pickaxe", 1, "Stone Pickaxe VI", 1));
    public static TreeNode ironPickaxes_P2 = pickaxes_P1.addNode(new TreeNode("ɪʀᴏɴ ᴘɪᴄᴋᴀxᴇs"));
    public static Trade rawgoldToIronPickaxe_t = ironPickaxes_P2.addTrade(new Trade(1, "RawGold", 4, "Stone Pickaxe", 1, "Iron Pickaxe", 1));
    public static Trade rawgoldToIronPickaxeII_t = ironPickaxes_P2.addTrade(new Trade(2, "RawGold", 6, "Iron Pickaxe", 1, "Iron Pickaxe II", 1));
    public static Trade goldIngotToIronPickaxeIII_t = ironPickaxes_P2.addTrade(new Trade(3, "Gold Ingot", 1, "Iron Pickaxe", 1, "Iron Pickaxe III", 1));
    public static Trade goldIngotToIronPickaxeIV_t = ironPickaxes_P2.addTrade(new Trade(4, "Gold Ingot", 2, "Iron Pickaxe", 1, "Iron Pickaxe IV", 1));
    public static Trade goldIngotToIronPickaxeV_t = ironPickaxes_P2.addTrade(new Trade(5, "Gold Ingot", 3, "Iron Pickaxe", 1, "Iron Pickaxe V", 1));
    public static Trade goldIngotToIronPickaxeVI_t = ironPickaxes_P2.addTrade(new Trade(6, "Gold Ingot", 5, "Iron Pickaxe", 1, "Iron Pickaxe VI", 1));
    public static TreeNode diamondPickaxes_P2 = pickaxes_P1.addNode(new TreeNode("ᴅɪᴀᴍᴏɴᴅ ᴘɪᴄᴋᴀxᴇs"));
    public static Trade goldIngotToDiamondPickaxe_t = diamondPickaxes_P2.addTrade(new Trade(1, "Gold Ingot", 3, "Iron Pickaxe", 1, "Diamond Pickaxe", 1));
    public static Trade goldIngotToDiamondPickaxeII_t = diamondPickaxes_P2.addTrade(new Trade(2, "Gold Ingot", 4, "Diamond Pickaxe", 1, "Diamond Pickaxe II", 1));
    public static Trade goldIngotToDiamondPickaxeIII_t = diamondPickaxes_P2.addTrade(new Trade(3, "Gold Ingot", 6, "Diamond Pickaxe", 1, "Diamond Pickaxe III", 1));
    public static Trade goldBlockToDiamondPickaxeIV_t = diamondPickaxes_P2.addTrade(new Trade(4, "Gold Block", 2, "Diamond Pickaxe", 1, "Diamond Pickaxe IV", 1));
    public static Trade goldBlockToDiamondPickaxeV_t = diamondPickaxes_P2.addTrade(new Trade(5, "Gold Block", 4, "Diamond Pickaxe", 1, "Diamond Pickaxe V", 1));
    public static Trade goldBlockToDiamondPickaxeVI_t = diamondPickaxes_P2.addTrade(new Trade(6, "Gold Block", 6, "Diamond Pickaxe", 1, "Diamond Pickaxe VI", 1));
    public static TreeNode netheritePickaxes_P2 = pickaxes_P1.addNode(new TreeNode("ɴᴇᴛʜᴇʀɪᴛᴇ ᴘɪᴄᴋᴀxᴇs"));
    public static Trade goldBlockToNetheritePickaxe_t = netheritePickaxes_P2.addTrade(new Trade(1, "Gold Block", 8, "Diamond Pickaxe", 1, "Netherite Pickaxe", 1));
    public static Trade goldBlockToNetheritePickaxeII_t = netheritePickaxes_P2.addTrade(new Trade(2, "Gold Block", 10, "Netherite Pickaxe", 1, "Netherite Pickaxe II", 1));
    public static Trade goldBlockToNetheritePickaxeIII_t = netheritePickaxes_P2.addTrade(new Trade(3, "Gold Block", 12, "Netherite Pickaxe", 1, "Netherite Pickaxe III", 1));
    public static Trade goldBlockToNetheritePickaxeIV_t = netheritePickaxes_P2.addTrade(new Trade(4, "Gold Block", 14, "Netherite Pickaxe", 1, "Netherite Pickaxe IV", 1));
    public static Trade goldBlockToNetheritePickaxeV_t = netheritePickaxes_P2.addTrade(new Trade(5, "Gold Block", 16, "Netherite Pickaxe", 1, "Netherite Pickaxe V", 1));
    public static Trade goldBlockToNetheritePickaxeVI_t = netheritePickaxes_P2.addTrade(new Trade(6, "Gold Block", 18, "Netherite Pickaxe", 1, "Netherite Pickaxe VI", 1));




    public static TreeNode axes_P1 = SHOP.addNode(new TreeNode("ᴀxᴇs"));
    public static TreeNode woodenAxes_P2 = axes_P1.addNode(new TreeNode("ᴡᴏᴏᴅᴇɴ ᴀxᴇs"));
    public static Trade goldNuggetToWoodenAxe_t = woodenAxes_P2.addTrade(new Trade(1, "Gold Nugget", 2, null, 0, "Wooden Axe", 1));
    public static Trade goldNuggetToWoodenAxeII_t = woodenAxes_P2.addTrade(new Trade(2, "Gold Nugget", 2, "Wooden Axe", 1, "Wooden Axe II", 1));
    public static Trade goldNuggetToWoodenAxeIII_t = woodenAxes_P2.addTrade(new Trade(3, "Gold Nugget", 4, "Wooden Axe", 1, "Wooden Axe III", 1));
    public static Trade goldNuggetToWoodenAxeIV_t = woodenAxes_P2.addTrade(new Trade(4, "Gold Nugget", 4, "Wooden Axe", 1, "Wooden Axe IV", 1));
    public static Trade goldNuggetToWoodenAxeV_t = woodenAxes_P2.addTrade(new Trade(5, "Gold Nugget", 5, "Wooden Axe", 1, "Wooden Axe V", 1));
    public static Trade goldNuggetToWoodenAxeVI_t = woodenAxes_P2.addTrade(new Trade(6, "Gold Nugget", 5, "Wooden Axe", 1, "Wooden Axe VI", 1));
    public static TreeNode stoneAxes_P2 = axes_P1.addNode(new TreeNode("sᴛᴏɴᴇ ᴀxᴇs"));
    public static Trade goldNuggetToStoneAxe_t = stoneAxes_P2.addTrade(new Trade(1, "Gold Nugget", 4, "Wooden Axe", 1, "Stone Axe", 1));
    public static Trade goldNuggetToStoneAxeII_t = stoneAxes_P2.addTrade(new Trade(2, "Gold Nugget", 4, "Stone Axe", 1, "Stone Axe II", 1));
    public static Trade goldNuggetToStoneAxeIII_t = stoneAxes_P2.addTrade(new Trade(3, "Gold Nugget", 5, "Stone Axe", 1, "Stone Axe III", 1));
    public static Trade rawgoldToStoneAxeIV_t = stoneAxes_P2.addTrade(new Trade(4, "RawGold", 1, "Stone Axe", 1, "Stone Axe IV", 1));
    public static Trade rawgoldToStoneAxeV_t = stoneAxes_P2.addTrade(new Trade(5, "RawGold", 2, "Stone Axe", 1, "Stone Axe V", 1));
    public static Trade rawgoldToStoneAxeVI_t = stoneAxes_P2.addTrade(new Trade(6, "RawGold", 4, "Stone Axe", 1, "Stone Axe VI", 1));
    public static TreeNode ironAxes_P2 = axes_P1.addNode(new TreeNode("ɪʀᴏɴ ᴀxᴇs"));
    public static Trade rawgoldToIronAxe_t = ironAxes_P2.addTrade(new Trade(1, "RawGold", 4, "Stone Axe", 1, "Iron Axe", 1));
    public static Trade rawgoldToIronAxeII_t = ironAxes_P2.addTrade(new Trade(2, "RawGold", 6, "Iron Axe", 1, "Iron Axe II", 1));
    public static Trade goldIngotToIronAxeIII_t = ironAxes_P2.addTrade(new Trade(3, "Gold Ingot", 1, "Iron Axe", 1, "Iron Axe III", 1));
    public static Trade goldIngotToIronAxeIV_t = ironAxes_P2.addTrade(new Trade(4, "Gold Ingot", 2, "Iron Axe", 1, "Iron Axe IV", 1));
    public static Trade goldIngotToIronAxeV_t = ironAxes_P2.addTrade(new Trade(5, "Gold Ingot", 3, "Iron Axe", 1, "Iron Axe V", 1));
    public static Trade goldIngotToIronAxeVI_t = ironAxes_P2.addTrade(new Trade(6, "Gold Ingot", 5, "Iron Axe", 1, "Iron Axe VI", 1));
    public static TreeNode diamondAxes_P2 = axes_P1.addNode(new TreeNode("ᴅɪᴀᴍᴏɴᴅ ᴀxᴇs"));
    public static Trade goldIngotToDiamondAxe_t = diamondAxes_P2.addTrade(new Trade(1, "Gold Ingot", 3, "Iron Axe", 1, "Diamond Axe", 1));
    public static Trade goldIngotToDiamondAxeII_t = diamondAxes_P2.addTrade(new Trade(2, "Gold Ingot", 4, "Diamond Axe", 1, "Diamond Axe II", 1));
    public static Trade goldIngotToDiamondAxeIII_t = diamondAxes_P2.addTrade(new Trade(3, "Gold Ingot", 6, "Diamond Axe", 1, "Diamond Axe III", 1));
    public static Trade goldBlockToDiamondAxeIV_t = diamondAxes_P2.addTrade(new Trade(4, "Gold Block", 2, "Diamond Axe", 1, "Diamond Axe IV", 1));
    public static Trade goldBlockToDiamondAxeV_t = diamondAxes_P2.addTrade(new Trade(5, "Gold Block", 4, "Diamond Axe", 1, "Diamond Axe V", 1));
    public static Trade goldBlockToDiamondAxeVI_t = diamondAxes_P2.addTrade(new Trade(6, "Gold Block", 6, "Diamond Axe", 1, "Diamond Axe VI", 1));
    public static TreeNode netheriteAxes_P2 = axes_P1.addNode(new TreeNode("ɴᴇᴛʜᴇʀɪᴛᴇ ᴀxᴇs"));
    public static Trade goldBlockToNetheriteAxe_t = netheriteAxes_P2.addTrade(new Trade(1, "Gold Block", 8, "Diamond Axe", 1, "Netherite Axe", 1));
    public static Trade goldBlockToNetheriteAxeII_t = netheriteAxes_P2.addTrade(new Trade(2, "Gold Block", 10, "Netherite Axe", 1, "Netherite Axe II", 1));
    public static Trade goldBlockToNetheriteAxeIII_t = netheriteAxes_P2.addTrade(new Trade(3, "Gold Block", 12, "Netherite Axe", 1, "Netherite Axe III", 1));
    public static Trade goldBlockToNetheriteAxeIV_t = netheriteAxes_P2.addTrade(new Trade(4, "Gold Block", 14, "Netherite Axe", 1, "Netherite Axe IV", 1));
    public static Trade goldBlockToNetheriteAxeV_t = netheriteAxes_P2.addTrade(new Trade(5, "Gold Block", 16, "Netherite Axe", 1, "Netherite Axe V", 1));
    public static Trade goldBlockToNetheriteAxeVI_t = netheriteAxes_P2.addTrade(new Trade(6, "Gold Block", 18, "Netherite Axe", 1, "Netherite Axe VI", 1));

    public static TreeNode misc_P1 = SHOP.addNode(new TreeNode("ᴍɪsᴄ"));
    public static TreeNode foods_P2 = misc_P1.addNode(new TreeNode("ғᴏᴏᴅs"));
    public static Trade goldNuggetToSteak_t = foods_P2.addTrade(new Trade(1, "Gold Nugget", 4, null, 0, "Steak", 32));
    public static Trade goldBlockToGoldCarrot_t = foods_P2.addTrade(new Trade(2, "Gold Block", 1, null, 0, "GoldCarrot", 16));
    public static Trade goldBlockToGoldApple_t = foods_P2.addTrade(new Trade(3, "Gold Block", 16, null, 0, "GoldApple", 2));
    public static Trade goldBlockToEnchantedGoldApple_t = foods_P2.addTrade(new Trade(4, "Gold Block", 32, null, 0, "Enchanted GoldApple", 1));
    public static Trade goldBlockToEnchantedGoldAppleII_t = foods_P2.addTrade(new Trade(5, "Gold Block", 64, null, 0, "Enchanted GoldApple II", 2));
    public static TreeNode pvpUtilitys_P2 = misc_P1.addNode(new TreeNode("ᴘᴠᴘ ᴜᴛɪʟɪᴛɪᴇs"));
    public static Trade goldIngotToObsidian_t = pvpUtilitys_P2.addTrade(new Trade(1, "Gold Ingot", 10, null, 0, "Obsidian", 16));
    public static Trade goldIngotToEndCrystal_t = pvpUtilitys_P2.addTrade(new Trade(2, "Gold Ingot", 10, "ᴄᴏᴍᴘʀᴇssᴇᴅ ʀᴀᴡ ɢᴏʟᴅ", 10, "End Crystal", 1));
    public static Trade rawgoldToShield_t = pvpUtilitys_P2.addTrade(new Trade(3, "RawGold", 6, null, 0, "Shield", 1));
    public static Trade rawgoldToShieldII_t = pvpUtilitys_P2.addTrade(new Trade(4, "RawGold", 12, null, 0, "Shield II", 1));
    public static Trade rawgoldToShieldIII_t = pvpUtilitys_P2.addTrade(new Trade(5, "RawGold", 32, null, 0, "Shield III", 1));
    public static Trade rawgoldToBow_t = pvpUtilitys_P2.addTrade(new Trade(6, "RawGold", 1, null, 0, "Bow", 1));
    public static Trade rawgoldToBowII_t = pvpUtilitys_P2.addTrade(new Trade(7, "RawGold", 4, null, 0, "Bow II", 1));
    public static Trade rawgoldToBowIII_t = pvpUtilitys_P2.addTrade(new Trade(8, "RawGold", 12, null, 0, "Bow III", 1));
    public static Trade rawgoldToBowIV_t = pvpUtilitys_P2.addTrade(new Trade(9, "RawGold", 48, null, 0, "Bow IV", 1));
    public static Trade rawgoldToBowV_t = pvpUtilitys_P2.addTrade(new Trade(10, "RawGold", 64, null, 0, "Bow V", 1));
    public static Trade goldIngotToBowVI_t = pvpUtilitys_P2.addTrade(new Trade(11, "Gold Ingot", 2, null, 0, "Bow VI", 1));
    public static Trade goldIngotToBowVII_t = pvpUtilitys_P2.addTrade(new Trade(12, "Gold Ingot", 1, null, 0, "Bow VII", 1));
    public static Trade goldNuggetToArrow_t = pvpUtilitys_P2.addTrade(new Trade(13, "Gold Nugget", 32, null, 0, "Arrow", 6));
    public static Trade goldNuggetToSpectralArrow_t = pvpUtilitys_P2.addTrade(new Trade(14, "Gold Nugget", 32, null, 0, "Spectral Arrow", 1));
    public static Trade goldIngotToArrowofHarming_t = pvpUtilitys_P2.addTrade(new Trade(15, "Gold Ingot", 1, null, 0, "Arrow of Harming", 1));
    public static Trade goldIngotToArrowofHarmingII_t = pvpUtilitys_P2.addTrade(new Trade(16, "Gold Ingot", 2, null, 0, "Arrow of Harming II", 1));
    public static Trade rawgoldToShears_t = pvpUtilitys_P2.addTrade(new Trade(17, "RawGold", 1, null, 0, "Shears", 1));
    public static Trade rawgoldToShearsII_t = pvpUtilitys_P2.addTrade(new Trade(18, "RawGold", 4, null, 0, "Shears II", 1));
    public static Trade rawgoldToShearsIII_t = pvpUtilitys_P2.addTrade(new Trade(19, "RawGold", 7, null, 0, "Shears III", 1));
    public static Trade rawgoldToCobweb_t = pvpUtilitys_P2.addTrade(new Trade(20, "RawGold", 32, null, 0, "Cobweb", 16));
    public static Trade goldBlockToTotemofUndying_t = pvpUtilitys_P2.addTrade(new Trade(21, "Gold Block", 64, "ᴄᴏᴍᴘʀᴇssᴇᴅ ɢᴏʟᴅ ʙʟᴏᴄᴋ", 32, "Totem of Undying", 1));

    public static TreeNode shulkers_P2 = misc_P1.addNode(new TreeNode("sʜᴜʟᴋᴇʀs"));
    public static Trade rawgoldToBox_t = shulkers_P2.addTrade(new Trade(1, "RawGold", 3, null, 0, "Box", 1));
    public static Trade rawgoldToWhiteBox_t = shulkers_P2.addTrade(new Trade(2, "RawGold", 3, null, 0, "White Box", 1));
    public static Trade rawgoldToOrangeBox_t = shulkers_P2.addTrade(new Trade(3, "RawGold", 3, null, 0, "Orange Box", 1));
    public static Trade rawgoldToMagentaBox_t = shulkers_P2.addTrade(new Trade(4, "RawGold", 3, null, 0, "Magenta Box", 1));
    public static Trade rawgoldToLightBlueBox_t = shulkers_P2.addTrade(new Trade(5, "RawGold", 3, null, 0, "Light Blue Box", 1));
    public static Trade rawgoldToYellowBox_t = shulkers_P2.addTrade(new Trade(6, "RawGold", 3, null, 0, "Yellow Box", 1));
    public static Trade rawgoldToLimeBox_t = shulkers_P2.addTrade(new Trade(7, "RawGold", 3, null, 0, "Lime Box", 1));
    public static Trade rawgoldToPinkBox_t = shulkers_P2.addTrade(new Trade(8, "RawGold", 3, null, 0, "Pink Box", 1));
    public static Trade rawgoldToRedBox_t = shulkers_P2.addTrade(new Trade(9, "RawGold", 3, null, 0, "Red Box", 1));
    public static Trade rawgoldToPurpleBox_t = shulkers_P2.addTrade(new Trade(10, "RawGold", 3, null, 0, "Purple Box", 1));
    public static Trade rawgoldToCyanBox_t = shulkers_P2.addTrade(new Trade(11, "RawGold", 3, null, 0, "Cyan Box", 1));
    public static Trade rawgoldToBlueBox_t = shulkers_P2.addTrade(new Trade(12, "RawGold", 3, null, 0, "Blue Box", 1));
    public static Trade rawgoldToBrownBox_t = shulkers_P2.addTrade(new Trade(13, "RawGold", 3, null, 0, "Brown Box", 1));
    public static Trade rawgoldToLightGrayBox_t = shulkers_P2.addTrade(new Trade(14, "RawGold", 3, null, 0, "Light Gray Box", 1));
    public static Trade rawgoldToGrayBox_t = shulkers_P2.addTrade(new Trade(15, "RawGold", 3, null, 0, "Gray Box", 1));
    public static Trade rawgoldToBlackBox_t = shulkers_P2.addTrade(new Trade(16, "RawGold", 3, null, 0, "Black Box", 1));
    public static TreeNode potions_P2 = misc_P1.addNode(new TreeNode("ᴘᴏᴛɪᴏɴs"));
    public static Trade rawgoldToPotionofInvisibility_t = potions_P2.addTrade(new Trade(1, "RawGold", 3, null, 0, "Potion of Invisibility", 1));
    public static Trade rawgoldToPotionofFireResistance_t = potions_P2.addTrade(new Trade(2, "RawGold", 3, null, 0, "Potion of Fire Resistance", 1));
    public static Trade rawgoldToPotionofSwiftness_t = potions_P2.addTrade(new Trade(3, "RawGold", 3, null, 0, "Potion of Swiftness", 1));
    public static Trade rawgoldToSplashPotionofHealing_t = potions_P2.addTrade(new Trade(4, "RawGold", 4, null, 0, "Splash Potion of Healing", 1));
    public static Trade rawgoldToPotionofStrength_t = potions_P2.addTrade(new Trade(5, "RawGold", 8, null, 0, "Potion of Strength", 1));
    public static Trade rawgoldToSplashPotionofRegeneration_t = potions_P2.addTrade(new Trade(6, "RawGold", 3, null, 0, "Splash Potion of Regeneration", 1));
    public static Trade rawgoldToSplashPotionofSlowFalling_t = potions_P2.addTrade(new Trade(7, "RawGold", 3, null, 0, "Splash Potion of Slow Falling", 1));
    public static Trade rawgoldToSplashPotionofSlowness_t = potions_P2.addTrade(new Trade(8, "RawGold", 4, null, 0, "Splash Potion of Slowness", 1));
    public static Trade rawgoldToSplashPotionofHarming_t = potions_P2.addTrade(new Trade(9, "RawGold", 10, null, 0, "Splash Potion of Harming", 1));
    public static Trade rawgoldToSplashPotionofPoison_t = potions_P2.addTrade(new Trade(10, "RawGold", 12, null, 0, "Splash Potion of Poison", 1));
    public static TreeNode elytra_P2 = misc_P1.addNode(new TreeNode("ᴇʟʏᴛʀᴀ"));
    public static Trade goldNuggetToFirework_t = elytra_P2.addTrade(new Trade(1, "Gold Nugget", 3, null, 0, "Firework", 12));
    public static Trade rawGoldToFireworkII_t = elytra_P2.addTrade(new Trade(2, "Raw Gold", 2, null, 0, "Firework II", 12));
    public static Trade goldNuggetToElytra_t = elytra_P2.addTrade(new Trade(3, "Gold Nugget", 1, null, 0, "Elytra", 1));
    public static Trade goldNuggetToElytraII_t = elytra_P2.addTrade(new Trade(4, "Gold Nugget", 3, "Elytra", 1, "Elytra II", 1));
    public static Trade rawGoldToElytraIII_t = elytra_P2.addTrade(new Trade(5, "Raw Gold", 2, "Elytra", 1, "Elytra III", 1));
    public static Trade rawGoldToElytraIV_t = elytra_P2.addTrade(new Trade(6, "Raw Gold", 4, "Elytra", 1, "Elytra IV", 1));
    public static Trade goldIngotToElytraV_t = elytra_P2.addTrade(new Trade(7, "Gold Ingot", 3, "Elytra", 1, "Elytra V", 1));
    public static Trade goldBlockToElytraVI_t = elytra_P2.addTrade(new Trade(8, "Gold Block", 2, "Elytra", 1, "Elytra VI", 1));

    public static TreeNode blocks_P2 = misc_P1.addNode(new TreeNode("ʙʟᴏᴄᴋs"));
    public static Trade rawGoldToWhite_t = blocks_P2.addTrade(new Trade(1, "Raw Gold", 5, null, 0, "White", 16));
    public static Trade rawGoldToOrange_t = blocks_P2.addTrade(new Trade(2, "Raw Gold", 5, null, 0, "Orange", 16));
    public static Trade rawGoldToMagenta_t = blocks_P2.addTrade(new Trade(3, "Raw Gold", 5, null, 0, "Magenta", 16));
    public static Trade rawGoldToLightBlue_t = blocks_P2.addTrade(new Trade(4, "Raw Gold", 5, null, 0, "Light Blue", 16));
    public static Trade rawGoldToYellow_t = blocks_P2.addTrade(new Trade(5, "Raw Gold", 5, null, 0, "Yellow", 16));
    public static Trade rawGoldToLime_t = blocks_P2.addTrade(new Trade(6, "Raw Gold", 5, null, 0, "Lime", 16));
    public static Trade rawGoldToPink_t = blocks_P2.addTrade(new Trade(7, "Raw Gold", 5, null, 0, "Pink", 16));
    public static Trade rawGoldToRed_t = blocks_P2.addTrade(new Trade(8, "Raw Gold", 3, null, 0, "Red", 16));
    public static Trade rawGoldToPurple_t = blocks_P2.addTrade(new Trade(9, "Raw Gold", 3, null, 0, "Purple", 16));
    public static Trade rawGoldToCyan_t = blocks_P2.addTrade(new Trade(10, "Raw Gold", 3, null, 0, "Cyan", 16));
    public static Trade rawGoldToBlue_t = blocks_P2.addTrade(new Trade(11, "Raw Gold", 3, null, 0, "Blue", 16));
    public static Trade rawGoldToBrown_t = blocks_P2.addTrade(new Trade(12, "Raw Gold", 3, null, 0, "Brown", 16));
    public static Trade rawGoldToLightGray_t = blocks_P2.addTrade(new Trade(13, "Raw Gold", 3, null, 0, "Light Gray", 16));
    public static Trade rawGoldToGray_t = blocks_P2.addTrade(new Trade(14, "Raw Gold", 3, null, 0, "Gray", 16));
    public static Trade rawGoldToBlack_t = blocks_P2.addTrade(new Trade(15, "Raw Gold", 3, null, 0, "Black", 16));
}
