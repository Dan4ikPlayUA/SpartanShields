package com.oblivioussp.spartanshields.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.client.methods.Configurable;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ConfigHandler
{
	public static Configuration config;
	
	// Config options start here.
	public static int durabilityWoodShield = Reference.DefaultDurabilityWoodShield;
	public static int durabilityStoneShield = Reference.DefaultDurabilityStoneShield;
	public static int durabilityIronShield = Reference.DefaultDurabilityIronShield;
	public static int durabilityGoldShield = Reference.DefaultDurabilityGoldShield;
	public static int durabilityDiamondShield = Reference.DefaultDurabilityDiamondShield;
	
	public static int durabilityBronzeShield = Reference.DefaultDurabilityBronzeShield;
	public static boolean enableBronzeShield = true;
	public static int durabilitySteelShield = Reference.DefaultDurabilitySteelShield;
	public static boolean enableSteelShield = true;
	public static int durabilityCopperShield = Reference.DefaultDurabilityCopperShield;
	public static boolean enableCopperShield = true;
	public static int durabilityTinShield = Reference.DefaultDurabilityTinShield;
	public static boolean enableTinShield = true;
	public static int durabilitySilverShield = Reference.DefaultDurabilitySilverShield;
	public static boolean enableSilverShield = true;
	public static int durabilityObsidianShield = Reference.DefaultDurabilityObsidianShield;
	public static boolean enableObsidianShield = true;
	
	public static int durabilityEnderiumShield = Reference.DefaultDurabilityEnderiumShield;
	public static boolean enableEnderiumShield = true;
	public static int durabilityInvarShield = Reference.DefaultDurabilityInvarShield;
	public static boolean enableInvarShield = true;
	public static int durabilityPlatinumShield = Reference.DefaultDurabilityPlatinumShield;
	public static boolean enablePlatinumShield = true;
	public static int durabilityElectrumShield = Reference.DefaultDurabilityElectrumShield;
	public static boolean enableElectrumShield = true;
	public static int durabilityNickelShield = Reference.DefaultDurabilityNickelShield;
	public static boolean enableNickelShield = true;
	public static int durabilityLeadShield = Reference.DefaultDurabilityLeadShield;
	public static boolean enableLeadShield = true;
	public static int durabilitySignalumShield = Reference.DefaultDurabilitySignalumShield;
	public static boolean enableSignalumShield = true;
	public static int durabilityLumiumShield = Reference.DefaultDurabilityLumiumShield;
	public static boolean enableLumiumShield = true;
	
	public static int durabilityManasteelShield = Reference.DefaultDurabilityManasteelShield;
	public static boolean enableManasteelShield = true;
	public static int durabilityTerrasteelShield = Reference.DefaultDurabilityTerrasteelShield;
	public static boolean enableTerrasteelShield = true;
	public static int durabilityElementiumShield = Reference.DefaultDurabilityElementiumShield;
	public static boolean enableElementiumShield = true;
	
	public static int durabilityConstantanShield = Reference.DefaultDurabilityConstantanShield;
	public static boolean enableConstantanShield = true;
	
	public static int durabilityDarkstoneShield = Reference.DefaultDurabilityDarkstoneShield;
	public static boolean enableDarkstoneShield = true;
	public static int durabilityAbyssalniteShield = Reference.DefaultDurabilityAbyssalniteShield;
	public static boolean enableAbyssalniteShield = true;
	public static int durabilityCoraliumShield = Reference.DefaultDurabilityCoraliumShield;
	public static boolean enableCoraliumShield = true;
	public static int durabilityDreadiumShield = Reference.DefaultDurabilityDreadiumShield;
	public static boolean enableDreadiumShield = true;
	public static int durabilityEthaxiumShield = Reference.DefaultDurabilityEthaxiumShield;
	public static boolean enableEthaxiumShield = true;
	
	public static int durabilitySoulforgedSteelShield = Reference.DefaultDurabilitySoulforgedSteelShield;
	public static boolean enableSoulforgedSteelShield = true;
	
	public static int durabilityThaumiumShield = Reference.DefaultDurabilityThaumiumShield;
	public static boolean enableThaumiumShield = true;
	public static int durabilityVoidShield = Reference.DefaultDurabilityVoidShield;
	public static boolean enableVoidShield = true;
	
	public static boolean enableEnderIOShield = true;
	public static boolean enableRFToolsShield = true;
	public static boolean enableRAShield = true;
	
	public static int damageToRFMultiplier = Reference.DefaultDamageToRFMultiplier;
	public static int damageToFEMultiplier = Reference.DefaultDamageToFEMultiplier;
	
	public static boolean vanillaOnly = false;
	public static boolean forceDisableUncraftableTooltips = false;
	public static boolean enableSpikesEnchantment = true;
	public static boolean disableTowerShields = false;
	public static boolean disableStandardShields = false;
	public static int cooldownShieldBash = 30;
	public static boolean disableShieldBash = false;
	
	public static final String categoryVanilla = "vanilla";
	public static final String categoryModdedCommon = "moddedCommon";
	public static final String categoryThermalMods = "moddedThermal";
	public static final String categoryModdedBotania = "moddedBotania";
	public static final String categoryModdedAbyssalcraft = "moddedAbyssalcraft";
	public static final String categoryModdedThaumcraft = "moddedThaumcraft";
	public static final String categoryModdedBWM = "moddedBWM";
	public static final String categoryPowered = "moddedPowered";
	
	public static final String[] categories = {Configuration.CATEGORY_GENERAL, categoryVanilla, categoryModdedCommon, categoryThermalMods, categoryModdedBotania, categoryModdedAbyssalcraft, categoryModdedThaumcraft, categoryModdedBWM, categoryPowered};
	
	public static void init(File configFile)
	{
		// Create the config object from given config file
		if(config == null)
		{
			config = new Configuration(configFile, Reference.ConfigVersion);
			loadConfig();
			
			// Set Category Language Keys
			for(String category : categories)
			{
				setCategoryLanguageKey(category);
			}
		}
	}
	
	@SubscribeEvent
	public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equalsIgnoreCase(Reference.ModID))
		{
			// Resync configs
			loadConfig();
		}
	}
	
	private static void loadConfig()
	{
		// Config stuffs
		// GENERAL
		
		vanillaOnly = getBoolean("vanillaOnly", Configuration.CATEGORY_GENERAL, false, "Set to true to have only Vanilla-based shields enabled. Note that this completely removes mod-based Shields from the game! You won't be able to see them even in JEI.");
		forceDisableUncraftableTooltips = getBoolean("forceDisableUncraftableTooltips", Configuration.CATEGORY_GENERAL, false, "Will force the uncraftable shield tooltip (highlighted in red) to not appear. Useful for modpack makers who wish to change recipes.");
		enableSpikesEnchantment = getBoolean("enableSpikesEnchantment", Configuration.CATEGORY_GENERAL, true, "Set to false to completely disable the Spikes enchantment.");
		disableTowerShields = getBoolean("disableTowerShields", Configuration.CATEGORY_GENERAL, false, "Set to disable all Tower Shields in the mod.");
		disableStandardShields = getBoolean("disableStandardShields", Configuration.CATEGORY_GENERAL, false, "Set to disable all Standard Shields in the mod. Tower Shields are unaffected.");
		cooldownShieldBash = getInt("cooldownShieldBash", Configuration.CATEGORY_GENERAL, Reference.DefaultCooldownShieldBash, 1, 1000, "Cooldown period for Shield Bashes.");
		disableShieldBash = getBoolean("disableShieldBash", Configuration.CATEGORY_GENERAL, false, "Set to true to disable the Shield Bash feature.");
		
		durabilityWoodShield = getInt("durabilityWoodShield", categoryVanilla, Reference.DefaultDurabilityWoodShield, 1, 100000, "Tweaks the durability of the Crude Wooden Shield.");
		durabilityStoneShield = getInt("durabilityStoneShield", categoryVanilla, Reference.DefaultDurabilityStoneShield, 1, 100000, "Tweaks the durability of the Stone Braced Shield.");
		durabilityIronShield = getInt("durabilityIronShield", categoryVanilla, Reference.DefaultDurabilityIronShield, 1, 100000, "Tweaks the durability of the Iron Plated Shield.");
		durabilityGoldShield = getInt("durabilityGoldShield", categoryVanilla, Reference.DefaultDurabilityGoldShield, 1, 100000, "Tweaks the durability of the Gold Gilded Shield.");
		durabilityDiamondShield = getInt("durabilityDiamondShield", categoryVanilla, Reference.DefaultDurabilityDiamondShield, 1, 100000, "Tweaks the durability of the Diamond Reinforced Shield.");
		durabilityObsidianShield = getInt("durabilityObsidianShield", categoryVanilla, Reference.DefaultDurabilityObsidianShield, 1, 100000, "Tweaks the durability of the Bulky Obsidian Shield.");
		enableObsidianShield = getBoolean("enableObsidianShield", categoryVanilla, true, "Enables or Disables the Bulky Obsidian Shield.");
		
		durabilityBronzeShield = getInt("durabilityBronzeShield", categoryModdedCommon, Reference.DefaultDurabilityBronzeShield, 1, 100000, "Tweaks the durability of the Bronze Plated Shield.");
		enableBronzeShield = getBoolean("enableBronzeShield", categoryModdedCommon, true, "Enables or Disables the Bronze Plated Shield.");
		durabilitySteelShield = getInt("durabilitySteelShield", categoryModdedCommon, Reference.DefaultDurabilitySteelShield, 1, 100000, "Tweaks the durability of the Steel Plated Shield.");
		enableSteelShield = getBoolean("enableSteelShield", categoryModdedCommon, true, "Enables or Disables the Steel Plated Shield.");
		durabilityCopperShield = getInt("durabilityCopperShield", categoryModdedCommon, Reference.DefaultDurabilityCopperShield, 1, 100000, "Tweaks the durability of the Copper Braced Shield.");
		enableCopperShield = getBoolean("enableCopperShield", categoryModdedCommon, true, "Enables or Disables the Copper Braced Shield.");
		durabilityTinShield = getInt("durabilityTinShield", categoryModdedCommon, Reference.DefaultDurabilityTinShield, 1, 100000, "Tweaks the durability of the Tin Braced Shield.");
		enableTinShield = getBoolean("enableTinShield", categoryModdedCommon, true, "Enables or Disables the Tin Braced Shield.");
		durabilitySilverShield = getInt("durabilitySilverShield", categoryModdedCommon, Reference.DefaultDurabilitySilverShield, 1, 100000, "Tweaks the durability of the Silver Gilded Shield.");
		enableSilverShield = getBoolean("enableSilverShield", categoryModdedCommon, true, "Enables or Disables the Silver Gilded Shield.");
		
		durabilityInvarShield = getInt("durabilityInvarShield", categoryModdedCommon, Reference.DefaultDurabilityInvarShield, 1, 100000, "Tweaks the durability of the Invar Plated Shield.");
		enableInvarShield = getBoolean("enableInvarShield", categoryModdedCommon, true, "Enables or Disables the Invar Plated Shield.");
		durabilityPlatinumShield = getInt("durabilityPlatinumShield", categoryModdedCommon, Reference.DefaultDurabilityPlatinumShield, 1, 100000, "Tweaks the durability of the Platinum Plated Shield.");
		enablePlatinumShield = getBoolean("enablePlatinumShield", categoryModdedCommon, true, "Enables or Disables the Platinum Plated Shield.");
		durabilityElectrumShield = getInt("durabilityElectrumShield", categoryModdedCommon, Reference.DefaultDurabilityElectrumShield, 1, 100000, "Tweaks the durability of the Electrum Plated Shield.");
		enableElectrumShield = getBoolean("enableElectrumShield", categoryModdedCommon, true, "Enables or Disables the Electrum Plated Shield.");
		durabilityNickelShield = getInt("durabilityNickelShield", categoryModdedCommon, Reference.DefaultDurabilityNickelShield, 1, 100000, "Tweaks the durability of the Nickel Braced Shield.");
		enableNickelShield = getBoolean("enableNickelShield", categoryModdedCommon, true, "Enables or Disables the Nickel Braced Shield.");
		durabilityLeadShield = getInt("durabilityLeadShield", categoryModdedCommon, Reference.DefaultDurabilityLeadShield, 1, 100000, "Tweaks the durability of the Lead Plated Shield.");
		enableLeadShield = getBoolean("enableLeadShield", categoryModdedCommon, true, "Enables or Disables the Lead Plated Shield.");
		
		durabilityEnderiumShield = getInt("durabilityEnderiumShield", categoryThermalMods, Reference.DefaultDurabilityEnderiumShield, 1, 100000, "Tweaks the durability of the Enderium Strengthened Shield.");
		enableEnderiumShield = getBoolean("enableEnderiumShield", categoryThermalMods, true, "Enables or Disables the Enderium Strengthened Shield.");
		durabilitySignalumShield = getInt("durabilitySignalumShield", categoryThermalMods, Reference.DefaultDurabilitySignalumShield, 1, 100000, "Tweaks the durability of the Signalum Strengthened Shield.");
		enableSignalumShield = getBoolean("enableSignalumShield", categoryThermalMods, true, "Enables or Disables the Signalum Strengthened Shield.");
		durabilityLumiumShield = getInt("durabilityLumiumShield", categoryThermalMods, Reference.DefaultDurabilityLumiumShield, 1, 100000, "Tweaks the durability of the Radiant Lumium Shield.");
		enableLumiumShield = getBoolean("enableLumiumShield", categoryThermalMods, true, "Enables or Disables the Radiant Lumium Shield.");
		
		durabilityManasteelShield = getInt("durabilityManasteelShield", categoryModdedBotania, Reference.DefaultDurabilityManasteelShield, 1, 100000, "Tweaks the durability of the Manasteel Plated Shield.");
		enableManasteelShield = getBoolean("enableManasteelShield", categoryModdedBotania, true, "Enables or Disables the Manasteel Plated Shield.");
		durabilityTerrasteelShield = getInt("durabilityTerrasteelShield", categoryModdedBotania, Reference.DefaultDurabilityTerrasteelShield, 1, 100000, "Tweaks the durability of the Terrasteel Plated Shield.");
		enableTerrasteelShield = getBoolean("enableTerrasteelShield", categoryModdedBotania, true, "Enables or Disables the Terrasteel Plated Shield.");
		durabilityElementiumShield = getInt("durabilityElementiumShield", categoryModdedBotania, Reference.DefaultDurabilityElementiumShield, 1, 100000, "Tweaks the durability of the Elementium Plated Shield.");
		enableElementiumShield = getBoolean("enableElementiumShield", categoryModdedBotania, true, "Enables or Disables the Elementium Plated Shield.");
		
		durabilityConstantanShield = getInt("durabilityConstantanShield", categoryModdedCommon, Reference.DefaultDurabilityConstantanShield, 1, 100000, "Tweaks the durability of the Constantan Plated Shield.");
		enableConstantanShield = getBoolean("enableConstantanShield", categoryModdedCommon, true, "Enables or Disables the Constantan Plated Shield.");
		
		durabilityDarkstoneShield = getInt("durabilityDarkstoneShield", categoryModdedAbyssalcraft, Reference.DefaultDurabilityDarkstoneShield, 1, 100000, "Tweaks the durability of the Darkstone Braced Shield.");
		enableDarkstoneShield = getBoolean("enableDarkstoneShield", categoryModdedAbyssalcraft, true, "Enables or Disables the Darkstone Braced Shield.");
		durabilityAbyssalniteShield = getInt("durabilityAbyssalniteShield", categoryModdedAbyssalcraft, Reference.DefaultDurabilityAbyssalniteShield, 1, 100000, "Tweaks the durability of the Abyssalnite Plated Shield.");
		enableAbyssalniteShield = getBoolean("enableAbyssalniteShield", categoryModdedAbyssalcraft, true, "Enables or Disables the Abyssalnite Plated Shield.");
		durabilityCoraliumShield = getInt("durabilityCoraliumShield", categoryModdedAbyssalcraft, Reference.DefaultDurabilityCoraliumShield, 1, 100000, "Tweaks the durability of the Coralium Plated Shield.");
		enableCoraliumShield = getBoolean("enableCoraliumShield", categoryModdedAbyssalcraft, true, "Enables or Disables the Coralium Plated Shield.");
		durabilityDreadiumShield = getInt("durabilityDreadiumShield", categoryModdedAbyssalcraft, Reference.DefaultDurabilityDreadiumShield, 1, 100000, "Tweaks the durability of the Dreadium Reinforced Shield.");
		enableDreadiumShield = getBoolean("enableDreadiumShield", categoryModdedAbyssalcraft, true, "Enables or Disables the Dreadium Reinforced Shield.");
		durabilityEthaxiumShield = getInt("durabilityEthaxiumShield", categoryModdedAbyssalcraft, Reference.DefaultDurabilityEthaxiumShield, 1, 100000, "Tweaks the durability of the Ethaxium Strengthened Shield.");
		enableEthaxiumShield = getBoolean("enableEthaxiumShield", categoryModdedAbyssalcraft, true, "Enables or Disables the Ethaxium Strengthened Shield.");
		
		durabilityThaumiumShield = getInt("durabilityThaumiumShield", categoryModdedThaumcraft, Reference.DefaultDurabilityThaumiumShield, 1, 100000, "Tweaks the durability of the Thaumium Plated Shield.");
		enableThaumiumShield = getBoolean("enableThaumiumShield", categoryModdedThaumcraft, true, "Enables or Disables the Thaumium Plated Shield.");
		durabilityVoidShield = getInt("durabilityVoidShield", categoryModdedThaumcraft, Reference.DefaultDurabilityVoidShield, 1, 100000, "Tweaks the durability of the Void Plated Shield.");
		enableVoidShield = getBoolean("enableVoidShield", categoryModdedThaumcraft, true, "Enables or Disables the Void Plated Shield.");
		
		durabilitySoulforgedSteelShield = getInt("durabilitySoulforgedSteelShield", categoryModdedBWM, Reference.DefaultDurabilitySoulforgedSteelShield, 1, 100000, "Tweaks the durability of the Soulforged Steel Plated Shield.");		
		enableSoulforgedSteelShield = getBoolean("enableSoulforgedSteelShield", categoryModdedBWM, true, "Enables or Disables the Soulforged Steel Plated Shield.");
		
		enableEnderIOShield = getBoolean("enableEnderIOShield", categoryPowered, true, "Enables or Disables the Dark Steel Riot Shield.");
		enableRFToolsShield = getBoolean("enableRFToolsShield", categoryPowered, true, "Enables or Disables the Infused Riot Shield.");
		enableRAShield = getBoolean("enableRAShield", categoryPowered, true, "Enables or Disables the Flux-Infused Shield.");
		
		damageToRFMultiplier = getInt("damageToRFMultiplier", categoryPowered, Reference.DefaultDamageToRFMultiplier, 1, 100000, "The amount of RF to use per damage point absorbed with RF-powered Shields.");
		damageToFEMultiplier = getInt("damageToFEMultiplier", categoryPowered, Reference.DefaultDamageToFEMultiplier, 1, 100000, "The amount of FE to use per damage point absorbed with FE-powered Shields.");
				
		if(config.hasChanged())
			config.save();
	}
	
	public static void setCategoryLanguageKey(String category)
	{
		config.getCategory(category).setLanguageKey(String.format("%s.%s:%s.%s", "config", Reference.ModID, "category", category));
	}
	
	public static int getInt(String name, String category, int defaultValue, int minValue, int maxValue, String comment)
	{
		return config.getInt(name, category, defaultValue, minValue, maxValue, comment, String.format("%s.%s:%s", "config", Reference.ModID, name));
	}
	
	public static boolean getBoolean(String name, String category, boolean defaultValue, String comment)
	{
		return config.getBoolean(name, category, defaultValue, comment, String.format("%s.%s:%s", "config", Reference.ModID, name));
	}
}
