package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class State implements StateInterface{
	protected OrthographicCamera cam;
	protected GameStateManager gsm;
	
	protected State(GameStateManager gsm) {
		this.gsm = gsm;
		cam = new OrthographicCamera();
		}
	
	@Override
	public abstract void create();
	@Override
	public abstract void handleInput();
	
	public abstract void resize(int width, int height);
	
	@Override
	public abstract void update(float dt);
	
	@Override
	public abstract void render(SpriteBatch sb);
	
	@Override
	public abstract void dispose();
}
	
	
