package org.test.proj.robotclean.model;

import java.util.Objects;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position move(Character direction) {
		switch (direction) {
		case 'E':
			return new Position(x + 1, y);
		case 'W':
			return new Position(x - 1, y);
		case 'N':
			return new Position(x, y + 1);
		case 'S':
			return new Position(x, y - 1);
		default:
			throw new IllegalStateException("Unknown Direction");
		}
	}
	
	public int getXPosition() {
		return this.x;
	}
	
	public int getYPosition() {
		return this.y;
	}

	public boolean isInBoundry(int x, int y) {
		return this.x <= x && this.y <= y;
	}

	public boolean isOutside(int x, int y) {
		return this.x >= x && this.y >= y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Position))
			return false;
		Position position = (Position) o;
		return x == position.x && y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
