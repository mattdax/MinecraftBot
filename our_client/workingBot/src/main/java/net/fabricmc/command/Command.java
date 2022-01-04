package net.fabricmc.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.io.IOException;

import net.fabricmc.api.Api;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class Command {
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	Api api;
	
	public void commandInit() {
		api = new Api();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("startbot").executes(context -> {
                System.out.println("Bot Started again");
        		//MC.player.jump();
                
        		try {
					api.start("192.168.1.11", 30000);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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