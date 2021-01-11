package org.test.proj.robotclean.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RobotPersistdata {

	@Id
	@GeneratedValue
	private int id;
	
	private String input;
	private String output;
	
	public int getId() {
		return id;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	
	
}