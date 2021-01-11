package org.test.proj.robotclean.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.test.proj.robotclean.RobotCleanApp;
import org.test.proj.robotclean.model.RobotInput;
import org.test.proj.robotclean.model.RobotOutput;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotCleanApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobotCleanControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testRobotCleanNoPatches() {
		RobotInput input = new RobotInput();
		
		List<Integer> roomSize = new ArrayList<Integer>();
		roomSize.add(5);
		roomSize.add(5);
		
		
		List<Integer> cooords = new ArrayList<Integer>();
		cooords.add(1);
		cooords.add(3);
		
		List<List<Integer>> patches = new ArrayList<List<Integer>>();
		List<Integer> Patch1 = new ArrayList<Integer>();
		Patch1.add(5);
		Patch1.add(5);
		patches.add(Patch1);
		
		List<Integer> Patch2 = new ArrayList<Integer>();
		Patch2.add(5);
		Patch2.add(5);
		patches.add(Patch2);
		
		List<Integer> Patch3 = new ArrayList<Integer>();
		Patch3.add(5);
		Patch3.add(5);
		patches.add(Patch3);
		
		
		input.setCoords(cooords);
		input.setInstructions("NNESEESWNWESWSSW");
		input.setPatches(patches);
		input.setRoomSize(roomSize);
		
		ResponseEntity<RobotOutput> postResponse = restTemplate.postForEntity(getRootUrl() + "/clean", input, RobotOutput.class);
			
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(postResponse.getStatusCode().is2xxSuccessful());
		
		List<Integer> resultCoords = new ArrayList<Integer>();
		resultCoords.add(1);
		resultCoords.add(1);
		
		assertEquals(resultCoords,((RobotOutput)postResponse.getBody()).getCoords());
		assertEquals(0,((RobotOutput)postResponse.getBody()).getPatches());
	}
	
	@Test
	public void testRobotClean() {
		RobotInput input = new RobotInput();
		
		List<Integer> roomSize = new ArrayList<Integer>();
		roomSize.add(5);
		roomSize.add(5);
		
		
		List<Integer> cooords = new ArrayList<Integer>();
		cooords.add(1);
		cooords.add(2);
		
		List<List<Integer>> patches = new ArrayList<List<Integer>>();
		List<Integer> Patch1 = new ArrayList<Integer>();
		Patch1.add(1);
		Patch1.add(0);
		patches.add(Patch1);
		
		List<Integer> Patch2 = new ArrayList<Integer>();
		Patch2.add(2);
		Patch2.add(2);
		patches.add(Patch2);
		
		List<Integer> Patch3 = new ArrayList<Integer>();
		Patch3.add(2);
		Patch3.add(3);
		patches.add(Patch3);
		
		
		input.setCoords(cooords);
		input.setInstructions("NNESEESWNWESWSSW");
		input.setPatches(patches);
		input.setRoomSize(roomSize);
		
		ResponseEntity<RobotOutput> postResponse = restTemplate.postForEntity(getRootUrl() + "/clean", input, RobotOutput.class);
		
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(postResponse.getStatusCode().is2xxSuccessful());
		
		List<Integer> resultCoords = new ArrayList<Integer>();
		resultCoords.add(1);
		resultCoords.add(0);
		
		assertEquals(resultCoords,((RobotOutput)postResponse.getBody()).getCoords());
		assertEquals(3,((RobotOutput)postResponse.getBody()).getPatches());
	}
	
	@Test
	public void testRobotCleanMissingParams() {
		RobotInput input = new RobotInput();
		
		List<Integer> roomSize = new ArrayList<Integer>();
		roomSize.add(5);
		roomSize.add(5);
		
		List<List<Integer>> patches = new ArrayList<List<Integer>>();
		List<Integer> Patch1 = new ArrayList<Integer>();
		Patch1.add(5);
		Patch1.add(5);
		patches.add(Patch1);
		
		List<Integer> Patch2 = new ArrayList<Integer>();
		Patch2.add(5);
		Patch2.add(5);
		patches.add(Patch2);
		
		List<Integer> Patch3 = new ArrayList<Integer>();
		Patch3.add(5);
		Patch3.add(5);
		patches.add(Patch3);
		
		
		input.setCoords(null);
		input.setInstructions("NNESEESWNWESWSSW");
		input.setPatches(patches);
		input.setRoomSize(roomSize);
		
		ResponseEntity<RobotOutput> postResponse = restTemplate.postForEntity(getRootUrl() + "/clean", input, RobotOutput.class);
		
		System.out.println(((RobotOutput)postResponse.getBody()).getCoords());
		
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(postResponse.getStatusCode().is5xxServerError());
	}
	
	@Test
	public void testRobotCleanMissingDirtPatchesSucess() {
		RobotInput input = new RobotInput();
		
		List<Integer> roomSize = new ArrayList<Integer>();
		roomSize.add(5);
		roomSize.add(5);
		
		
		List<Integer> cooords = new ArrayList<Integer>();
		cooords.add(1);
		cooords.add(3);
		
		
		input.setCoords(cooords);
		input.setInstructions("NNESEESWNWESWSSW");
		input.setPatches(null);
		input.setRoomSize(roomSize);
		
		ResponseEntity<RobotOutput> postResponse = restTemplate.postForEntity(getRootUrl() + "/clean", input, RobotOutput.class);
		
		System.out.println(((RobotOutput)postResponse.getBody()).getCoords());
		
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(postResponse.getStatusCode().is5xxServerError());
	}
	
	
	@Test
	public void testRobotCleanInputNull() {
		RobotInput input = new RobotInput();
		
		ResponseEntity<RobotOutput> postResponse = restTemplate.postForEntity(getRootUrl() + "/clean", input, RobotOutput.class);
		
		System.out.println(((RobotOutput)postResponse.getBody()).getCoords());
		
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(postResponse.getStatusCode().is5xxServerError());
	}
}
