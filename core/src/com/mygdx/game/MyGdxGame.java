package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.gameField.FieldCellsInteractionManager;
import com.mygdx.gameField.GameField;
import com.mygdx.mouseTrack.MouseTrack;


public class MyGdxGame extends ApplicationAdapter {
	
	private int rows = 12;
	private int cols = 18;
	private int spriteSize = 32;
	
  
	private SpriteBatch sprite;
	private Texture texture;
	
	
	private VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	private GameField field = new GameField(rows,cols);
	private FieldDraw draw =  new FieldDraw(field,spriteSize);

	private MouseTrack mouse = new MouseTrack(spriteSize,rows,cols);
	
	
	@Override
	public void create () {
		
		videoConfig.setFixElements();
		

		sprite = new SpriteBatch();
		texture = new Texture("newsprites.jpg");
		
        videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
           
        field.fillCells();
        field.placeBombs();
        field.placeCountersInSafeCells();
        
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
        	FieldCellsInteractionManager.tryToUncoverThisCell(mouse, field);
        }
        
        if(mouse.eventMouseRightClickOnce()) {
        	FieldCellsInteractionManager.tryToToggleFlagThisCell(mouse, field);
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
