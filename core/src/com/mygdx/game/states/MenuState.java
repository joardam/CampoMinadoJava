package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.texts.Texts;


public class MenuState extends State {
	

	private VideoSettings videoConfig = new VideoSettings();
	private Texts menuTexts = new Texts(
			"2playersMode" , "Modo 2 jogadores" , 35);
	
	
	ShapeRenderer shape = new ShapeRenderer();
	
	
	float rectangleWidth = 500;
    float rectangleHeightDoRetangulo  = 50;
    
    float screenWidth = Gdx.graphics.getWidth();
	float screenHeight = Gdx.graphics.getHeight();;
    
	float centerX;
	float centerY;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Menu");
		
	  
	    centerX = screenWidth / 2 - rectangleWidth / 2;
	    centerY = screenHeight/ 2 - rectangleHeightDoRetangulo / 2;
		
		
		menuTexts.setColors("2playersMode" , 1f,1f,1f,1f);
		menuTexts.setTextPositions("2playersMode",350f - 155, 350f + 12);
		
	}

	
	

	@Override
	public void handleInput() {
		if (mouse.eventMouseLeftClickOnce()) {
			gsm.set(new GameState(gsm,mouse));
			dispose();
		}
		
		
	}

	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
	}

	@Override
	public void update(float dt) {
		mouse.setMousePosition();
		handleInput();
	}

	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		shape.setColor(0.5f, 0.5f, 0.5f, 1.0f);
		
		shape.begin(ShapeType.Filled);
	    shape.rect(centerX, centerY, rectangleWidth, rectangleHeightDoRetangulo);
	    shape.end();
	    
		sprite.begin();
	    TextDraw.draw(sprite, menuTexts.getText("2playersMode"));
		sprite.end();
		
		
		
		
	}

	@Override
	public void dispose() {
		menuTexts.disposeAll();
		shape.dispose();
		
	}




	

	
	
}
