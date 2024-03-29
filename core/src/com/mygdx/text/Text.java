package com.mygdx.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mygdx.utils.*;

public class Text {

	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
    private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    private BitmapFont font;
    private String textString;
    
    public FreeTypeFontGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(FreeTypeFontGenerator generator) {		
		this.generator = generator;
	}

	private FloatCoordinates textPosition = new FloatCoordinates();
    
    public BitmapFont getFont() {
		return font;
	}

	public void setSize(int textSizeHeight) {
    	parameter.size = textSizeHeight;
    }
    
    public void initialize() {
    	font = generator.generateFont(parameter);
    	generator.dispose();

    	
    }
    
    
    public void setColor(float x1, float x2, float x3 , float x4) {
    	font.setColor(x1,x2,x3,x4);
    }
    
    public void setColor(Color color) {
    	font.setColor(color);
    }
    
    
    public void dispose() {
    	font.dispose();
    }
    
    public FloatCoordinates getTextPosition() {
		return textPosition;
	}

	public void setTextPosition(float x, float y) {
		this.textPosition.setCoordinates(x, y);
	}

	public void setTextString(String string) {
    	this.textString = string;
    }
    
    public String getTextString() {
    	return this.textString;
    }

    
    public void draw(SpriteBatch sprite) {
    	BitmapFont font  = this.getFont();
    	String textString = this.getTextString();
    	int coordinateX = (int) this.getTextPosition().getCoordinateX();
    	int coordinateY = (int) this.getTextPosition().getCoordinateY();
    	
    	font.draw(sprite, textString, coordinateX, coordinateY);
    	
    	
    }
	
    
    
    
}

