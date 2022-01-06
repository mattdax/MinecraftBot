package net.fabricmc.movement;

import net.fabricmc.movement.basicMovements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import java.util.concurrent.TimeUnit;

public class Listener extends Thread {
	public static final MinecraftClient MC = MinecraftClient.getInstance();

	public static void init() {
		Listener thread = new Listener();
		thread.start();
		//MC.player.deathTime()
	}
	public void run() {
		
		System.out.println("MMB - Action Listener Init");
		int cur_time = MC.player.deathTime;
		for(int i = 0; i < 1000000;i++) {
			
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				basicMovements.check(i);
			
			
			cur_time = MC.player.deathTime;
			
			// Check movement
			
			
			// Exit the Thread if shift
			if(MC.options.keySneak.isPressed()){
				System.out.println("MMB - Listener Closed");
				return;
			}
				
			cur_time = MC.player.deathTime;
		}
	}
	public void close() {
		
	}
}
