package com.mygdx.game.states;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings;
import com.mygdx.draw.FieldDraw;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.GameplayManager;
import com.mygdx.gameField.GameField;
import com.mygdx.gameField.texts.Text;
import com.mygdx.gameField.texts.Texts;
import com.mygdx.mouseTrack.FieldMouseTrack;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Players;

public class GameState extends State {
	
	private int rows = 18;
	private int cols = 24;
	private GameField field = new GameField();
	private int spriteSize = 32;
	private FieldMouseTrack mouse = new FieldMouseTrack(spriteSize,cols,rows);
	private Texture texture = new Texture("newsprites.jpg");
	private FieldDraw draw =  new FieldDraw(field,spriteSize);
	private VideoSettings videoConfig = new VideoSettings();
	private GameplayManager gameplayManager = new GameplayManager();
	private Players players = new Players();
	private Texts playersTexts = new Texts();
	private Texts winOrLooseStatusText = new Texts();
	
	
	public GameState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void create() {
		videoConfig.SetVideoSize((cols + 2) * spriteSize,
									(rows + 2) * spriteSize);
		
		videoConfig.setFixElements();
		
		videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
		
		field.fillCells(cols,rows);
	    field.placeBombs();
	    field.placeCountersInSafeCells();
		
	    players.addPlayer("player1");
	    players.addPlayer("player2");
	    
	    int screenWidth = Gdx.graphics.getWidth(); 
		int screenHeight = Gdx.graphics.getHeight(); 
	    
	    int textPlayersPosX = screenWidth/ 2 - 53; 
		int textPlayersPosY = screenHeight - 5; 
	    
	    playersTexts.addText("player1" , "Player 1:" , 24);
	    playersTexts.getText("player1").setColor(0, 0, 1, 1);
	    playersTexts.getText("player1").setTextPosition(textPlayersPosX, textPlayersPosY);

	    playersTexts.addText("player2" , "Player 2: " , 24);
	    playersTexts.getText("player2").setColor(1, 0, 0, 1); 
	    playersTexts.getText("player2").setTextPosition(textPlayersPosX,textPlayersPosY);
	    
	    winOrLooseStatusText.addText("loose" ,"Perdeu" , 33);
	    winOrLooseStatusText.getText("loose").setColor(1, 0, 0, 1);
	    winOrLooseStatusText.getText("loose").setTextPosition(textPlayersPosX,30);
	    
	    winOrLooseStatusText.addText("win" , "Ganhou" , 33);
	    winOrLooseStatusText.getText("win").setColor(0, 1, 0, 1);
	    winOrLooseStatusText.getText("win").setTextPosition(textPlayersPosX,30);
	    
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
		mouse.setMousePositionInField();
		handleInput();
		
		
	}
	
	@Override
	public void render(SpriteBatch sprite) {
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		
		sprite.begin();
        draw.drawField(sprite, texture);
        
        int playerIdInRound = gameplayManager.getRounds().getPlayerIdInRound();
        String playerText = players.getPlayerStringTextByIndex(playerIdInRound);
        Text playerTextToDraw = playersTexts.getText(playerText);
        TextDraw.draw(sprite, playerTextToDraw);
        
        if(gameplayManager.getGameOverStatus()) {
        	TextDraw.draw(sprite, winOrLooseStatusText.getText("loose"));
		}
        else if (gameplayManager.isWinStatus()) {
        	TextDraw.draw(sprite, winOrLooseStatusText.getText("win"));
        }
        
        sprite.end();
	}
	
	@Override
	public void dispose() {
		texture.dispose();
		playersTexts.disposeAll();
		winOrLooseStatusText.disposeAll();
		
	}
	
	
	


	

	
	
}
