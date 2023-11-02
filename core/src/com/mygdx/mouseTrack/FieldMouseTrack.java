package com.mygdx.mouseTrack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.utils.*;
public class FieldMouseTrack extends MouseTrack {
	
	private int rows;
	private int cols;
	
	private int spriteSize;
	
	
	private Coordinates mouseCoordinatesToField = new Coordinates();
	private boolean mouseLeftButtonDown = false;
	private boolean mouseRightButtonDown = false;
	
	public FieldMouseTrack() {
		
	}
	
	public FieldMouseTrack(int spriteSize , int rows, int cols) {
		this.spriteSize = spriteSize;		
		this.rows = rows;
		this.cols = cols;
	}
	
	
	public Coordinates getMouseCoordinatesInField() {
		return this.mouseCoordinatesToField;
	}
	
	
	public void setMousePositionInField(){
		super.setMouseX(Gdx.input.getX());
		super.setMouseY(Gdx.graphics.getHeight() - Gdx.input.getY());
	
		this.mouseCoordinatesToField.setCoordinateX(((int) super.getMouseX() / spriteSize) - 1);
		this.mouseCoordinatesToField.setCoordinateY(((int) super.getMouseY() / spriteSize) - 1);
		
	}
	
	
	@Override
	public boolean eventMouseLeftClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
				!mouseLeftButtonDown &&
				Utils.isIn2DArrayBound(mouseCoordinatesToField.getCoordinateX(),mouseCoordinatesToField.getCoordinateY(), rows, cols)) {
			
			this.mouseLeftButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.mouseLeftButtonDown = false;
        }
		return false;
	}
	
	
	@Override
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
