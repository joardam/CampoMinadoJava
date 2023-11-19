package com.mygdx.collections.BarWithTextCollection;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.BarWithText;

public class BarWithTextCollection {
	private HashMap<String, BarWithText> barMap = new HashMap<String, BarWithText>();
	
	
	public BarWithTextCollection(BarWithTextCollectionParameters... args) {
		for(int i = 0; i < args.length ; i++) {
			barMap.put(args[i].getStringId(),args[i].getBarWithText());
			
		}
	}
	
	
	public void drawBars(SpriteBatch sprite, String... args) {
		try {
			for(int i = 0; i < args.length ; i++) {
				getBar(args[i]).drawBar(sprite);
			}
		}
		catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
		
		}

		
	}
	
	public BarWithText getBar(String stringId) {
		try {
			if (barMap.get(stringId) == null) {
                throw new IllegalArgumentException("stringId not found: " + stringId);
            }
			return barMap.get(stringId);
			
		} catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null; 
		
		
		
		
		}
	}
}