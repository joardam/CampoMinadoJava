package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.GameplayManager;
import com.mygdx.gameField.texts.TextCollection;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.Utils;

public abstract class GameModeState extends State{
	
	protected int rows;
	protected int cols;
	protected Field field;
	protected FieldDraw draw;
	protected VideoSettings videoConfig = new VideoSettings();
	protected GameplayManager gameplayManager;
	protected TextCollection booleanEndStatus;
	protected int bombsQuantity;
	
	protected int spriteSize = 32;
	protected Texture texture = new Texture("newsprites.jpg");
	
	
	protected GameModeState(StateManager gsm, MouseTrack mouse) {
		super(gsm, mouse);
	}
	
	protected GameModeState(StateManager gsm, MouseTrack mouse , String difficulty) {
		super(gsm, mouse);
		
		if(difficulty.equals("eazy")){
			rows = 10;
			cols = 10;
			
			bombsQuantity = 10;
		}
		else if(difficulty.equals("medium")){
			rows = 15;
			cols = 16;
			
			bombsQuantity = 40;
			
		}
		else if(difficulty.equals("hard")){
			rows = 16;
			cols = 30;
			
			bombsQuantity = 99;			
		}
		
		
	}
	

	
	@Override
	public void create() {
		draw  = new FieldDraw(field,spriteSize);
		videoConfig.setCamera(cam);
		
		
		videoConfig.SetVideoSize((cols + 2) * spriteSize,
				(rows + 2) * spriteSize);

		videoConfig.setFixElements();
		
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Campo Minado");
		
		
		
		field.fillCells(cols,rows);
		field.setBombsQuantity(bombsQuantity);
		field.placeBombs();
		field.placeCountersInSafeCells();
		
		
		
		int screenWidth = Gdx.graphics.getWidth(); 
		
		
		float booleanEndStatusPosition = screenWidth/ 2 - 53; 
	
		
		
		booleanEndStatus = new TextCollection(
				"loose", "Perdeu",32,
				new RgbaColor("red") ,
				new FloatCoordinates(booleanEndStatusPosition , 30f),
				
				"win", "Ganhou" , 32,
				new RgbaColor("green") ,
				new FloatCoordinates(booleanEndStatusPosition , 30f)
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
		 
		if(mouse.eventMouseLeftClickOnce()&&
				Utils.isIn2DArrayBound(mouseFieldX ,mouseFieldY, rows, cols)) {
			
       	gameplayManager.tryToUncoverThisCell(mouseFieldX , mouseFieldY, field);
       	
       }
       
       if(mouse.eventMouseRightClickOnce()) {
       	gameplayManager.tryToToggleFlagThisCell(mouseFieldX,mouseFieldY, field);
       }
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
		
		sprite.begin();
        draw.drawField(sprite, texture);
       
        
        if(gameplayManager.getGameOverStatus()) {
        	TextDraw.draw(sprite, booleanEndStatus.getText("loose"));
		}
        else if (gameplayManager.isWinStatus()) {
        	TextDraw.draw(sprite, booleanEndStatus.getText("win"));
        }
        
        sprite.end();
		
	}

	@Override
	public void dispose() {
		texture.dispose();
		booleanEndStatus.disposeAll();
		
	}
	
	
	
}
