package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.mygdx.config.SpriteConfig;
import com.mygdx.config.VideoSettings; 
import com.mygdx.mouseTrack.MouseTrack;

public class WriteTest extends State {
	private Stage stage;
    private TextField textField;
    private Skin skin;
    
	private VideoSettings videoConfig = new VideoSettings();
	
	
	protected WriteTest(StateManager gsm) {
		super(gsm);
		create();
	}
	
	
	public WriteTest(StateManager gsm, MouseTrack mouse) {
		super(gsm , mouse);
		create();
	}
	
	@Override
	public void create() {
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("writeText");
		
		
		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        skin = new Skin();
        
        skin.add("default", font);
        skin.add("white", new Texture(Gdx.files.internal("white.jpg")));
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
        textFieldStyle.fontColor = com.badlogic.gdx.graphics.Color.BLACK;
        
        textFieldStyle.selection = skin.newDrawable("white", Color.LIGHT_GRAY); 
        textFieldStyle.cursor = skin.newDrawable("cursor", Color.BLACK); 
        
        textFieldStyle.background = skin.newDrawable("white", Color.DARK_GRAY); 
        skin.add("default", textFieldStyle);

       
        textField = new TextField("", textFieldStyle);
        textField.setSize(200, 30);
        textField.setPosition(Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f);
        
        int maxCharacters = 5; 
        textField.setTextFieldFilter(new MaxCharacterFilter(maxCharacters));
       
        stage.addActor(textField);
 
	}

	@Override
	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
	        // Enter key is pressed, print the text
	        String enteredText = textField.getText();
	        System.out.println("Entered text: " + enteredText);
	    }
	}

	

	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void update(float dt) {
		mouse.setMousePosition();
		handleInput();

	}

	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        sprite.begin();
		sprite.end();
		

	}

	@Override
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
	

