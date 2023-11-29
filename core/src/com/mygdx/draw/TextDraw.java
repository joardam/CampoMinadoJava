package com.mygdx.draw;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.text.Text;

public class TextDraw {
    public static void draw(SpriteBatch sprite ,Text text) {
    	BitmapFont font  = text.getFont();
    	String textString = text.getTextString();
    	int coordinateX = (int) text.getTextPosition().getCoordinateX();
    	int coordinateY = (int) text.getTextPosition().getCoordinateY();
    	
    	font.draw(sprite, textString, coordinateX, coordinateY);
    	
    	
    }
   
}
