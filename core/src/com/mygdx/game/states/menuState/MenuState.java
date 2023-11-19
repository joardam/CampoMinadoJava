package com.mygdx.game.states.menuState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.TextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.TextDraw;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.WriteTest;
import com.mygdx.game.states.gameModeState.Game2PlayersModeState;
import com.mygdx.game.states.gameModeState.GameClassicModeState;
import com.mygdx.game.states.gameModeState.GameCrazyModeState;
import com.mygdx.game.states.gameModeState.GameEndlessMode;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManagerParameter;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.Coordinates;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;


public class MenuState extends State {
	

	private VideoSettings videoConfig = new VideoSettings();
	private BarWithTextCollection modeBars;
	private BarWithTextCollection difficultyBars;
	private TextCollection difficultyTexts;
	
	
	private TextCollection arrowTexts;
	private MenuDifficultyManager menuDifficultyManager = new MenuDifficultyManager(
			new MenuDifficultyManagerParameter("FACIL", Color.GREEN ),
			new MenuDifficultyManagerParameter("MEDIO", Color.YELLOW ),
			new MenuDifficultyManagerParameter("DIFICIL", Color.RED )
			);
	
	
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
				"difficultyBar", new RgbaColor("gray"),
				"difficultyCenterForText" , new RgbaColor("dark_gray")
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
		
		
		modeBars = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"endlessBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 - spaceBetweenBars),
								"MODO SEM FIM",Color.GRAY, Color.WHITE) 
						) ,
				
				BarWithTextCollectionParameters.getParameters(
						"crazyBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2),
								"MODO MALUCO",Color.GRAY, Color.GREEN)
						),
				
				BarWithTextCollectionParameters.getParameters(
						"2PlayersBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2+ spaceBetweenBars ),
								"MODO 2 JOGADORES",Color.GRAY, Color.WHITE)		
				),
				
				BarWithTextCollectionParameters.getParameters(
						"classicBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 + spaceBetweenBars * 2),
								"MODO CLASSICO",Color.GRAY, Color.WHITE)
				)
				
			);
		
		
		difficultyBars = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"difficultyBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleWidth,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 - spaceBetweenBars*3),
								menuDifficultyManager.getDifficultyStringNow(),
								Color.DARK_GRAY,
								menuDifficultyManager.getDifficultyColorNow()
								)
						)
				
				);		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
		
		shapes.shapesBegin("difficultyBar");
	
		
		
		
		shapes.setRect(
				
				"difficultyBar",
				new FloatCoordinates(rectangleInCenterPosition[0], rectangleInCenterPosition[1] - 3*spaceBetweenBars),
				new FloatCoordinates(rectangleWidth, rectangleHeight)
			);
			

	    
		shapes.shapesEnd("difficultyBar");
	    
	    
	    
			
		modeBars.drawBars(sprite, "endlessBar" , "crazyBar" , "classicBar" , "2PlayersBar");
		difficultyBars.drawBars(sprite,"difficultyBar");
	    
	    
		sprite.begin();
		
	    
	   
	    TextDraw.draw(sprite, arrowTexts.getText("decreaseArrow"));
	    TextDraw.draw(sprite, arrowTexts.getText("increaseArrow"));
	    
		sprite.end();
		
		
		
		
	}

	@Override
	public void handleInput() {
			if (mouse.eventMouseLeftClickOnce())
			{
				if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("classicBar").getBarRegion() )){
					gsm.set(new GameClassicModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringNow()));
					dispose();
				}
			
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("2PlayersBar").getBarRegion() )){
					gsm.set(new Game2PlayersModeState(gsm,mouse,menuDifficultyManager.getDifficultyStringNow()));
				
				}
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("crazyBar").getBarRegion() )){
					
					gsm.set(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyStringNow()));
				
				}
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("endlessBar").getBarRegion() )){
					gsm.set(new GameEndlessMode(gsm,mouse));
				
				}
				
				
				
				else if(GameUtils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0],
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars,
						(float)rectangleInCenterPosition[0] + selectorRectangleHeight,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + selectorRectangleHeight)){
					menuDifficultyManager.decreaseDificultyIndex();
					updateHandles();
				}
				else if(GameUtils.isIn2DSpaceBound(mouse.getMouseX(), mouse.getMouseY() ,
						(float)rectangleInCenterPosition[0] +  selectorRectangleHeight +  selectorRectangleWidth ,
						(float)rectangleInCenterPosition[1] - spaceBetweenBars*3,
						(float)rectangleInCenterPosition[0] + 3*selectorRectangleHeight + selectorRectangleWidth,
						(float)rectangleInCenterPosition[1] - 3*spaceBetweenBars + selectorRectangleHeight)){
					menuDifficultyManager.increaseDificultyIndex();
					updateHandles();
				}
		
			}	
	}

	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
	}
	
	public void updateHandles(){
		difficultyBars.getBar("difficultyBar").setStringText(menuDifficultyManager.getDifficultyStringNow());
		difficultyBars.getBar("difficultyBar").setColor(menuDifficultyManager.getDifficultyColorNow());
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
		shapes.disposeAll();
		
	}


	




	

	
	
}
