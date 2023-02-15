package com.javaclassfeb2023.idedemo;

public class Bike implements Machine {
	
	private String color;
	
	public Bike(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public void start() {
		System.out.println("Bike started");
		
	}
	@Override
	public void stop() {
		System.out.println("Bike stopped");
		
	}

}
