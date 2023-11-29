package com.mygdx.config;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteConfig {
	public static void setProjectionMatrix(SpriteBatch sprite, VideoSettings videoConfig) {

		OrthographicCamera camera = videoConfig.getCamera();
		sprite.setProjectionMatrix(camera.combined);
	}
}
