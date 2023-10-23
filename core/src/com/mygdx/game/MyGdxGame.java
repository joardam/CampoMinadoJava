package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class MyGdxGame extends ApplicationAdapter {
	int rows = 12;
	int cols = 12;
	int spriteSize = 32;

	
	
	@Override
	public void create () {
		int videoSizex = rows * spriteSize;
        int videoSizey = cols * spriteSize;
        
        
        Gdx.graphics.setWindowedMode(videoSizex,videoSizey);
        Gdx.graphics.setResizable(false);
        Gdx.graphics.setTitle("Campo Minado");
        
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
