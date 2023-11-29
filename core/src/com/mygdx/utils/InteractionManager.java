package com.mygdx.utils;

public class InteractionManager {
	private boolean inAction = false;
	private boolean closed = false;
	private boolean locked = false;
	
	public void startInteraction() {
		if(locked || closed) {
			return;
		}
		this.inAction = true;
	} 
	
	public void stopInteraction() {
		if(locked || closed) {
			return;
		}
		this.inAction = false;
	}
	
	
	public boolean inAction() {
		return inAction;
	}
	
	public void closeInteraction() {
		if(locked || closed) {
			return;
		}
		stopInteraction();
		this.closed = true;
		
		
	}
	
	public void openInteraction() {
		if(locked) {
			return;
		}
		this.closed = false;
	}
	
	public void lockInteraction() {
		this.locked = true;
	}
	
	

	public void unlockInteraction() {
		this.locked = false;
	}
	
	public boolean closed() {
		return closed;
	}

	public boolean locked() {
		return locked;
	}
}
