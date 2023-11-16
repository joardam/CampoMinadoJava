package com.mygdx.game.states.menuState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.TextCollection;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.TextDraw;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.WriteTest;
import com.mygdx.game.states.gameModeState.Game2PlayersModeState;
import com.mygdx.game.states.gameModeState.GameClassicModeState;
import com.mygdx.game.states.gameModeState.GameCrazyModeState;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.Utils;


public class MenuState extends State {
	

	private VideoSettings videoConfig = new VideoSettings();
	
	private TextCollection menuTexts ;
	private TextCollection difficultyTexts;
	private TextCollection arrowTexts;
	private MenuDifficultyManager menuDifficultyManager;
	
	private ShapeCollection shapes;
	
	private float rectangleWidth;
    private float rectangleHeight;
    
    private float[] rectangleInCenterPosition;
    private float[] whiteRetangleInCenterPosition;
    private float whiteRectangleWidth; 
	private float whiteRectangleHeight;
	
	private int spaceBetweenBars;
	
	private int screenWidth;
	private int screenHeight;

	
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
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		
		spaceBetweenBars = 70;
		
		shapes = new ShapeCollection(
				"classicMode" , new RgbaColor("gray") ,
				"2playersMode" , new RgbaColor("gray"),
				"crazyMode" , new RgbaColor("gray"),
				"endlessMode" , new RgbaColor("gray"),
				"difficultyBar", new RgbaColor("gray"),
				"difficultyCenterForText" , new RgbaColor("dark_gray")
				);
		
		menuTexts = new TextCollection(
				
				"classicMode" , "MODO CLASSICO" , 35 , 
				new RgbaColor("white"), 
				new FloatCoordinates(screenWidth/2f - 200f ,screenHeight/2f + 12 + 2*spaceBetweenBars),
				
				"2playersMode" , "MODO 2 JOGADORES" , 35 ,
				new RgbaColor("white"), 
				new FloatCoordinates(screenWidth/2f - 200f ,screenHeight/2f + 12 + spaceBetweenBars),
				
				"crazyMode" , "MODO MALUCO" , 35 ,
				new RgbaColor("green"),
				new FloatCoordinates(screenWidth/2f - 200f ,screenHeight/2f + 12),
				
				"endlessMode" , "MODO SEM FIM", 35,
				new RgbaColor("white"),
				new FloatCoordinates(screenWidth/2f - 200f ,screenHeight/2f + 12 - spaceBetweenBars)
				
				);
			
			
		
		difficultyTexts = new TextCollection(
				"eazy" , "FACIL" , 35 ,
				new RgbaColor("green"),
				new FloatCoordinates(screenWidth/2f - 60, screenHeight/2f + 12 - 3*spaceBetweenBars),
				
				"medium" , "MEDIO" , 35 ,
				new RgbaColor("yellow"),
				new FloatCoordinates(screenWidth/2f - 60, screenHeight/2f + 12 - 3*spaceBetweenBars),
				
				"hard" , "DIFICIL" , 35 ,
				new RgbaColor("red"),
				new FloatCoordinates(screenWidth/2f - 60, screenHeight/2f + 12 - 3*spaceBetweenBars)
				
				
				);
		
				arrowTexts = new TextCollection(
				"decreaseArrow" , "<" , 35,
				new RgbaColor("black"),
				new FloatCoordinates(screenWidth/2f - 250f + 15 , screenHeight /2f + 12 - 3*spaceBetweenBars),
				
				"increaseArrow" , ">" , 35,
				new RgbaColor("black"),
				new FloatCoordinates(screenWidth/2f + 250f - 30 , screenHeight /2f + 12 - 3*spaceBetweenBars));
		
		menuDifficultyManager = new MenuDifficultyManager(difficultyTexts);
		
		
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		rectangleInCenterPosition = new float[2];
		
		rectangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2;
		rectangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
		whiteRetangleInCenterPosition = new float[2];
		
		whiteRetangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2 + rectangleHeight;
		whiteRetangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
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
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] + 2*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"2playersMode",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] + spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"crazyMode",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] + 0*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"difficultyBar",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] - 3*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"difficultyCenterForText",
				new FloatCoordinates(whiteRetangleInCenterPosition[0] , rectangleInCenterPosition[1] - 3*spaceBetweenBars),
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
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] + 2*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth,
						(float)rectangleInCenterPosition[1] + rectangleHeight + 2*spaceBetweenBars
						))
				{
					gsm.set(new GameClassicModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringIdNow()));
					dispose();
				}
			
				
				else if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] ,
						(float)rectangleInCenterPosition[1] + spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth ,
						(float)rectangleInCenterPosition[1] + rectangleHeight + spaceBetweenBars
						)) {
					gsm.set(new Game2PlayersModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				else if(Utils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] + 0*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth,
						(float)rectangleInCenterPosition[1] + rectangleHeight + 0*spaceBetweenBars
						)) {
					gsm.set(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				
				
				
				else if(Utils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + whiteRectangleHeight,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + whiteRectangleHeight)){
					menuDifficultyManager.decreaseDificultyIndex();
				}
				else if(Utils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] +  whiteRectangleHeight +  whiteRectangleWidth ,
						(float)rectangleInCenterPosition[1] - spaceBetweenBars*3,
						(float)rectangleInCenterPosition[0] + 3*whiteRectangleHeight + whiteRectangleWidth,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + whiteRectangleHeight)){
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
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		rectangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2;
		rectangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
	
		
		whiteRetangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2 + rectangleHeight;
		whiteRetangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
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
