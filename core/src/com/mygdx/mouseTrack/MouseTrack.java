package com.mygdx.mouseTrack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MouseTrack {
	
	private int rows;
	private int cols;
	
	private int spriteSize;
	private float mouseX;
	private float mouseY;
	
	
	
	private MouseCordinates mouseCordinates = new MouseCordinates();
	private boolean mouseLeftButtonDown = false;
	
	
	public MouseTrack(int spriteSize , int rows, int cols) {
		this.spriteSize = spriteSize;		
		this.rows = rows;
		this.cols = cols;
	}
	
	
	public MouseCordinates getMouseCordinates() {
		return this.mouseCordinates;
	}
	
	public void setMousePosition(){
		this.mouseX = Gdx.input.getX();
		this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		
		
		this.mouseCordinates.setCordinateX((int) mouseX / spriteSize);
		this.mouseCordinates.setCordinateY((int) mouseY / spriteSize);
		
		
		
		
	
	}
	
	
	
	public static boolean mousePositionInFieldBound(MouseCordinates mouseCordinates, int rows , int cols) {
		if(((mouseCordinates.getCordinateX() >= 1) && (mouseCordinates.getCordinateX() <= (cols - 2)))
			&& ((mouseCordinates.getCordinateY() >= 1) && (mouseCordinates.getCordinateY() <= (rows -2)))) {
			return true;	
		}
			return false;
	}
	
	public boolean eventMouseLeftClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
				!mouseLeftButtonDown &&
				MouseTrack.mousePositionInFieldBound(mouseCordinates, rows, cols)) {
			
			this.mouseLeftButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.mouseLeftButtonDown = false;
        }
		return false;
	}
	
}
