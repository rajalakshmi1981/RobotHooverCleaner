package org.test.proj.robotclean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.proj.robotclean.model.RobotInput;
import org.test.proj.robotclean.model.RobotOutput;
import org.test.proj.robotclean.service.RobotServiceClean;

@RestController
public class RobotCleanController {

	@Autowired
	RobotServiceClean roboCleanService;

	@PostMapping("/clean")
	private RobotOutput clean(@RequestBody RobotInput data) {
		roboCleanService.saveInput(data);
		return roboCleanService.clean();
	}
}