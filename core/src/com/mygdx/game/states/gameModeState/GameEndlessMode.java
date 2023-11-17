package com.mygdx.game.states.gameModeState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.TextCollection;
import com.mygdx.draw.TextDraw;
import com.mygdx.game.states.StateManager;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.gameplayManager.EndlessModeManager;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.Region2d;
import com.mygdx.utils.RgbaColor;

public class GameEndlessMode extends GameModeState {
	
	TextCollection interactionTexts;
	ShapeCollection shapes;
	private int screenWidth;
	private int screenHeight;
	float[] textUpperCenter;
	private float[] rectangleInUpperCenter;
	private int rectangleWidth;
	private int rectangleHeight;
	
	
	public GameEndlessMode(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		rows = 15;
		cols = 16;
		bombsQuantity = 5;
		create();

	}
	public GameEndlessMode(StateManager gsm, MouseTrack mouse, String difficultyStringIdNow) {
		super(gsm, mouse, difficultyStringIdNow);
		create();
	}
	
	
	@Override
	public void create() {
		gameplayManager = new EndlessModeManager();
		field = new ClassicField();
		super.create();
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		rectangleInUpperCenter = new float[2];
		rectangleInUpperCenter[0] = screenWidth/2 - rectangleWidth / 2;
		rectangleInUpperCenter[1] = screenHeight - rectangleHeight;
		
		rectangleWidth = 100; 
		rectangleHeight  = 30;
		
		
		textUpperCenter = new float[2];
		textUpperCenter[0] = screenWidth / 2; 
		textUpperCenter[1] = screenHeight - spriteSize/2; 
		
		
		interactionTexts = new TextCollection(
				"nextGame" , "PROXIMO" , 20 ,
				new RgbaColor("white") , 
				new FloatCoordinates(textUpperCenter[0],textUpperCenter[1])
				);
		
		shapes = new ShapeCollection(
				"nextGame" , new RgbaColor("gray")
				);
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void handleInput() {
		super.handleInput();
		
		Region2d nextGameRegion = new Region2d(
				new FloatCoordinates(rectangleInUpperCenter[0] ,rectangleInUpperCenter[1]),
				new FloatCoordinates(rectangleInUpperCenter[0] + rectangleWidth ,rectangleInUpperCenter[1] + rectangleHeight)
				);
		
		if(mouse.eventMouseLeftClickOnce()) {
			
			if(!gameplayManager.isWinStatus()) {
				return;
			}
			
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), nextGameRegion)) {
				((EndlessModeManager)gameplayManager).RebuildField((ClassicField)field);
			}
			
		}
		
		
	}

	@Override
	public void update(float dt) {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		rectangleInUpperCenter[0] = screenWidth/2 - rectangleWidth / 2;
		rectangleInUpperCenter[1] = screenHeight - rectangleHeight;
		
		
		super.update(dt);
	}

	@Override
	public void render(SpriteBatch sprite) {
		super.render(sprite);
		
		if(gameplayManager.isWinStatus()) {
			shapes.shapesBegin("nextGame");
			
			shapes.setRect(
					"nextGame" ,
					new FloatCoordinates(rectangleInUpperCenter[0], rectangleInUpperCenter[1]),
					new FloatCoordinates(rectangleWidth, rectangleHeight)
					);
			
			shapes.shapesEnd("nextGame");
			
			sprite.begin();
			TextDraw.draw(sprite, interactionTexts.getText("nextGame"));
			sprite.end();
			
		}
		
		
		
	}

	@Override
	public void dispose() {
		super.dispose();
		interactionTexts.disposeAll();
		shapes.disposeAll();
	}

	

}
