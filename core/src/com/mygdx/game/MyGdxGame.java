package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.gameField.GameField;


public class MyGdxGame extends ApplicationAdapter {
	
	int rows = 12;
	int cols = 12;
	int spriteSize = 32;
	
	private Viewport viewport;
    private OrthographicCamera camera;
	
	SpriteBatch sprite;
	Texture texture;
	
	VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	GameField field = new GameField(rows,cols);
	FieldDraw draw =  new FieldDraw(field,spriteSize);
	
	@Override
	public void create () {
		int videoSizex = rows * spriteSize;
		int videoSizey = cols * spriteSize;
	
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, videoSizex, videoSizey);
		camera.update();
		viewport = new ScreenViewport(camera);
		
        
		sprite = new SpriteBatch();
		texture = new Texture("newsprites.jpg");
		
		
        videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
           
        field.fillMatrixes();
        
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		
    }
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        sprite.setProjectionMatrix(camera.combined);
        
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
