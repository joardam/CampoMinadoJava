package com.mygdx.game.states.gameModeState;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.StateManager;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.gameplayManager.ClassicManager;
import com.mygdx.mouseTrack.MouseTrack;


public class GameClassicModeState extends GameModeState {
	
	
	public GameClassicModeState(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		create();

	}
		
		
	public GameClassicModeState(StateManager gsm, MouseTrack mouse, String difficultyStringIdNow) {
		super(gsm , mouse, difficultyStringIdNow);
		create();
	}


	@Override
	public void create() {
		gameplayManager = new ClassicManager();
		field = new ClassicField();
		
		super.create();
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
		super.render(sprite);
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}




	
	
}
