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
	
	
	
	private Coordinates mouseCoordinates = new Coordinates();
	private boolean mouseLeftButtonDown = false;
	private boolean mouseRightButtonDown = false;
	
	
	public MouseTrack(int spriteSize , int rows, int cols) {
		this.spriteSize = spriteSize;		
		this.rows = rows;
		this.cols = cols;
	}
	
	
	public Coordinates getMouseCordinates() {
		return this.mouseCoordinates;
	}
	
	public void setMousePosition(){
		this.mouseX = Gdx.input.getX();
		this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
	
		this.mouseCoordinates.setCoordinateX(((int) mouseX / spriteSize));
		this.mouseCoordinates.setCoordinateY(((int) mouseY / spriteSize));
		
		
	
	}
	
	
	
	public static boolean mousePositionInFieldBound(Coordinates mouseCordinates, int rows , int cols) {
		if(((mouseCordinates.getCoordinateX() >= 1) && (mouseCordinates.getCoordinateX() <= (rows - 2)))
			&& ((mouseCordinates.getCoordinateY() >= 1) && (mouseCordinates.getCoordinateY() <= (cols -2)))) {
			return true;	
		}
			return false;
	}
	
	public boolean eventMouseLeftClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
				!mouseLeftButtonDown &&
				MouseTrack.mousePositionInFieldBound(mouseCoordinates, rows, cols)) {
			
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
				MouseTrack.mousePositionInFieldBound(mouseCoordinates, rows, cols)) {
			
			this.mouseRightButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            this.mouseRightButtonDown = false;
        }
		return false;
	}
	
	
}
