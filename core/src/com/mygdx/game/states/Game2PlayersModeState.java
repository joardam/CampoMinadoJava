package com.mygdx.game.states;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.draw.TextDraw;
import com.mygdx.gameField.GameField;
import com.mygdx.gameField.texts.Text;
import com.mygdx.gameField.texts.TextCollection;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Players;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.Utils;

public class Game2PlayersModeState extends GameModeState {
	
	
	private Players players ;
	
	private TextCollection playersTexts; 


	public Game2PlayersModeState(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		create();
		
	}

	@Override
	public void create() {
		field = new GameField();
		
		
		super.create();
		
		players = new Players("player1" , "player2");
		
		int screenWidth = Gdx.graphics.getWidth(); 
		int screenHeight = Gdx.graphics.getHeight(); 
		
		
		
		float textPlayersPosX = screenWidth/ 2 - 53; 
		float textPlayersPosY = screenHeight - 5; 
		
		
		
		
		playersTexts = new TextCollection(
				"player1" , "Player 1:" , 24,
				new RgbaColor("blue") ,
				new FloatCoordinates(textPlayersPosX , textPlayersPosY),
				
				"player2" , "Player 2:" , 24,
				new RgbaColor("red") ,
				new FloatCoordinates(textPlayersPosX , textPlayersPosY)
				);
	}

	
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
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
		super.update(dt);
		
		
	}
	
	@Override
	public void render(SpriteBatch sprite) {	
		sprite.begin();
        int playerIdInRound = gameplayManager.getRounds().getPlayerIdInRound();
        
        String playerText = players.getPlayerStringTextByIndex(playerIdInRound);
        
        Text playerTextToDraw = playersTexts.getText(playerText);
        
        TextDraw.draw(sprite, playerTextToDraw);
        sprite.end();
        
        super.render(sprite);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		playersTexts.disposeAll();
		
		
	}
	
	


	
	
	
	


	

	
	
}
