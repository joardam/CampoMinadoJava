package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.FieldCellsInteractionManager;
import com.mygdx.gameField.GameField;
import com.mygdx.gameField.texts.Texts;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Player;

public class GameState extends State {
	
	private int rows = 12;
	private int cols = 18;
	private GameField field = new GameField(rows,cols);
	private int spriteSize = 32;
	private MouseTrack mouse = new MouseTrack(spriteSize,rows,cols);
	private Texture texture = new Texture("newsprites.jpg");
	private FieldDraw draw =  new FieldDraw(field,spriteSize);
	private VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	
	
	private Player player1 = new Player(1);
	private Player player2 = new Player(2);
	
	private Texts playersTexts = new Texts();
	
	
	
	
	public GameState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void create() {
		videoConfig.setFixElements();
		
		videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
		
		field.fillCells();
	    field.placeBombs();
	    field.placeCountersInSafeCells();
		
	    playersTexts.addText("player1" , "Player 1:");
	    playersTexts.getText("player1").setSize(24);
	    playersTexts.getText("player1").setColor(1,1,1,1);
	    playersTexts.getText("player1").setTextPosition(130, 635);
	    
	}
	
	
	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
		
	}
	
	
	@Override 
	public void handleInput() {
		if(mouse.eventMouseLeftClickOnce()) {
        	FieldCellsInteractionManager.tryToUncoverThisCell(mouse, field);
        }
        
        if(mouse.eventMouseRightClickOnce()) {
        	FieldCellsInteractionManager.tryToToggleFlagThisCell(mouse, field);
        }
	}
	
	@Override
	public void update(float dt) {
		mouse.setMousePosition();
		handleInput();
		
	}
	
	@Override
	public void render(SpriteBatch sprite) {
		sprite.begin();
        draw.drawField(sprite, texture);
        
        TextDraw.draw(sprite, playersTexts.getText("player1"));
        
        sprite.end();
	}
	
	@Override
	public void dispose() {
		texture.dispose();
		playersTexts.disposeAll();
	}
	
	
	public void setProjectionMatrix(SpriteBatch sprite) {
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
	}


	

	
	
}
