package com.mygdx.game.states.gameModeState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.ShapeCollection;
import com.mygdx.collections.TextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.StateManager;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.gameplayManager.EndlessModeManager;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;

public class GameEndlessMode extends GameModeState {
	
	TextCollection interactionTexts;
	ShapeCollection shapes;
	private int rectangleWidth;
	private int rectangleHeight;
	private BarWithTextCollection interactionBars;
	
	
	public GameEndlessMode(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		rows = 15;
		cols = 16;
		bombsQuantity = 5;
		super.configure();
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
	
		
		rectangleWidth = 100; 
		rectangleHeight  = 30;
		
	
		
		interactionBars = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"nextBar",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(rectangleWidth, rectangleHeight),
								FloatCoordinates.newCoordinates(screenWidth/2, screenHeight - spriteSize/2),
								"PROXIMO",
								Color.GRAY,
								Color.WHITE
								)
						)
				);
				
		
	}
		

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void handleInput() {
		super.handleInput();
		
		
		if(gameplayManager.isWinStatus()) {
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), interactionBars.getBar("nextBar").getBarRegion())) {
				Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
			}
			
		}
		
		

		if(leftClickInteraction.inAction()) {
			
			
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), interactionBars.getBar("nextBar").getBarRegion())) {
				((EndlessModeManager)gameplayManager).RebuildField((ClassicField)field);
					
			}
			
			leftClickInteraction.stopInteraction();
		}
		
		
	
		
	}

	@Override
	public void update(float dt) {

		
		super.update(dt);
	}

	@Override
	public void render(SpriteBatch sprite) {
		super.render(sprite);
		
		if(gameplayManager.isWinStatus()) {
			interactionBars.drawBars(sprite, "nextBar");
		}
		
		
		
	}

	@Override
	public void dispose() {
		super.dispose();
		interactionBars.disposeAll();
		
	}

	

}
