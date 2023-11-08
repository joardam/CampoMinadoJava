package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.texts.TextCollection;
import com.mygdx.shapes.ShapeCollection;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.Utils;


public class MenuState extends State {
	

	private VideoSettings videoConfig = new VideoSettings();
	
	private TextCollection menuTexts = new TextCollection(
			
			"classicMode" , "MODO CLASSICO" , 35 , 
			new RgbaColor("white"), 
			new FloatCoordinates(700/2f - 200f ,700/2f + 12 + 70f),
			
			"2playersMode" , "MODO 2 JOGADORES" , 35 ,
			new RgbaColor("white"), 
			new FloatCoordinates(700/2f - 200f ,700/2f + 12)
			);
	
	
	private ShapeCollection shapes;
	
	float rectangleWidth = 500;
    float rectangleHeight  = 50;
    
   
	
	public MenuState(StateManager gsm) {
		
		
		super(gsm);
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Menu");
		shapes = new ShapeCollection("classicMode" , "2playersMode");
		

	}
	

	@Override
	public void handleInput() {
			if (mouse.eventMouseLeftClickOnce())
			{
				if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)700 / 2 - rectangleWidth / 2,
						(float)700 / 2 - rectangleHeight/ 2 + 70f,
						(float)700 / 2 + rectangleWidth / 2,
						(float)700 / 2 + rectangleHeight/ 2 + 70f
						))
				{
				
					gsm.set(new GameClassicModeState(gsm,mouse));
					dispose();
				}
			
				
				else if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)700 / 2 - rectangleWidth / 2,
						(float)700 / 2 - rectangleHeight/ 2 ,
						(float)700 / 2 + rectangleWidth / 2,
						(float)700 / 2 + rectangleHeight/ 2
						)) {
					gsm.set(new Game2PlayersModeState(gsm,mouse));
				
				}
		
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
		
		
		shapes.getShape("classicMode").setColor(128/255f, 128/255f, 128/255f, 1f);
		shapes.getShape("2playersMode").setColor(128/255f, 128/255f, 128/255f, 1f);
		
		
		shapes.getShape("classicMode").begin(ShapeType.Filled);
		shapes.getShape("classicMode").rect(700/2 - rectangleWidth / 2, 700/2 -  rectangleHeight/ 2 + 70, rectangleWidth, rectangleHeight);
		shapes.getShape("classicMode").end();
		
		shapes.getShape("2playersMode").begin(ShapeType.Filled);
	    shapes.getShape("2playersMode").rect(700/2 - rectangleWidth / 2, 700/2 -  rectangleHeight/ 2, rectangleWidth, rectangleHeight);
	    shapes.getShape("2playersMode").end();
	    
		sprite.begin();
		TextDraw.draw(sprite, menuTexts.getText("classicMode"));
	    TextDraw.draw(sprite, menuTexts.getText("2playersMode"));
		sprite.end();
		
		
		
		
	}

	@Override
	public void dispose() {
		menuTexts.disposeAll();
		shapes.disposeAll();
		
	}




	

	
	
}
