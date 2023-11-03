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
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Players;
import com.mygdx.utils.Utils;

public class GameState extends State {
	
	private int rows = 15;
	private int cols = 15;
	private GameField field = new GameField();
	private int spriteSize = 32;
	private Texture texture = new Texture("newsprites.jpg");
	private FieldDraw draw =  new FieldDraw(field,spriteSize);
	private VideoSettings videoConfig = new VideoSettings();
	private GameplayManager gameplayManager = new GameplayManager();
	private Players players = new Players("player1" , "player2");
	
	private Texts playersTexts = new Texts(
			"player1" , "Player 1:" , 24,
			"player2" , "Player 2:" , 24);
	
	private Texts booleanEndStatus = new Texts(
			"loose", "Perdeu",32,
			"win", "Ganhou" , 32);
	
	
	public GameState(GameStateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		
		
		
		
		
		videoConfig.setCamera(cam);
		
		videoConfig.SetVideoSize((cols + 2) * spriteSize,
				(rows + 2) * spriteSize);

		videoConfig.setFixElements();
		
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Campo Minado");
		
		field.fillCells(cols,rows);
		field.placeBombs();
		field.placeCountersInSafeCells();
		
		
		
		int screenWidth = Gdx.graphics.getWidth(); 
		int screenHeight = Gdx.graphics.getHeight(); 
		
		float textPlayersPosX = screenWidth/ 2 - 53; 
		float textPlayersPosY = screenHeight - 5; 
		
		playersTexts.setColors(
		"player1", 0f,0f,1f,1f,
		"player2", 1f,0f,0f,1f);
		
		
		booleanEndStatus.setColors(
		"loose", 1f,0f,0f,1f,
		"win", 0f,1f,0f,1f);
		
		
		playersTexts.setTextPositions(
		"player1" , textPlayersPosX , textPlayersPosY,
		"player2" , textPlayersPosX , textPlayersPosY);
		
		
		booleanEndStatus.setTextPositions(
		"loose" , textPlayersPosX ,  30f,
		"win"   , textPlayersPosX ,  30f);

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
			
        	gameplayManager.tryToUncoverThisCell(mouseFieldX , mouseFieldY, field ,players);
        	
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
        
        int playerIdInRound = gameplayManager.getRounds().getPlayerIdInRound();
        
        String playerText = players.getPlayerStringTextByIndex(playerIdInRound);
        
        Text playerTextToDraw = playersTexts.getText(playerText);
        
        TextDraw.draw(sprite, playerTextToDraw);
        
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
		playersTexts.disposeAll();
		booleanEndStatus.disposeAll();
		
	}


	
	
	
	


	

	
	
}
