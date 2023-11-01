package com.mygdx.utils;

public class FloatCoordinates {
	private float coordinateX;
	private float coordinateY;
	
	public FloatCoordinates() {
		
	}
	
	public FloatCoordinates(float coordinateX , float coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		
	}
	
	public FloatCoordinates(Coordinates coordinate) {
		this.coordinateX = coordinate.getCoordinateX();
		this.coordinateY = coordinate.getCoordinateY();
	}
	
	
	
	public void setCoordinateX(float coordinateX){
		this.coordinateX = coordinateX;
	}
	
	
	public void setCoordinateY(float coordinateY){
		this.coordinateY = coordinateY;
	}
	
	
	public void setCoordinates(float x,float y){
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public float getCoordinateX() {
		return this.coordinateX;
	}
	
	public float getCoordinateY() {
		return this.coordinateY;
	}
}
