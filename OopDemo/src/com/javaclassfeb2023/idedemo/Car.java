package com.javaclassfeb2023.idedemo;

public class Car implements Machine {
	private String color;
	private int productionDate;
	private int speed = 100;
	
	public Car(String color, int date) {
		this.color = color;
		this.productionDate = date;
	}



	public int getProductionDate() {
		return productionDate;
	}



	public void setProductionDate(int productionDate) {
		this.productionDate = productionDate;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void repaintCar() {
		this.color = "Black";
		System.out.println("This car is " + this.color);
	}



	@Override
	public void start() {
		System.out.println("Car started");
		
	}



	@Override
	public void stop() {
		System.out.println("Car stopped");
		System.out.println("Tnis car's speed is: " + Machine.squarePowerSpeed(speed));
		
	}

}
