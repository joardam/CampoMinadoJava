package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mouseTrack.MouseTrack;


public abstract class State implements StateInterface{
	protected OrthographicCamera cam;
	protected GameStateManager gsm;
	protected MouseTrack mouse = new MouseTrack();
	
	protected State(GameStateManager gsm) {
		this.gsm = gsm;
		}
	protected State(GameStateManager gsm , MouseTrack mouse) {
		this.gsm = gsm;
		this.mouse = mouse ;
	}
	
	
	@Override
	public abstract void handleInput();
	@Override
	public abstract void resize(int width, int height);
	@Override
	public abstract void update(float dt);
	@Override
	public abstract void render(SpriteBatch sb);
	@Override
	public abstract void dispose();
}
	
	
