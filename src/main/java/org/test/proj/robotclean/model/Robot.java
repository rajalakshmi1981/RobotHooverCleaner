package org.test.proj.robotclean.model;

import java.util.List;

public class Robot {

	private Position position;
	private Room room;
	private int patchesCleaned= 0;
	
	private DirtPatches dirtPatches;

	public Robot(Room room, Position position) {
		this.room = room;
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}
	
	public int getPatchesCleaned() {
		return patchesCleaned;
	}

	public void process(String instructions) {
		instructions.chars().mapToObj(c -> (char) c).forEach(this::process);
	}
	
	public void setDirtPatches(List<List<Integer>> patches) {
		dirtPatches = new DirtPatches();
		for(List<Integer> position: patches) {
			dirtPatches.addDirtPatch(new Position(position.get(0),position.get(1)));
		}
	}
	

	private void process(Character direction) {
		try {
			position = position.move(direction);
			if(room.isValidMove(position)) {
				if(dirtPatches.isPositionADirtPatch(position)) {
					patchesCleaned++;
					dirtPatches.removeDirtPatch(position);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return position.toString();
	}
}