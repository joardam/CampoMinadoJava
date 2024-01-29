package com.mygdx.game.states.gameModeState;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.CollectionException;
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

	public Game2PlayersModeState(StateManager gsm, MouseTrack mouse, int difficulty) {
		super(gsm , mouse, difficulty);
		create();
	}

	@Override
	public void create() {
		
		gameplayManager = new Mode2PlayersManager();
		field = new ClassicField();	
		super.create();
		
	
		
		
		float textPlayersPosX = screenWidth/ 2  ; 
		float textPlayersPosY = screenHeight - spriteSize/2; 
		
		
		
		
		try {
			playersTexts = new TextCollection(
					"player1" ,24, "Player 1:" , 
					new RgbaColor("blue") ,
					new FloatCoordinates(textPlayersPosX , textPlayersPosY),
					
					"player2" ,24, "Player 2:" , 
					new RgbaColor("red") ,
					new FloatCoordinates(textPlayersPosX , textPlayersPosY)
					);
		} catch (CollectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Mode2PlayersManager) gameplayManager).setRoundManager(playersTexts);
		
	}

	
	
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
	}
	
	
	@Override 
	public void handleInput() {
		super.handleInput();
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		
		
	}
	
	@Override
	public void render(SpriteBatch sprite) {	
		sprite.begin();
        
		String playerText = ((Mode2PlayersManager) gameplayManager).getRoundManager().getPlayerStringIdNow();
        Text playerTextToDraw = null;
		try {
			playerTextToDraw = playersTexts.getText(playerText);
		} catch (CollectionException e) {
			e.printStackTrace();
		}
        
        TextDraw.draw(sprite, playerTextToDraw);
        sprite.end();
        
        super.render(sprite);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		playersTexts.disposeAll();
		
		
	}
	
	


	//inside
	
	@Override
	public void leftClickInteraction(int mouseFieldX, int mouseFieldY) {
		super.leftClickInteraction(mouseFieldX, mouseFieldY);
		
	}

	
	
	


	

	
	
}
