package com.mygdx.utils;

public class InteractionManager {
	private boolean interactionWorking = false;
	
	public void startInteraction() {
		this.interactionWorking = true;
	} 
	
	public void stopInteraction() {
		this.interactionWorking = false;
	}
	
	
	public boolean inAction() {
		return interactionWorking;
	}
	
	
}
