package com.mygdx.game.states.gameModeState;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.TextCollection;
import com.mygdx.draw.TextDraw;
import com.mygdx.game.states.StateManager;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.gameplayManager.Mode2PlayersManager;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.text.Text;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.RgbaColor;




public class Game2PlayersModeState extends GameModeState {
	
	private TextCollection playersTexts; 


	public Game2PlayersModeState(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		create();
		
	}

	public Game2PlayersModeState(StateManager gsm, MouseTrack mouse, String difficultyStringIdNow) {
		super(gsm , mouse, difficultyStringIdNow);
		create();
	}

	@Override
	public void create() {
		
		gameplayManager = new Mode2PlayersManager();
		field = new ClassicField();	
		super.create();
		
	
		
		
		float textPlayersPosX = screenWidth/ 2  ; 
		float textPlayersPosY = screenHeight - spriteSize/2; 
		
		
		
		
		playersTexts = new TextCollection(
				"player1" ,24, "Player 1:" , 
				new RgbaColor("blue") ,
				new FloatCoordinates(textPlayersPosX , textPlayersPosY),
				
				"player2" ,24, "Player 2:" , 
				new RgbaColor("red") ,
				new FloatCoordinates(textPlayersPosX , textPlayersPosY)
				);
		
		((Mode2PlayersManager) gameplayManager).setRoundManager(playersTexts);
		
	}

	
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
	}
	
	
	@Override 
	public void handleInput() {
		super.handleInput();
		if(leftClickInteraction.inAction()) {
			leftClickInteraction.stopInteraction();
		}
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		
		
	}
	
	@Override
	public void render(SpriteBatch sprite) {	
		sprite.begin();
        
		String playerText = ((Mode2PlayersManager) gameplayManager).getRoundManager().getPlayerStringIdNow();
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
