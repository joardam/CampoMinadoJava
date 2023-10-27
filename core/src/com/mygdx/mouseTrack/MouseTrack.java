package com.mygdx.mouseTrack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.utils.*;
public class MouseTrack {
	
	private int rows;
	private int cols;
	
	private int spriteSize;
	private float mouseX;
	private float mouseY;
	
	
	
	private Coordinates mouseCoordinatesToField = new Coordinates();
	private boolean mouseLeftButtonDown = false;
	private boolean mouseRightButtonDown = false;
	
	
	public MouseTrack(int spriteSize , int rows, int cols) {
		this.spriteSize = spriteSize;		
		this.rows = rows;
		this.cols = cols;
	}
	
	
	public Coordinates getMouseCordinates() {
		return this.mouseCoordinatesToField;
	}
	
	public void setMousePosition(){
		this.mouseX = Gdx.input.getX();
		this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
	
		this.mouseCoordinatesToField.setCoordinateX(((int) mouseX / spriteSize) - 1);
		this.mouseCoordinatesToField.setCoordinateY(((int) mouseY / spriteSize) - 1);
		
	}
	
	
	public boolean eventMouseLeftClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
				!mouseLeftButtonDown &&
				Utils.isIn2DArrayBound(mouseCoordinatesToField.getCoordinateX(), mouseCoordinatesToField.getCoordinateY(), rows, cols)) {
			
			this.mouseLeftButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.mouseLeftButtonDown = false;
        }
		return false;
	}
	
	public boolean eventMouseRightClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)&&
				!mouseRightButtonDown &&
				Utils.isIn2DArrayBound(mouseCoordinatesToField.getCoordinateX(), mouseCoordinatesToField.getCoordinateY(), rows, cols)) {
			
			this.mouseRightButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            this.mouseRightButtonDown = false;
        }
		return false;
	}
	
	
}
