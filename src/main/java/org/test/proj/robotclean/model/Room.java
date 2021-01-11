package org.test.proj.robotclean.model;

public class Room {

	private int x;
	private int y;

	public Room(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isValidMove(Position position) {
		return position.isInBoundry(x, y) && position.isOutside(0, 0);
	}
}
