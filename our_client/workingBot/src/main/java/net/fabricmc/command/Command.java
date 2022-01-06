package net.fabricmc.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.io.IOException;

import net.fabricmc.api.Api;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.movement.Listener;
import net.fabricmc.movement.trackerMatrix;
import net.minecraft.client.MinecraftClient;

public class Command {
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	Api api;
	
	public void commandInit() {
		
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("startbot").executes(context -> {
                System.out.println("Bot Started");
                
        		new trackerMatrix();
                Runnable thread = new Api("192.168.1.11",30004);
        		new Thread(thread).start();
        		
        		Listener.init();
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