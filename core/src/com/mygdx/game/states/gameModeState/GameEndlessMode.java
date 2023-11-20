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
import com.mygdx.utils.InteractionManager;

public class GameEndlessMode extends GameModeState {
	
	private int rectangleWidth;
	private int rectangleHeight;
	private int pointsRectangleWidth;
	private int pointsRectangleHeight;
	private BarWithTextCollection interactionBars;
	private BarWithTextCollection pointsBar;
	private int gamePoints;
	
	
	private InteractionManager gamePointsInteraction = new InteractionManager();
	
	
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
		gamePoints = 0;
		
		gamePointsInteraction.startInteraction();
		
		gameplayManager = new EndlessModeManager();
		field = new ClassicField();
		super.create();
	
		
		rectangleWidth = 100; 
		rectangleHeight  = 30;
		
		
		pointsRectangleWidth = 120;
		pointsRectangleHeight = 30;
	
		
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
				
		
		pointsBar = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"pointsBar",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(pointsRectangleWidth, pointsRectangleHeight),
								FloatCoordinates.newCoordinates(pointsRectangleWidth/2, spriteSize/2),
								"PONTOS : " + gamePoints,
								Color.DARK_GRAY,
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
			
			
			if(gamePointsInteraction.inAction()) {
				gamePoints++;
				gamePointsInteraction.stopInteraction();
			}
			
			
			
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), interactionBars.getBar("nextBar").getBarRegion())) {
				Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

				if(leftClickInteraction.inAction()) {
					if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), interactionBars.getBar("nextBar").getBarRegion())) {						
						((EndlessModeManager)gameplayManager).RebuildField((ClassicField)field);
						gamePointsInteraction.startInteraction();
						
					
					}
			}
				if(leftClickInteraction.inAction()) {
					leftClickInteraction.stopInteraction();
					}
			
				}
			
			}
		
		
		if(leftClickInteraction.inAction()) {
			leftClickInteraction.stopInteraction();
		}
	}

	@Override
	public void update(float dt) {

		pointsBar.getBar("pointsBar").setStringText("PONTOS : " + gamePoints);
		super.update(dt);
	}

	@Override
	public void render(SpriteBatch sprite) {
		super.render(sprite);
		
		pointsBar.drawBars(sprite, "pointsBar");
		
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
