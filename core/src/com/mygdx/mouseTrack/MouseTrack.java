package com.mygdx.mouseTrack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MouseTrack {
	
	int rows;
	int cols;
	
	int spriteSize;
	float mouseX;
	float mouseY;
	
	int mouseCollumX ;
	int mouseCollumY ;
	private boolean mouseLeftButtonDown = false;
	
	
	public MouseTrack(int spriteSize , int rows, int cols) {
		this.spriteSize = spriteSize;		
		this.rows = rows;
		this.cols = cols;
	}
	
	public void setMousePosition(){
		this.mouseX = Gdx.input.getX();
		this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		
		this.mouseCollumX = (int) mouseX / spriteSize;
		this.mouseCollumY = (int) mouseY / spriteSize;
	}
	
	
	
	public static boolean mousePositionInFieldBound(int mouseCollumX , int mouseCollumY , int rows , int cols) {
		if(((mouseCollumX >= 1) && (mouseCollumX  <= (cols - 2)))
			&& ((mouseCollumY >= 1) && (mouseCollumY <= (rows -2)))) {
			return true;	
		}
			return false;
	}
	
	public boolean eventMouseLeftClickOnce(){
		
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&&
				!mouseLeftButtonDown &&
				MouseTrack.mousePositionInFieldBound(mouseCollumX, mouseCollumY, rows, cols)) {
			
			this.mouseLeftButtonDown = true;			
			return true;
			
		} else if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.mouseLeftButtonDown = false;
        }
		return false;
	}
	
}
