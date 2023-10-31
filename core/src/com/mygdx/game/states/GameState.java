package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.GameplayManager;
import com.mygdx.gameField.GameField;
import com.mygdx.gameField.texts.Texts;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Players;

public class GameState extends State {
	
	private int rows = 12;
	private int cols = 18;
	private GameField field = new GameField(rows,cols);
	private int spriteSize = 32;
	private MouseTrack mouse = new MouseTrack(spriteSize,rows,cols);
	private Texture texture = new Texture("newsprites.jpg");
	private FieldDraw draw =  new FieldDraw(field,spriteSize);
	private VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	private GameplayManager gameplayManager = new GameplayManager();
	
	
	private Players players = new Players();
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
		
	    players.addPlayer("player1");
	    players.addPlayer("player2");
	    players.addPlayer("player3");
	    
	    
	    playersTexts.addText("player1" , "Player 1:" , 24);
	    playersTexts.getText("player1").setColor(0, 0, 1, 1);
	    playersTexts.getText("player1").setTextPosition(175, 635);

	    playersTexts.addText("player2" , "Player 2: " , 24);
	    playersTexts.getText("player2").setColor(1, 0, 0, 1); 
	    playersTexts.getText("player2").setTextPosition(175, 635);
	    
	    playersTexts.addText("player3" , "Player 3: " , 24);
	    playersTexts.getText("player3").setColor(1, 1, 0, 1); 
	    playersTexts.getText("player3").setTextPosition(175, 635);
	    
	    
	    
	    
	}
	
	
	@Override
	public void resize(int width, int height) {
		videoConfig.resizeScreen(width, height);
		
	}
	
	
	@Override 
	public void handleInput() {
		if(mouse.eventMouseLeftClickOnce()) {
        	gameplayManager.tryToUncoverThisCell(mouse, field ,players);
        	
        }
        
        if(mouse.eventMouseRightClickOnce()) {
        	gameplayManager.tryToToggleFlagThisCell(mouse, field);
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
        
        TextDraw.draw(sprite, playersTexts.getText(
        		players.getPlayerStringTextByIndex(
        				gameplayManager.getRounds().getPlayerIdInRound())));
        
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
