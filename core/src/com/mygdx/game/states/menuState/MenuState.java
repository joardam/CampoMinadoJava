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
import com.mygdx.game.states.gameModeState.GameEndlessMode;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;


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
    private float selectorRectangleWidth; 
	private float selectorRectangleHeight;
	
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
				
				"classicMode" , 35 , "MODO CLASSICO",
				new RgbaColor("white"), 
				new FloatCoordinates(screenWidth/2f   ,screenHeight/2f + 2*spaceBetweenBars),
				
				"2playersMode" , 35 , "MODO 2 JOGADORES",
				new RgbaColor("white"), 
				new FloatCoordinates(screenWidth/2f ,screenHeight/2f + spaceBetweenBars),
				
				"crazyMode" , 35 , "MODO MALUCO",
				new RgbaColor("green"),
				new FloatCoordinates(screenWidth/2f ,screenHeight/2f ),
				
				"endlessMode" , 35 , "MODO SEM FIM",
				new RgbaColor("white"),
				new FloatCoordinates(screenWidth/2f ,screenHeight/2f - spaceBetweenBars)
				
				);
			
			
		
		difficultyTexts = new TextCollection(
				"eazy" , 35 , "FACIL" ,
				new RgbaColor("green"),
				new FloatCoordinates(screenWidth/2f , screenHeight/2f  - 3*spaceBetweenBars),
				
				"medium" , 35 , "MEDIO"  ,
				new RgbaColor("yellow"),
				new FloatCoordinates(screenWidth/2f, screenHeight/2f - 3*spaceBetweenBars),
				
				"hard" ,35, "DIFICIL" ,
				new RgbaColor("red"),
				new FloatCoordinates(screenWidth/2f, screenHeight/2f - 3*spaceBetweenBars)
				
				
				);
		
				
		
		
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		rectangleInCenterPosition = new float[2];
		
		rectangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2;
		rectangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
		whiteRetangleInCenterPosition = new float[2];
		
		whiteRetangleInCenterPosition[0] = screenWidth/2 - rectangleWidth / 2 + rectangleHeight;
		whiteRetangleInCenterPosition[1] = screenHeight/2 -  rectangleHeight/ 2;
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
		arrowTexts = new TextCollection(
				"decreaseArrow" , 35 , "<" ,
				new RgbaColor("black"),
				new FloatCoordinates(rectangleInCenterPosition[0] + selectorRectangleHeight/2 , screenHeight /2f  - 3*spaceBetweenBars),
				
				"increaseArrow" , 35, ">" ,
				new RgbaColor("black"),
				new FloatCoordinates(rectangleInCenterPosition[0] +selectorRectangleHeight + selectorRectangleWidth +  selectorRectangleHeight/2 , screenHeight /2f  - 3*spaceBetweenBars));
		
		menuDifficultyManager = new MenuDifficultyManager(difficultyTexts);
		
	}
	
	
	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
		
		shapes.shapesBegin("classicMode" , "2playersMode" , "crazyMode" , "difficultyBar" , "difficultyCenterForText" , "endlessMode");
	
		
		
		
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
				
				"endlessMode",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] + (-1)*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				
				"difficultyBar",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] - 3*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight),
				
				"difficultyCenterForText",
				new FloatCoordinates(whiteRetangleInCenterPosition[0] , rectangleInCenterPosition[1] - 3*spaceBetweenBars),
				new FloatCoordinates(selectorRectangleWidth , selectorRectangleHeight )
				);
		
			

	    
			shapes.shapesEnd("classicMode" , "2playersMode" , "crazyMode" , "difficultyBar" , "difficultyCenterForText", "endlessMode");
	    
	    
	    
	    
	    
		sprite.begin();
		TextDraw.draw(sprite, menuTexts.getText("classicMode"));
	    TextDraw.draw(sprite, menuTexts.getText("2playersMode"));
	    TextDraw.draw(sprite, menuTexts.getText("crazyMode"));
	    TextDraw.draw(sprite, menuTexts.getText("endlessMode"));
	    
	    TextDraw.draw(sprite, difficultyTexts.getText(menuDifficultyManager.getDifficultyStringIdNow()));
	    TextDraw.draw(sprite, arrowTexts.getText("decreaseArrow"));
	    TextDraw.draw(sprite, arrowTexts.getText("increaseArrow"));
	    
	    
	    
		sprite.end();
		
		
		
		
	}

	@Override
	public void handleInput() {
			if (mouse.eventMouseLeftClickOnce())
			{
				if(GameUtils.isIn2DSpaceBound(
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
			
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] ,
						(float)rectangleInCenterPosition[1] + spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth ,
						(float)rectangleInCenterPosition[1] + rectangleHeight + spaceBetweenBars
						)) {
					gsm.set(new Game2PlayersModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] + 0*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth,
						(float)rectangleInCenterPosition[1] + rectangleHeight + 0*spaceBetweenBars
						)) {
					gsm.set(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyStringIdNow()));
				
				}
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] + (-1)*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + rectangleWidth,
						(float)rectangleInCenterPosition[1] + rectangleHeight + (-1)*spaceBetweenBars
						)) {
					gsm.set(new GameEndlessMode(gsm,mouse));
				
				}
				
				
				
				else if(GameUtils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + selectorRectangleHeight,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + selectorRectangleHeight)){
					menuDifficultyManager.decreaseDificultyIndex();
				}
				else if(GameUtils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] +  selectorRectangleHeight +  selectorRectangleWidth ,
						(float)rectangleInCenterPosition[1] - spaceBetweenBars*3,
						(float)rectangleInCenterPosition[0] + 3*selectorRectangleHeight + selectorRectangleWidth,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + selectorRectangleHeight)){
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
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
		
		
		
		
		mouse.setMousePosition();
		handleInput();
	}

	

	@Override
	public void dispose() {
		menuTexts.disposeAll();
		shapes.disposeAll();
		
	}


	




	

	
	
}
