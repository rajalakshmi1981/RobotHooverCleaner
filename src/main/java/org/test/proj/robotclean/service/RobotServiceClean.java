package org.test.proj.robotclean.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.proj.robotclean.model.Position;
import org.test.proj.robotclean.model.Robot;
import org.test.proj.robotclean.model.RobotInput;
import org.test.proj.robotclean.model.RobotOutput;
import org.test.proj.robotclean.model.RobotPersistdata;
import org.test.proj.robotclean.model.Room;
import org.test.proj.robotclean.repository.RobotCleanRepository;

import com.google.gson.Gson;

@Service
public class RobotServiceClean {

	@Autowired
	RobotCleanRepository roboCleanInputRepository;
	
	RobotInput inputData;
	RobotOutput outputData;
	
	public RobotOutput clean() {
		
		Room room = new Room(inputData.getRoomSize().get(0), inputData.getRoomSize().get(1));
		Position position = new Position(inputData.getCoords().get(0), inputData.getCoords().get(1));
		
		Robot robot = new Robot(room, position);
		robot.setDirtPatches(inputData.getPatches());
		
		robot.process(inputData.getInstructions());
		
		RobotOutput robotOutput = new RobotOutput();
		
		List<Integer> currentCoOrds = new ArrayList<Integer>();
		currentCoOrds.add(robot.getPosition().getXPosition());
		currentCoOrds.add(robot.getPosition().getYPosition());
		
		
		robotOutput.setCoords(currentCoOrds);
		robotOutput.setPatches(robot.getPatchesCleaned());
		
		RobotPersistdata data = new RobotPersistdata();
		
		 Gson gson = new Gson();
		 data.setInput(gson.toJson(inputData));
		 data.setOutput(gson.toJson(outputData));
		
		 roboCleanInputRepository.save(data);
		 
		return robotOutput;
	}

	public void saveInput(RobotInput dataObj) {
		inputData = dataObj;
	}
}