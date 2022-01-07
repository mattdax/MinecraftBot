package net.fabricmc.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.io.IOException;
import java.net.UnknownHostException;

import net.fabricmc.api.Api;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.movement.Listener;
import net.fabricmc.movement.trackerMatrix;
import net.minecraft.client.MinecraftClient;

public class Command extends Thread {
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	Api api;
	
	public void commandInit() {
		
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("startbot").executes(context -> {
                System.out.println("Bot Started");
                
        		new trackerMatrix();
                
                Api api = null;
				try {
					api = new Api("192.168.1.11",30005);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		api.start();
               
        		Listener thread_two = new Listener(api);
        		thread_two.start();
        		
        		return 1;
            }));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("endbot").executes(context -> {
                System.out.println("Bot Ended");
        		//MC.player.jump();
    			try {
					api.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			MC.options.keyForward.setPressed(false);
                return 1;
            }));
        });
	}
}