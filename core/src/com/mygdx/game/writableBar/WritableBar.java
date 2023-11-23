package com.mygdx.game.writableBar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.text.Text;
import com.mygdx.utils.FloatCoordinates;

public class WritableBar {
	private Stage stage;
    private TextField textField;
    private Skin skin = new Skin();
    private Text text = new Text();
    
    
    
    public WritableBar(FloatCoordinates barSizes , FloatCoordinates barPosition , Color fontColor, Color cursorColor ,Color selectionColor , Color backgroundColor) {
    	stage = new Stage();
    	Gdx.input.setInputProcessor(stage);
    	
    	int scale;
		scale = (int) (0.60* barSizes.getCoordinateY());
		text.setSize(scale);
		text.initialize();
		
		skin.add("default", text.getFont());
		skin.add("forField", new Texture(Gdx.files.internal("white.jpg")));
		
		Texture cursorTexture = new Texture(Gdx.files.internal("white.jpg"));
		cursorTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		
		int newCursorWidth = 5; 
		int newCursorHeight = 30;
		
		  TextureRegion cursorRegion = new TextureRegion(cursorTexture, 0, 0, cursorTexture.getWidth(), cursorTexture.getHeight());
		  cursorRegion.setRegionWidth(newCursorWidth);
		  cursorRegion.setRegionHeight(newCursorHeight);
		  skin.add("cursor", cursorRegion);
		  
		  TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
	        textFieldStyle.font = skin.getFont("default");
	        textFieldStyle.fontColor = fontColor;
	        
	        textFieldStyle.selection = skin.newDrawable("forField", selectionColor); 
	        textFieldStyle.cursor = skin.newDrawable("cursor", cursorColor); 
	        
	        textFieldStyle.background = skin.newDrawable("forField", backgroundColor); 
	        skin.add("default", textFieldStyle);
	
	       
	        textField = new TextField("", textFieldStyle);
	        textField.setSize(barSizes.getCoordinateX(), barSizes.getCoordinateY());
	        textField.setPosition(barPosition.getCoordinateX() - barSizes.getCoordinateX()/2, barPosition.getCoordinateY() - barSizes.getCoordinateY()/2);
	        
	        int maxCharacters = 5; 
	        textField.setTextFieldFilter(new MaxCharacterFilter(maxCharacters));
	       
	        stage.addActor(textField);
    }
   
    
    public void draw() {
    	stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
    
    
    public String getWritten() {
    	return textField.getText();

    }
    
    
    public void dispose() {
    	stage.dispose();
	    skin.dispose();
    }
    
    private static class MaxCharacterFilter implements TextField.TextFieldFilter {
	    private int maxCharacters;

	    public MaxCharacterFilter(int maxCharacters) {
	        this.maxCharacters = maxCharacters;
	    }

	    @Override
	    public boolean acceptChar(TextField textField, char c) {
	        return textField.getText().length() < maxCharacters;
	    }
	}
}


