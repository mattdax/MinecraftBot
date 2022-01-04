package net.fabricmc.bot;

import net.fabricmc.api.ModInitializer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;



public class minecraftBot implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("mattsminecraftbot");

	
	
	private static boolean init;
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		if(init) {
			throw new RuntimeException("Mod has run twice");
		}
		
		LOGGER.info("Starting Minecraft Bot Mod");
		try {
			botClient.INSTANCE.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
