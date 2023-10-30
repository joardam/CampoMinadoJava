package com.mygdx.gameField.texts;


import java.util.HashMap;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mygdx.utils.Coordinates;

public class Texts {
	
	private HashMap<String, Text> textMap = new HashMap<String, Text>();
	
	public Texts() {
		
	}
	
	public void addText(String stringId) {
		Text text = new Text();
		text.initialize();
		textMap.put(stringId, text);
		
	}
	
	public void addText(String stringId ,String textString  ) {
		Text text = new Text();
		text.initialize();
		text.setTextString(textString);
		textMap.put(stringId, text);
	}
	
	
	public Text getText(String stringId) {
		return this.textMap.get(stringId);
	}

	
	public void disposeAll() {
		for (Text text : textMap.values()) {
	        text.dispose();
	    }
		
	}
	

	
	
	public class Text{
		private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
	    private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	    private BitmapFont font;
	    private String textString;
	    private Coordinates textPosition = new Coordinates();
	    
	    public BitmapFont getFont() {
			return font;
		}

		public void setSize(int parameterSize) {
	    	parameter.size = parameterSize;
	    }
	    
	    public void initialize() {
	    	font = generator.generateFont(parameter);
	    }
	    
	    
	    public void setColor(float x1, float x2, float x3 , float x4) {
	    	font.setColor(x1,x2,x3,x4);
	    }
	    
	    
	    public void dispose() {
	    	generator.dispose();
	    	font.dispose();
	    }
	    
	    public Coordinates getTextPosition() {
			return textPosition;
		}

		public void setTextPosition(int x, int y) {
			this.textPosition.setCoordinates(x, y);
		}

		public void setTextString(String string) {
	    	this.textString = string;
	    }
	    
	    public String getTextString() {
	    	return this.textString;
	    }
	    
	    
	    
	}
	
}
