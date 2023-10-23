package com.mygdx.config;

import com.badlogic.gdx.Gdx;

public class VideoSettings {
	private int rows;
	private int cols;
	private int spriteSize;
	
	
	public VideoSettings() {
		
	}
	
	public VideoSettings(int rows , int cols, int spriteSize) {
		this.rows = rows;
		this.cols = cols;
		this.spriteSize = spriteSize;
	}
	
	
	public void setRows(int rows) {
		this.rows = rows; 
	}
	
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}
	
	
	public void setWindowedMode() {
		int videoSizex = rows * spriteSize;
		int videoSizey = cols * spriteSize;
		Gdx.graphics.setWindowedMode(videoSizex,videoSizey);
	}
	
	public void setResizable(boolean resizable) {
		Gdx.graphics.setResizable(false);
	}
	
	public void setTitle(String title) {
		Gdx.graphics.setTitle(title);
	}

	
}
