package com.mygdx.gameField.texts;


import java.util.HashMap;



public class Texts {
	
	private HashMap<String, Text> textMap = new HashMap<String, Text>();
	
	public Texts() {
		
	}
	
	public Texts(Object... args) {
        if (args.length % 3 != 0) {
            throw new IllegalArgumentException("(Not enough parameters per key) Each parameter should consist of a String, another String, and an int.");
        }

        for (int i = 0; i < args.length; i += 3) {
            if (!(args[i] instanceof String) || !(args[i + 1] instanceof String) || !(args[i + 2] instanceof Integer)) {
                throw new IllegalArgumentException("(Wrong type) Each parameter should consist of a String, another String, and an int.");
            }

            String stringId = (String) args[i];
            String textString = (String) args[i + 1];
            int size = (int) args[i + 2];
            addText(stringId, textString, size);
        }
    }
	
	public void addText(String stringId , int size) {
		Text text = new Text();
		text.setSize(size);
		text.initialize();
		textMap.put(stringId, text);
		
	}
	
	public void addText(String stringId ,String textString , int size ) {
		Text text = new Text();
		text.setSize(size);
		text.initialize();
		text.setTextString(textString);
		textMap.put(stringId, text);
	}
	
	
	public Text getText(String stringId) {
		return this.textMap.get(stringId);
	}
	
	
	public HashMap<String, Text> getHashMap(){
		return this.textMap;
	}
	
	public void setColors(Object... args) {
	    if (args.length % 5 != 0) {
	        throw new IllegalArgumentException("(Not enough parameters per key) Each group of parameters should consist of a String and four float values.");
	    }

	    for (int i = 0; i < args.length; i += 5) {
	        if (!(args[i] instanceof String) ||
	            !(args[i + 1] instanceof Float) ||
	            !(args[i + 2] instanceof Float) ||
	            !(args[i + 3] instanceof Float) ||
	            !(args[i + 4] instanceof Float)) {
	            throw new IllegalArgumentException("(Wrong type) Each group of parameters should consist of a String and four float values.");
	        }

	        String stringId = (String) args[i];
	        float x1 = (float) args[i + 1];
	        float x2 = (float) args[i + 2];
	        float x3 = (float) args[i + 3];
	        float x4 = (float) args[i + 4];
	        textMap.get(stringId).setColor(x1, x2, x3, x4);
	    }
	}
	
	public void setTextPositions(Object... args) {
	    if (args.length % 3 != 0) {
	        throw new IllegalArgumentException("(Not enough parameters per key). Each group of parameters should consist of a String, a float for x, and a float for y.");
	    }

	    for (int i = 0; i < args.length; i += 3) {
	        if (!(args[i] instanceof String) ||
	            !(args[i + 1] instanceof Float) ||
	            !(args[i + 2] instanceof Float)) {
	            throw new IllegalArgumentException("(Wrong type). Each group of parameters should consist of a String, a float for x, and a float for y.");
	        }

	        String stringId = (String) args[i];
	        float x = (float) args[i + 1];
	        float y = (float) args[i + 2];
	        textMap.get(stringId).setTextPosition(x, y);
	    }
	}

	
	
	
	
	
	public void disposeAll() {
		for (Text text : textMap.values()) {
	        text.dispose();
	    }
		
	}
	

	

	    
	}
	
