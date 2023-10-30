package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class State {
	protected OrthographicCamera cam;
	protected GameStateManager gsm;
	
	protected State(GameStateManager gsm) {
		this.gsm = gsm;
		cam = new OrthographicCamera();
		}
	
	public abstract void create();
	protected abstract void handleInput();
	public abstract void resize(int width, int height);
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();
	public abstract void setProjectionMatrix(SpriteBatch sprite);
	}
