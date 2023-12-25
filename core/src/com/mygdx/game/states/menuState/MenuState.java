package com.mygdx.game.states.menuState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.ScoreBoardState;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.gameModeState.Game2PlayersModeState;
import com.mygdx.game.states.gameModeState.GameClassicModeState;
import com.mygdx.game.states.gameModeState.GameCrazyModeState;
import com.mygdx.game.states.gameModeState.gameEndlessMode.GameEndlessMode;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManagerParameter;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.InteractionManager;


public class MenuState extends State {

	
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
	
	private FloatCoordinates scoreBoardRect;
	
	
	private int spaceBetweenBars;
	
	private int screenWidth;
	private int screenHeight;

	
	private InteractionManager renderInteraction = new InteractionManager();
	
	public MenuState(StateManager gsm) {
		super(gsm);
		configure();
		create();
		
		
	}
	
	
	@Override
	public void configure() {
		renderInteraction.startInteraction();
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Menu");
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
	}
	
	@Override
	public void create() {
		
		
		
		spaceBetweenBars = 70;
			
				
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
		
		scoreBoardRect = new FloatCoordinates(((float) (rectangleWidth*0.6) ) , (float) (rectangleHeight*0.7));
		
		
		
		modeBars = new BarWithTextCollection(
				
				BarWithTextCollectionParameters.getParameters(
						"scoreBoardBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(scoreBoardRect.getCoordinateX(),scoreBoardRect.getCoordinateY() ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 - 1*spaceBetweenBars ),
								"RANKING",Color.GRAY, Color.WHITE)
				),
				
				
				
				BarWithTextCollectionParameters.getParameters(
						"endlessBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 ),
								"MODO SEM FIM",Color.GRAY, Color.WHITE) 
						) ,
				
				BarWithTextCollectionParameters.getParameters(
						"crazyBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 + spaceBetweenBars),
								"MODO MALUCO",Color.GRAY, Color.GREEN)
						),
				
				BarWithTextCollectionParameters.getParameters(
						"2PlayersBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2+ 2*spaceBetweenBars ),
								"MODO 2 JOGADORES",Color.GRAY, Color.WHITE)		
				),
				
				BarWithTextCollectionParameters.getParameters(
						"classicBar" ,
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth,rectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 + spaceBetweenBars * 3),
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
		if (!renderInteraction.inAction()) {
			return;
		}
		
		
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
			
		modeBars.drawBars(sprite, "endlessBar" , "crazyBar" , "classicBar" , "2PlayersBar", "scoreBoardBar");
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
						mouse.getMousePosition(),modeBars.getBar("classicBar").getBarRegion())){
					renderInteraction.stopInteraction();
					gsm.push(new GameClassicModeState(gsm,mouse,menuDifficultyManager.getDifficultyIndexNow()));
					
					
				}
			
				
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("scoreBoardBar").getBarRegion() )){
					Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
					gsm.push(new ScoreBoardState(gsm, mouse));
				}
				
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("2PlayersBar").getBarRegion() )){
					renderInteraction.stopInteraction();
					gsm.push(new Game2PlayersModeState(gsm,mouse,menuDifficultyManager.getDifficultyIndexNow()));
					
				
				}
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("crazyBar").getBarRegion() )){
					renderInteraction.stopInteraction();
					gsm.push(new GameCrazyModeState(gsm,mouse, menuDifficultyManager.getDifficultyIndexNow()));
					
					
				
				}
				
				else if(GameUtils.isIn2DSpaceBound(
						mouse.getMousePosition(),modeBars.getBar("endlessBar").getBarRegion() )){
					renderInteraction.stopInteraction();
					gsm.push(new GameEndlessMode(gsm,mouse,menuDifficultyManager.getDifficultyIndexNow()));
				
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
