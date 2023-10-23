package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.config.VideoSettings;


public class MyGdxGame extends ApplicationAdapter {
	
	VideoSettings videoConfig = new VideoSettings();
	
	
	@Override
	public void create () {
		
		videoConfig.setRows(12);
		videoConfig.setCols(12);
		videoConfig.setSpriteSize(32);
		
       
        videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
        
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        SpriteBatch spriteBatch = new SpriteBatch();
        spriteBatch.begin();
        spriteBatch.end();
		
	}
	
	@Override
	public void dispose () {
		
	}
}
