package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.config.SpriteConfig;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManagerParameter;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;





public class ScoreBoardState extends State {

	private int screenWidth;
	private int screenHeight;
	
	private MenuDifficultyManager menuDifficultyManager = new MenuDifficultyManager(
			new MenuDifficultyManagerParameter("FACIL", Color.GREEN ),
			new MenuDifficultyManagerParameter("MEDIO", Color.YELLOW ),
			new MenuDifficultyManagerParameter("DIFICIL", Color.RED )
			);
	private BarWithTextCollection difficultyBars;
	private float selectorRectangleWidth; 
	private float selectorRectangleHeight;
	private int spaceBetweenBars;
	private float rectangleWidth;
    private float rectangleHeight;
    
    
    private BarWithText backToMenu;
    private int backToMenuRectangleWidth = 100;
	private int backToMenuRectangleHeight = 30;
    
    
	
	
	public ScoreBoardState(StateManager gsm, MouseTrack mouse) {
		super(gsm, mouse);
		configure();
		create();
	}

	@Override
	public void configure() {
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
		
		backToMenuRectangleWidth = 100;
		backToMenuRectangleHeight = 30;
		
		backToMenu = new BarWithText(
				FloatCoordinates.newCoordinates(backToMenuRectangleWidth,backToMenuRectangleHeight),
				FloatCoordinates.newCoordinates(backToMenuRectangleWidth/2, screenHeight - backToMenuRectangleHeight/2),
				"<- VOLTAR",
				Color.GRAY,
				Color.WHITE
				);
		
		
		
		
		rectangleWidth = 500; 
		rectangleHeight  = 50;
		
		selectorRectangleWidth = rectangleWidth - rectangleHeight*2; 
		selectorRectangleHeight  = rectangleHeight;
		
		
		spaceBetweenBars = 70;
		
		difficultyBars = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"difficultyBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleWidth,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2,screenHeight/2 + spaceBetweenBars*3),
								menuDifficultyManager.getDifficultyStringNow(),
								Color.DARK_GRAY,
								menuDifficultyManager.getDifficultyColorNow()
								)
					
						),
				
				BarWithTextCollectionParameters.getParameters(
						"increaseBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2 + selectorRectangleWidth/2 + selectorRectangleHeight/2,screenHeight/2 + spaceBetweenBars*3),
								">",
								Color.GRAY,
								Color.BLACK
								)
						),
				BarWithTextCollectionParameters.getParameters(
						"decreaseBar", 
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight,selectorRectangleHeight ) ,
								FloatCoordinates.newCoordinates(screenWidth/2 - selectorRectangleWidth/2 - selectorRectangleHeight/2 ,screenHeight/2 + spaceBetweenBars*3),
								"<",
								Color.GRAY,
								Color.BLACK
								)
						)
				
				);		
	}

	@Override
	public void handleInput() {
		if( difficultyBars.actorInListedBars(mouse.getMousePosition() , "increaseBar" , "decreaseBar") ||
				GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),backToMenu.getBarRegion())
				) {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
		}else {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
		}
		
		if (mouse.eventMouseLeftClickOnce())
		{
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),difficultyBars.getBar("increaseBar").getBarRegion())){
				menuDifficultyManager.increaseDificultyIndex();
				updateHandles();
			}
			else if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),difficultyBars.getBar("decreaseBar").getBarRegion() )){
				menuDifficultyManager.decreaseDificultyIndex();
				updateHandles();
			}
			else if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),backToMenu.getBarRegion())) {
				 gsm.pop();
				 dispose();
				 gsm.configure();
				 return;
			 }
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
	}

	@Override
	public void update(float dt) {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		mouse.setMousePosition();
		handleInput();
	}
	
	public void updateHandles(){
		difficultyBars.getBar("difficultyBar").setStringText(menuDifficultyManager.getDifficultyStringNow());
		difficultyBars.getBar("difficultyBar").setColor(menuDifficultyManager.getDifficultyColorNow());
	}
	
	
	

	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		difficultyBars.drawBars(sprite,"difficultyBar" , "increaseBar" , "decreaseBar");
		backToMenu.drawBar(sprite);
		
	}

	
	
	
	@Override
	public void dispose() {
		difficultyBars.disposeAll();
		backToMenu.dispose();
	}
	

}
