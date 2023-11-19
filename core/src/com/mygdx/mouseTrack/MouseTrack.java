package com.mygdx.mouseTrack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.utils.FloatCoordinates;


public class MouseTrack {
	private float mouseX;
	private float mouseY;
	
	private boolean mouseLeftButtonDown = false;
	private boolean mouseRightButtonDown = false;
	
	public MouseTrack() {
		
	}
	
	
	public void setMousePosition(){
		this.mouseX = Gdx.input.getX();
		this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		
	}
	

	
	public boolean eventMouseLeftClickOnce(){
		
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
					!mouseLeftButtonDown) {
				
				this.mouseLeftButtonDown = true;			
				return true;
				
			} else if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
	            this.mouseLeftButtonDown = false;
	        }
			return false;
		}
	
	public boolean eventMouseRightClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)&&
				!mouseRightButtonDown) {
			
			this.mouseRightButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
	        this.mouseRightButtonDown = false;
	    }
		
		return false;
		
	}
	
	public float getMouseX() {
		return mouseX;
	}
	
	public FloatCoordinates getMousePosition() {
		return new FloatCoordinates(mouseX,mouseY);
	}
	
	public void setMouseX(float mouseX) {
		this.mouseX = mouseX;
	}
	
	public float getMouseY() {
		return mouseY;
	}
	
	public void setMouseY(float mouseY) {
		this.mouseY = mouseY;
	}
	
	
}
