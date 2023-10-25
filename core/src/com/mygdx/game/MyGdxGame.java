package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.gameField.GameField;
import com.mygdx.mouseTrack.MouseTrack;


public class MyGdxGame extends ApplicationAdapter {
	
	int rows = 12;
	int cols = 12;
	int spriteSize = 32;
	
  
	SpriteBatch sprite;
	Texture texture;
	
	
	VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	GameField field = new GameField(rows,cols);
	FieldDraw draw =  new FieldDraw(field,spriteSize);

	MouseTrack mouse = new MouseTrack(spriteSize,rows,cols);
	
	
	@Override
	public void create () {
		
		videoConfig.setFixElements();
		

		sprite = new SpriteBatch();
		texture = new Texture("newsprites.jpg");
		
		
        videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
           
        field.fillCells();
        
	}
	
	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
		
    }
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        SpriteConfig.setProjectionMatrix(sprite,videoConfig);
        mouse.setMousePosition();
        
        
        if(mouse.eventMouseLeftClickOnce()) {
        	System.out.print("clicou");
        }
        
        sprite.begin();
        draw.drawField(sprite, texture);
        sprite.end();
		
	}
	
	@Override
	public void dispose () {
		sprite.dispose();
		texture.dispose();
	}
}
