package com.mygdx.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class VideoSettings {
	
	private Viewport viewport;
    private OrthographicCamera camera;
    
    private int videoSizeX;
	private int videoSizeY;
	
	public VideoSettings() {
		
	}
	
	
	public void SetVideoSize(int videoSizeX , int videoSizeY) {
		this.videoSizeX = videoSizeX;
		this.videoSizeY = videoSizeY;
	}
	
	
	public void setWindowedMode() {
		
		Gdx.graphics.setWindowedMode(videoSizeX,videoSizeY);
	}
	
	public int getVideoSizeX() {
		return videoSizeX;
	}


	public int getVideoSizeY() {
		return videoSizeY;
	}


	public void setResizable(boolean resizable) {
		Gdx.graphics.setResizable(false);
	}
	
	public void setTitle(String title) {
		Gdx.graphics.setTitle(title);
	}
	
	public void setFixElements() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, videoSizeX, videoSizeY);
		camera.update();
		viewport = new ScreenViewport(camera);
	}
	
	public void resizeScreen(int width,int height) {
		viewport.update(width, height);
	}	
	
	public OrthographicCamera getCamera() {
		return this.camera;
	}


	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	
	public void minimizeScreen() {
		Gdx.graphics.setWindowedMode(1, 1);
	}
	
}
