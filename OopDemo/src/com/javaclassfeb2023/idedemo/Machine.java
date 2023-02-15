package com.javaclassfeb2023.idedemo;

public interface Machine {
	//Abstract Methods
	public void start();
	public void stop();
	
	
	//Default methods
	default void showDefaultMessage() {
		System.out.println("This is default messsage");
	}
	
	
	//static methods
	static int squarePowerSpeed(int speed) {
		return speed * speed;
	}
}
