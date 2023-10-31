package com.mygdx.draw;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gameField.texts.Text;

public class TextDraw {
    public static void draw(SpriteBatch sprite ,Text text) {
    	BitmapFont font  = text.getFont();
    	String textString = text.getTextString();
    	int coordinateX = text.getTextPosition().getCoordinateX();
    	int coordinateY = text.getTextPosition().getCoordinateY();
    	
    	font.draw(sprite, textString, coordinateX, coordinateY);
    	
    	
    }
   
}
