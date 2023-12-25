package com.mygdx.collections.BarWithTextCollection;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.BarWithText;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.Region2d;

public class BarWithTextCollection {
	private HashMap<String, BarWithText> barMap = new HashMap<String, BarWithText>();
	ArrayList<String> barArray = new ArrayList<String>();
	
	public BarWithTextCollection(BarWithTextCollectionParameters... args) {
		for(int i = 0; i < args.length ; i++) {
			barMap.put(args[i].getStringId(),args[i].getBarWithText());
			barArray.add(args[i].getStringId()) ;
		}
	}
	
	
	public void addBar(BarWithTextCollectionParameters...args) {
		for(int i = 0; i < args.length ; i++) {
			barMap.put(args[i].getStringId(),args[i].getBarWithText());
			barArray.add(args[i].getStringId()) ;
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
	
	
	public void disposeAll() {
		for(BarWithText bar : barMap.values()) {
			bar.getText().dispose();
		}	
		
	}
	
	public boolean actorInAnyBar(FloatCoordinates actorPosition) {
		for(BarWithText bar : barMap.values()) {
			Region2d barRegion = bar.getBarRegion();
			if (GameUtils.isIn2DSpaceBound(actorPosition,barRegion)){
				return true;
			}
		}
		return false;
	}
	
	public boolean actorInListedBars(FloatCoordinates actorPosition , String... stringIds) {
		for(int i = 0 ; i < stringIds.length ; i++) {
			BarWithText bar = barMap.get(stringIds[i]);
			Region2d barRegion = bar.getBarRegion();
			
			if (GameUtils.isIn2DSpaceBound(actorPosition,barRegion)){
				return true;
			}
		}
		return false;
		
	}
	

	
	
}