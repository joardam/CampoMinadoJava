package com.mygdx.game.states.gameModeState;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.StateManager;
import com.mygdx.mouseTrack.MouseTrack;

public class GameEndlessMode extends GameModeState {
	
	public GameEndlessMode(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		create();

	}
	public GameEndlessMode(StateManager gsm, MouseTrack mouse, String difficultyStringIdNow) {
		super(gsm, mouse, difficultyStringIdNow);
		create();
	}
	
	
	@Override
	public void create() {
		super.create();
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
		super.render(sprite);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	

}
