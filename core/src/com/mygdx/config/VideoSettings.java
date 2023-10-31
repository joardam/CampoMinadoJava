package com.mygdx.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class VideoSettings {
	
	private Viewport viewport;
    private OrthographicCamera camera;
    
    private int videoSizex;
	private int videoSizey;
	
	public VideoSettings() {
		
	}
	
	public VideoSettings(int cols , int rows, int spriteSize) {
		
		
		this.videoSizex = (cols + 2) * spriteSize;
		this.videoSizey = (rows + 2) * spriteSize;
		
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
