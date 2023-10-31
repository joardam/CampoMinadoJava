package com.mygdx.gameField.texts;


import java.util.HashMap;



public class Texts {
	
	private HashMap<String, Text> textMap = new HashMap<String, Text>();
	
	public Texts() {
		
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
	
	
	
	public void disposeAll() {
		for (Text text : textMap.values()) {
	        text.dispose();
	    }
		
	}
	

	
	    
	    
	    
	}
	
