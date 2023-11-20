package com.mygdx.game.states.menuState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.gameModeState.Game2PlayersModeState;
import com.mygdx.game.states.gameModeState.GameClassicModeState;
import com.mygdx.game.states.gameModeState.GameCrazyModeState;
import com.mygdx.game.states.gameModeState.GameEndlessMode;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManagerParameter;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;


public class MenuState extends State {
	

	private VideoSettings videoConfig = new VideoSettings();
	private BarWithTextCollection modeBars;
	private BarWithTextCollection difficultyBars;
	private MenuDifficultyManager menuDifficultyManager = new MenuDifficultyManager(
			new MenuDifficultyManagerParameter("FACIL", Color.GREEN ),
			new MenuDifficultyManagerParameter("MEDIO", Color.YELLOW ),
			new MenuDifficultyManagerParameter("DIFICIL", Color.RED )
			);
	

	
	private float rectangleWidth;
    private float rectangleHeight;
    
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
			
				
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
		
		
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
					
						),
				
				BarWithTextCollectionParameters.getParameters(
						"increaseBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2 + selectorRectangleWidth/2 + selectorRectangleHeight/2,screenHeight/2 - spaceBetweenBars*3),
								">",
								Color.GRAY,
								Color.BLACK
								)
						),
				BarWithTextCollectionParameters.getParameters(
						"decreaseBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2 - selectorRectangleWidth/2 - selectorRectangleHeight/2 ,screenHeight/2 - spaceBetweenBars*3),
								"<",
								Color.GRAY,
								Color.BLACK
								)
						)
				
				);		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
			
		modeBars.drawBars(sprite, "endlessBar" , "crazyBar" , "classicBar" , "2PlayersBar");
		difficultyBars.drawBars(sprite,"difficultyBar" , "increaseBar" , "decreaseBar");
	    

		
		
		
		
	}

	@Override
	public void handleInput() {
			
		if(		
				modeBars.actorInAnyBar(mouse.getMousePosition()) ||
				difficultyBars.actorInListedBars(mouse.getMousePosition() , "increaseBar" , "decreaseBar")
				) {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
		}else {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
		}
		
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
					dispose();
				
				}
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("crazyBar").getBarRegion() )){
					
					gsm.set(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyStringNow()));
					dispose();
				
				}
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("endlessBar").getBarRegion() )){
					gsm.set(new GameEndlessMode(gsm,mouse));
					dispose();
				
				}
			
				
				else if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),difficultyBars.getBar("increaseBar").getBarRegion())){
					menuDifficultyManager.increaseDificultyIndex();
					updateHandles();
				}
				else if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),difficultyBars.getBar("decreaseBar").getBarRegion() )){
					menuDifficultyManager.decreaseDificultyIndex();
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
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
	
		
		
		mouse.setMousePosition();
		handleInput();
	}

	

	@Override
	public void dispose() {
		modeBars.disposeAll();
		difficultyBars.disposeAll();
		}


	




	

	
	
}
