package com.mygdx.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class VideoSettings {
	private int rows;
	private int cols;
	private int spriteSize;
	private Viewport viewport;
    private OrthographicCamera camera;
    
    int videoSizex;
	int videoSizey;
	
	
	public VideoSettings() {
		
	}
	
	public VideoSettings(int rows , int cols, int spriteSize) {
		this.rows = rows;
		this.cols = cols;
		this.spriteSize = spriteSize;
		
		this.videoSizex = rows * spriteSize;
		this.videoSizey = cols * spriteSize;
		
		
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
		
		Gdx.graphics.setWindowedMode(videoSizex,videoSizey);
	}
	
	public void setResizable(boolean resizable) {
		Gdx.graphics.setResizable(false);
	}
	
	public void setTitle(String title) {
		Gdx.graphics.setTitle(title);
	}
	
	public void setFixElements() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, videoSizex, videoSizey);
		camera.update();
		viewport = new ScreenViewport(camera);
	}
	
	public void resizeScreen(int width,int height) {
		viewport.update(width, height);
	}	
	
	public OrthographicCamera getCamera() {
		return this.camera;
	}
}
