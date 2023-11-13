package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gameField.*;
import com.mygdx.gameField.ClassicManager;
import com.mygdx.mouseTrack.MouseTrack;

public class GameCrazyModeState extends GameModeState{

	
	
	public GameCrazyModeState(StateManager gsm, MouseTrack mouse) {
		super(gsm, mouse);
		create();
	}
	
	@Override
	public void create() {
		gameplayManager = new CrazyManager();
		field = new CrazyField();
		
		super.create();
		
		((CrazyField) field).placeCrazyness();
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
	

