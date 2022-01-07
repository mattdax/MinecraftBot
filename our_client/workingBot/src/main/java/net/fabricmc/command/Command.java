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
                
                 this.api = null;
				try {
					this.api = new Api("192.168.1.11",30006);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		this.api.start();
               
        		Listener thread_two = new Listener(this.api);
        		thread_two.start();
        		
        		return 1;
            }));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("endbot").executes(context -> {
                System.out.println("Bot Ended");
        		//MC.player.jump();
    			this.api.stopPythonListener();
    			System.out.println("Stopped listener");
    			try {
					this.api.close();
					System.out.println("API Closed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return 1;
            }));
        });
	}
}