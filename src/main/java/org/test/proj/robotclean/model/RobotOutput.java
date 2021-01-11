package org.test.proj.robotclean.model;

import java.util.List;

public class RobotOutput {

	public List<Integer> coords;
	public int patches;

	public List<Integer> getCoords() {
		return coords;
	}

	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	public int getPatches() {
		return patches;
	}

	public void setPatches(int patches) {
		this.patches = patches;
	}
}