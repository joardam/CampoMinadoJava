package com.mygdx.shapes;

import java.util.HashMap;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShapeCollection {
	private HashMap<String, ShapeRenderer> shapeMap = new HashMap<String , ShapeRenderer>();
	
	public ShapeCollection() {
		
	}
	
	public ShapeCollection(String... args) {
		 for (int i = 0; i < args.length; i++) {

	            String stringId = (String) args[i];
	            addShape(stringId);
	        }
	}
	
	public void addShape(String stringId) {
		ShapeRenderer shape = new ShapeRenderer();
		shapeMap.put(stringId ,shape);
	}
	
	public void adShape(String... args) {
		 for (int i = 0; i < args.length; i++) {

	            String stringId = (String) args[i];
	            addShape(stringId);
	        }
	}
	
	public void getShape(String stringId) {
		shapeMap.get(stringId);
	}
	
}
	