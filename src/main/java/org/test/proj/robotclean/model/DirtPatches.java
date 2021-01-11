package org.test.proj.robotclean.model;

import java.util.ArrayList;
import java.util.List;

public class DirtPatches {

	  List<Position> dirtPatches = new ArrayList<Position>();
	  
	 public void addDirtPatch(Position position) {
		 dirtPatches.add(position);
	 }
	 
	 public void removeDirtPatch(Position currentPos) {
		  dirtPatches.remove(currentPos);
	  }
	  
	  public boolean isPositionADirtPatch(Position currentPos) {
		  return dirtPatches.contains(currentPos);
	  }
}
