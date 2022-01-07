package net.fabricmc.movement;

import net.minecraft.client.MinecraftClient;
import net.fabricmc.movement.trackerMatrix;
import net.fabricmc.api.Api;

public class basicMovements {
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	static int[] currentTick = new int[7];
	public static int[] check(int tick) {
		boolean forward = movingForward();
		boolean backward = movingBackward();
		boolean jumping = jumping();
		boolean left = left();
		boolean right = right();
		boolean leftClick = leftClick();
		boolean rightClick = rightClick();
		trackerMatrix.movementMatrix[tick][0] = forward ? 1: 0;
		trackerMatrix.movementMatrix[tick][1] = backward ? 1: 0;
		trackerMatrix.movementMatrix[tick][2] = jumping ? 1: 0;
		trackerMatrix.movementMatrix[tick][3] = left ? 1: 0;
		trackerMatrix.movementMatrix[tick][4] = right ? 1: 0;
		trackerMatrix.movementMatrix[tick][5] = leftClick ? 1: 0;
		trackerMatrix.movementMatrix[tick][6] = rightClick ? 1: 0;
		currentTick[0] = forward ? 1: 0;
		currentTick[1] = backward ? 1: 0;
		currentTick[2] = jumping ? 1: 0;
		currentTick[3] = left ? 1: 0;
		currentTick[4] = right ? 1: 0;
		currentTick[5] = leftClick ? 1: 0;
		currentTick[6] = rightClick ? 1: 0;
		return currentTick;
	}
	
	public static boolean movingForward() {
		if(MC.options.keyForward.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean movingBackward() {
		if(MC.options.keyBack.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean jumping() {
		if(MC.options.keyJump.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean left() {
		if(MC.options.keyLeft.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean right() {
		if(MC.options.keyRight.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean rightClick() {
		if(MC.options.keyUse.isPressed()) {
			return true;
		}
		return false;
	}
	public static boolean leftClick() {
		if(MC.options.keyAttack.isPressed()) {
			return true;
		}
		return false;
	}
}
