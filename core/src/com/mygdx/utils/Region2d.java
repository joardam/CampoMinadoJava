package com.mygdx.utils;

public class Region2d{
	private FloatCoordinates inferiorLimit;
	private FloatCoordinates superiorLimit;
	
	public Region2d(FloatCoordinates inferiorLimit , FloatCoordinates superiorLimit) {
		this.inferiorLimit = inferiorLimit;
		this.superiorLimit = superiorLimit;
		
	}
	
	
	public FloatCoordinates getInferiorLimit() {
		return inferiorLimit;
	}
	public void setInferiorLimit(FloatCoordinates inferiorLimit) {
		this.inferiorLimit = inferiorLimit;
	}
	public FloatCoordinates getSuperiorLimit() {
		return superiorLimit;
	}
	public void setSuperiorLimit(FloatCoordinates superiorLimit) {
		this.superiorLimit = superiorLimit;
	}
	
	
	
}
