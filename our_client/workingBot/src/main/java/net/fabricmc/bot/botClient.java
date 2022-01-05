package net.fabricmc.bot;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import net.minecraft.client.MinecraftClient;
import net.fabricmc.command.Command;




// Bot client class?
public enum botClient {
	INSTANCE;
	
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	public static final Logger LOGGER = LogManager.getLogger("mattsminecraftbot");
	
	
	private boolean mod_enabled = true;
	
	
	
	// init function
	public void initialize() throws UnknownHostException, IOException {
		LOGGER.info("Client Init for Bot");
		Command command = new Command();
		command.commandInit();
		
        
	}
	public boolean isEnabled() {
		return mod_enabled;
	}
}
