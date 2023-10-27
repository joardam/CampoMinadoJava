package com.mygdx.utils;


public class Coordinates{
	private int coordinateX;
	private int coordinateY;
	
	public Coordinates() {
		
	}
	
	public Coordinates(int coordinateX , int coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		
	}
	
	public Coordinates(Coordinates coordinate) {
		this.coordinateX = coordinate.getCoordinateX();
		this.coordinateY = coordinate.getCoordinateY();
	}
	
	
	
	public void setCoordinateX(int coordinateX){
		this.coordinateX = coordinateX;
	}
	
	public void setCoordinateY(int coordinateY){
		this.coordinateY = coordinateY;
	}
	
	public int getCoordinateX() {
		return this.coordinateX;
	}
	
	public int getCoordinateY() {
		return this.coordinateY;
	}
}