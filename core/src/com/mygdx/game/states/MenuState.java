package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	
	private TextCollection menuTexts ;
	private TextCollection difficultyTexts;
	TextCollection arrowTexts;
	private MenuDifficultyManager menuDifficultyManager;
	
	private ShapeCollection shapes;
	
	float rectangleWidth;
    float rectangleHeight;
    
    float[] rectangleInCenterPosition;
    float[] whiteRetangleInCenterPosition;
    float whiteRectangleWidth; 
	float whiteRectangleHeight;

	
	public MenuState(StateManager gsm) {
		super(gsm);
		create();
		
	}
	
	@Override
	public void create() {
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Menu");
		
		shapes = new ShapeCollection(
				"classicMode" , new RgbaColor("gray") ,
				"2playersMode" , new RgbaColor("gray"),
				"crazyMode" , new RgbaColor("gray"),
				"difficultyBar", new RgbaColor("gray"),
				"difficultyCenterForText" , new RgbaColor("dark_gray")
				);
		
		menuTexts = new TextCollection(
				
				"classicMode" , "MODO CLASSICO" , 35 , 
				new RgbaColor("white"), 
				new FloatCoordinates(700/2f - 200f ,700/2f + 12 + 70f),
				
				"2playersMode" , "MODO 2 JOGADORES" , 35 ,
				new RgbaColor("white"), 
				new FloatCoordinates(700/2f - 200f ,700/2f + 12),
				
				"crazyMode" , "MODO MALUCO" , 35 ,
				new RgbaColor("green"),
				new FloatCoordinates(700/2f - 200f , 700 /2f + 12 - 70f)
				);
		
		difficultyTexts = new TextCollection(
				"eazy" , "FACIL" , 35 ,
				new RgbaColor("green"),
				new FloatCoordinates(700/2f - 60, 700 /2f + 12 - 70*3f),
				
				"medium" , "MEDIO" , 35 ,
				new RgbaColor("yellow"),
				new FloatCoordinates(700/2f - 60, 700 /2f + 12 - 70*3f),
				
				"hard" , "DIFICIL" , 35 ,
				new RgbaColor("red"),
				new FloatCoordinates(700/2f - 60 , 700 /2f + 12 - 70*3f)
				
				
				);
		
				arrowTexts = new TextCollection(
				"decreaseArrow" , "<" , 35,
				new RgbaColor("black"),
				new FloatCoordinates(700/2f - 250f + 15 , 700 /2f + 12 - 70*3f),
				
				"increaseArrow" , ">" , 35,
				new RgbaColor("black"),
				new FloatCoordinates(700/2f + 250f - 30 , 700 /2f + 12 - 70*3f));
		
		menuDifficultyManager = new MenuDifficultyManager(difficultyTexts);
		
		
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		rectangleInCenterPosition = new float[2];
		
		rectangleInCenterPosition[0] = Gdx.graphics.getWidth()/2 - rectangleWidth / 2;
		rectangleInCenterPosition[1] = Gdx.graphics.getHeight()/2 -  rectangleHeight/ 2;
		
		whiteRetangleInCenterPosition = new float[2];
		
		whiteRetangleInCenterPosition[0] = Gdx.graphics.getWidth()/2 - rectangleWidth / 2 + rectangleHeight;
		whiteRetangleInCenterPosition[1] = Gdx.graphics.getHeight()/2 -  rectangleHeight/ 2;
		
		whiteRectangleWidth = rectangleWidth - rectangleHeight*2; 
		whiteRectangleHeight  = rectangleHeight;
		
		
		
	}
	
	
	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
		
		shapes.shapesBegin("classicMode" , "2playersMode" , "crazyMode" , "difficultyBar" , "difficultyCenterForText");
	
		
		
		
		shapes.setRect(
				"classicMode", 
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] + 70),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"2playersMode",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1]),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"crazyMode",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] - 70),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"difficultyBar",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] - 70*3),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"difficultyCenterForText",
				new FloatCoordinates(whiteRetangleInCenterPosition[0] , rectangleInCenterPosition[1] - 70*3),
				new FloatCoordinates(whiteRectangleWidth , whiteRectangleHeight )
				);
		
			

	    
			shapes.shapesEnd("classicMode" , "2playersMode" , "crazyMode" , "difficultyBar" , "difficultyCenterForText");
	    
	    
	    
	    
	    
		sprite.begin();
		TextDraw.draw(sprite, menuTexts.getText("classicMode"));
	    TextDraw.draw(sprite, menuTexts.getText("2playersMode"));
	    TextDraw.draw(sprite, menuTexts.getText("crazyMode"));
	    
	    TextDraw.draw(sprite, difficultyTexts.getText(menuDifficultyManager.getDifficultyStringIdNow()));
	    TextDraw.draw(sprite, arrowTexts.getText("decreaseArrow"));
	    TextDraw.draw(sprite, arrowTexts.getText("increaseArrow"));
	    
	    
	    
		sprite.end();
		
		
		
		
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
				
					gsm.set(new GameClassicModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringIdNow()));
					dispose();
				}
			
				
				else if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)700 / 2 - rectangleWidth / 2,
						(float)700 / 2 - rectangleHeight/ 2 ,
						(float)700 / 2 + rectangleWidth / 2,
						(float)700 / 2 + rectangleHeight/ 2
						)) {
					gsm.set(new Game2PlayersModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				else if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)700 / 2 - rectangleWidth / 2,
						(float)700 / 2 - rectangleHeight/ 2 - 70f,
						(float)700 / 2 + rectangleWidth / 2,
						(float)700 / 2 + rectangleHeight/ 2 - 70f
						)) {
					gsm.set(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				else if(Utils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] - 70*3,
						(float)rectangleInCenterPosition[0] + 50,
						(float)rectangleInCenterPosition[1] - 70*3 + 50)){
					menuDifficultyManager.decreaseDificultyIndex();
				}
				else if(Utils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] + 50  +  whiteRectangleWidth ,
						(float)rectangleInCenterPosition[1] - 70*3,
						(float)rectangleInCenterPosition[0] + 50 + 50 + whiteRectangleWidth,
						(float)rectangleInCenterPosition[1] - 70*3 + 50)){
					menuDifficultyManager.increaseDificultyIndex();
				}
		
			}	
	}

	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
	}

	@Override
	public void update(float dt) {
		
		
		
		rectangleInCenterPosition[0] = Gdx.graphics.getWidth()/2 - rectangleWidth / 2;
		rectangleInCenterPosition[1] = Gdx.graphics.getHeight()/2 -  rectangleHeight/ 2;
		
	
		
		whiteRetangleInCenterPosition[0] = Gdx.graphics.getWidth()/2 - rectangleWidth / 2 + rectangleHeight;
		whiteRetangleInCenterPosition[1] = Gdx.graphics.getHeight()/2 -  rectangleHeight/ 2;
		
		whiteRectangleWidth = rectangleWidth - rectangleHeight*2; 
		whiteRectangleHeight  = rectangleHeight;
		
		
		
		mouse.setMousePosition();
		handleInput();
	}

	

	@Override
	public void dispose() {
		menuTexts.disposeAll();
		shapes.disposeAll();
		
	}


	




	

	
	
}
