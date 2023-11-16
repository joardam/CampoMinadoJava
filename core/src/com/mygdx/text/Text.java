package com.mygdx.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mygdx.utils.*;

public class Text {

	private FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
    private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    private BitmapFont font;
    private String textString;
    private FloatCoordinates textPosition = new FloatCoordinates();
    
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


	
    
    
    
}

