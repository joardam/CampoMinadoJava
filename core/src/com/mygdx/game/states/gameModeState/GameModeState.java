package com.mygdx.game.states.gameModeState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.collections.TextCollection;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.draw.TextDraw;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.menuState.MenuState;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.InteractionManager;

public abstract class GameModeState extends State{
	
	
	protected int difficulty;
	protected int rows;
	protected int cols;
	protected Field field;
	protected FieldDraw draw;
	protected GameplayManager gameplayManager;
	protected TextCollection booleanEndStatus;
	protected int bombsQuantity;
	protected BarWithText backToMenu;
	protected float screenWidth;
	protected float screenHeight;
	protected int backToMenuRectangleWidth = 100;
	protected int backToMenuRectangleHeight = 30;
	protected InteractionManager leftClickInteraction = new InteractionManager();
	protected InteractionManager renderInteraction = new InteractionManager();
	protected ShapeRenderer  shape = new ShapeRenderer();
	
	
	protected int spriteSize = 32;
	protected Texture texture = new Texture("newsprites.jpg");
	
	
	
	
	protected GameModeState(StateManager gsm, MouseTrack mouse) {
		super(gsm, mouse);
		
		
	}
	
	protected GameModeState(StateManager gsm, MouseTrack mouse , int difficulty) {
		super(gsm, mouse);
		
		if(difficulty == 0 ){
			rows = 10;
			cols = 10;
			
			bombsQuantity = 10;
		}
		else if(difficulty == 1){
			rows = 15;
			cols = 16;
			
			bombsQuantity = 40;
			
		}
		else if(difficulty == 2){
			rows = 16;
			cols = 30;
			
			bombsQuantity = 99;			
		}
		
		this.difficulty = difficulty;
		
		configure();
		
		
	}
	
	public void configure() {
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize((cols + 2) * spriteSize,
				(rows + 2) * spriteSize);

		videoConfig.setFixElements();
		
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Campo Minado");
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
	}
	
	@Override
	public void create() {
		draw  = new FieldDraw(field,spriteSize);
		
		
		renderInteraction.startInteraction();
		
		
		backToMenuRectangleWidth = 100;
		backToMenuRectangleHeight = 30;
		
		
		backToMenu = new BarWithText(
				FloatCoordinates.newCoordinates(backToMenuRectangleWidth,backToMenuRectangleHeight),
				FloatCoordinates.newCoordinates(backToMenuRectangleWidth/2, screenHeight - backToMenuRectangleHeight/2),
				"<- VOLTAR",
				Color.GRAY,
				Color.WHITE
				);
		
		field.fillCells(cols,rows);
		field.setBombsQuantity(bombsQuantity);
		field.placeBombs();
		field.placeNearCellInEachCell();
		field.placeCountersInSafeCells();
		
		
		
		
		int screenWidth = Gdx.graphics.getWidth(); 
		
		
		float booleanEndStatusPosition = screenWidth/ 2; 
	
		
		
		booleanEndStatus = new TextCollection(
				"loose", 32,"Perdeu",
				new RgbaColor("red") ,
				new FloatCoordinates(booleanEndStatusPosition , spriteSize/2),
				
				"win", 32 ,"Ganhou" ,
				new RgbaColor("green") ,
				new FloatCoordinates(booleanEndStatusPosition , spriteSize/2)
				);	
	}


	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
		
	}
	
	
	@Override
	public void handleInput() {
		 int mouseFieldX = (int) mouse.getMouseX() / spriteSize - 1 ;
		 int mouseFieldY = (int) mouse.getMouseY() / spriteSize - 1 ;
		
		 if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),backToMenu.getBarRegion())) {
			 Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
		 }
		 else 
		 {
			 Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
		 }
		 
		 
		if(mouse.eventMouseLeftClickOnce()) {
			leftClickInteraction.startInteraction();
			
		}
		
		if(leftClickInteraction.inAction()) {
			
			 if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),backToMenu.getBarRegion())) {
				 renderInteraction.stopInteraction();
				 
				 gsm.pop();
				 dispose();
				 gsm.configure();
				 leftClickInteraction.stopInteraction();
			 }
			       
			
			if(GameUtils.isIn2DArrayBound(mouseFieldX ,mouseFieldY, cols,rows)) {
				if(!gameplayManager.getGameOverStatus()) {
					gameplayManager.tryToUncoverThisCell(mouseFieldX , mouseFieldY, field);
					leftClickInteraction.stopInteraction();
				}
				
			}
			
	       	
	 
       	
       }
       
       if(mouse.eventMouseRightClickOnce()) {
    	   if(!GameUtils.isIn2DArrayBound(mouseFieldX ,mouseFieldY, cols,rows)) {
				return;
			}
    	   
    	  
       	gameplayManager.tryToToggleFlagThisCell(mouseFieldX,mouseFieldY, field);
       }
       
       
	}

	@Override
	public void update(float dt) {
		mouse.setMousePosition();
		handleInput();
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
	}

	@Override
	public void render(SpriteBatch sprite) {
		
		
		
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		if(!renderInteraction.inAction()) {
			return;
			
		}
		
		
		backToMenu.drawBar(sprite);
		sprite.begin();
        draw.drawField(sprite, texture);
       
        
        gameplayManager.getGameStatus().interactWinStatus(this, sprite);
        gameplayManager.getGameStatus().interactLossStatus(this, sprite);
        
        sprite.end();
        
		
	}

	@Override
	public void dispose() {
		texture.dispose();
		backToMenu.dispose();
		booleanEndStatus.disposeAll();
		
	}

	//inside
	
	public void drawLossCase(SpriteBatch sprite) {
		TextDraw.draw(sprite, booleanEndStatus.getText("loose"));
	}
	
	public void drawWinCase(SpriteBatch sprite) {
		TextDraw.draw(sprite, booleanEndStatus.getText("win"));
	}


	
	
	
}
