package com.mygdx.collections;

import java.util.HashMap;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.RgbaColor;

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
	
	
	public ShapeCollection(Object... args) throws CollectionException {
        try {
            if (args.length % 2 != 0) {
                throw new IllegalArgumentException("Parameters pattern must be (String, RgbaColor)");
            }

         

            for (int i = 0; i < args.length; i += 2) {
                if (!(args[i] instanceof String) || !(args[i + 1] instanceof RgbaColor)) {
                	throw new CollectionException("Parameters types must be (String, RgbaColor)");
                
                }
                String stringId = (String) args[i];
                RgbaColor color = (RgbaColor) args[i + 1];
                
                addShape(stringId);
                ShapeRenderer shape = shapeMap.get(stringId);
                shape.setColor(color.getColor()[0],color.getColor()[1],color.getColor()[2],color.getColor()[3]);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
	
	
	public void shapesBegin(String ... args) {
		 for (int i = 0; i < args.length; i ++) {
			 shapeMap.get(args[i]).begin(ShapeType.Filled);
		 }
	}
	
	public void shapesEnd(String ... args) {
		try {
			for (int i = 0; i < args.length; i ++) {
				 shapeMap.get(args[i]).end();
			 }
		} catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } 
		
		
	}
	
	public void setRect(Object ... args) throws CollectionException {
		try {
			 if (args.length % 3 != 0) {
	                throw new CollectionException("Parameters pattern must be (String, FloatCoordinates , FloatCoordinates)");
	            }
			 
			 for (int i = 0; i < args.length; i += 3) {
	                if (!(args[i] instanceof String) || !(args[i + 1] instanceof FloatCoordinates ) || !(args[i + 2] instanceof FloatCoordinates)) {
	                	throw new IllegalArgumentException("Parameters types must be (String, FloatCoordinates , FloatCoordinates)");
	                }
	                ShapeRenderer shape = (ShapeRenderer)shapeMap.get(args[i]);
	                float posX = ((FloatCoordinates)args[i + 1]).getCoordinateX();
	                float posY = ((FloatCoordinates)args[i + 1]).getCoordinateY();
	                
	                float rectangleWidth = ((FloatCoordinates)args[i + 2]).getCoordinateX();
	                float rectangleHeight = ((FloatCoordinates)args[i + 2]).getCoordinateY();
	                
	                shape.rect(posX,posY,rectangleWidth,rectangleHeight);
			 }
			
			
			
		} catch (CollectionException e) {
            System.err.println("Error: " + e.getMessage());
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
	
	public ShapeRenderer getShape(String stringId) {
		return shapeMap.get(stringId);
	}
	
	public void disposeAll() {
		for(ShapeRenderer shape : shapeMap.values()) {
			shape.dispose();
		}
	}
	
}
	