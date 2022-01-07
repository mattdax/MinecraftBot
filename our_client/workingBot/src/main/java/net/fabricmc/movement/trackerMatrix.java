package net.fabricmc.movement;

public class trackerMatrix {

	// 72 thousand ticks is about an hour of game play.
	// we will check once per tick for the current actions of the player. Starts with the basic
	//  W, A, S, D, Jump
	public static int[][] movementMatrix = new int[72000][7];
	

}
