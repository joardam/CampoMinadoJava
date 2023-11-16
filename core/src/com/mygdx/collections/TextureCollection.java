package com.mygdx.collections;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureCollection {
	private HashMap<String , Texture> textureMap = new HashMap<String,Texture>();
	
	public TextureCollection() {
		
	}
	
	 public TextureCollection(String... args) {
	        if (args.length % 2 != 0) {
	            throw new IllegalArgumentException("Collection must have pair arguments (pairs key-value).");
	        }

	        for (int i = 0; i < args.length; i += 2) {
	            String stringId = args[i];
	            String texturePath = args[i + 1];
	            addTexture(stringId, texturePath);
	        }
	    }
	
	public void addTexture(String stringId, String texturePath) {
		Texture texture = new Texture(texturePath);
		textureMap.put(stringId, texture);
	}
		
	public Texture getTexture(String texturePath) {
		return this.textureMap.get(texturePath);
	}
	
}
