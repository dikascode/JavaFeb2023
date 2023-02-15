package com.javaclassfeb2023.idedemo;

public class DemoW1D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toyota car1 = new Toyota("White", 2022);
		Bike ourBike = new Bike("Black");
		AbstractSubClass newAnstractClass = new AbstractSubClass();
//		
//		car1.start();
//		car1.stop();
//		car1.showDefaultMessage();
//		ourBike.start();
//		ourBike.stop();
//		ourBike.showDefaultMessage();
		
		//Calling abstract class methods
		newAnstractClass.nonAbstractMethod();
		newAnstractClass.abstractMethod();
	
		
		
		

	}

}
