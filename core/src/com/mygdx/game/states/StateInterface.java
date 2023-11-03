package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface StateInterface {
	void handleInput();
	void update(float dt);
	void render(SpriteBatch sb);
	void dispose();
	void resize(int width, int height);
}
