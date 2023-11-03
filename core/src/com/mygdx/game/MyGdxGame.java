package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameState;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;



public class MyGdxGame extends ApplicationAdapter {
	
	private GameStateManager gsm;
	private SpriteBatch sprite;
	
	
	@Override
	public void create () {
		sprite = new SpriteBatch();
		gsm = new GameStateManager();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		gsm.push(new MenuState(gsm));
		
	}
	
	
	
	@Override
	public void resize(int width, int height) {
		gsm.resize(width, height);
    }
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sprite);
	}
	
	@Override
	public void dispose () {
		gsm.dispose();
		sprite.dispose();
	}
}
