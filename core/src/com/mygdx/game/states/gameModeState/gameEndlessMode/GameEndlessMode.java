package com.mygdx.game.states.gameModeState.gameEndlessMode;

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
import com.mygdx.game.states.gameModeState.GameModeState;
import com.mygdx.game.writableBar.WritableBar;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.gameplayManager.EndlessModeManager;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.Coordinates;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.InteractionManager;
import com.mygdx.utils.Region2d;

public class GameEndlessMode extends GameModeState {
	
	private int sigmaSpace = 10;
	
	private int rectangleWidth;
	private int rectangleHeight;
	private int pointsRectangleWidth;
	private int pointsRectangleHeight;
	
	
	
	private BarWithTextCollection nextGameBar;
	private BarWithTextCollection pointsBar;
	private BarWithTextCollection nameSpaceBar;
	private int gamePoints;
	
	private Coordinates bigSquareSides;
	private Coordinates addInfoRequestSides;
	private Coordinates acceptAddNewNameSides;
	private Coordinates declineAddNewNameSides;
	private Coordinates fieldForNameSides;
	
	private WritableBar nameBar;
	
	
	
	private InteractionManager gamePointsInteraction = new InteractionManager();
	private InteractionManager addNameInteraction = new InteractionManager();
	
	
	public GameEndlessMode(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		rows = 15;
		cols = 16;
		bombsQuantity = 5;
		super.configure();
		create();

	}
	public GameEndlessMode(StateManager gsm, MouseTrack mouse, int difficulty) {
		super(gsm, mouse, difficulty);
		create();
	}
	
	
	@Override
	public void create() {
		gamePoints = 0;
		

		
		gameplayManager = new EndlessModeManager();
		field = new ClassicField();
		super.create();
	
		
		rectangleWidth = 100; 
		rectangleHeight  = 30;
		
		
		pointsRectangleWidth = 120;
		pointsRectangleHeight = 30;
	
		bigSquareSides = new Coordinates(32*11,300);
		addInfoRequestSides = new Coordinates(bigSquareSides.getCoordinateX() , bigSquareSides.getCoordinateY()/6);
		
		acceptAddNewNameSides = new Coordinates(bigSquareSides.getCoordinateX()/2 - 2*sigmaSpace , bigSquareSides.getCoordinateY()/6);
		declineAddNewNameSides = acceptAddNewNameSides;
		
		fieldForNameSides = addInfoRequestSides;
		
		nextGameBar = new BarWithTextCollection(
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
		
		nameSpaceBar = new BarWithTextCollection(
				BarWithTextCollectionParameters.getParameters(
						"bigSquareBar",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(bigSquareSides),
								FloatCoordinates.newCoordinates(screenWidth/2, screenHeight/2),
								"",
								Color.DARK_GRAY,
								Color.WHITE
								)
						),
				
				BarWithTextCollectionParameters.getParameters(
						"addRequest",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(addInfoRequestSides),
								FloatCoordinates.newCoordinates(screenWidth/2, screenHeight/2 + bigSquareSides.getCoordinateY() * 1/2 - addInfoRequestSides.getCoordinateY()*1/2),
								"Adicionar nome",
								Color.DARK_GRAY,
								Color.WHITE
								)
						),
					
				BarWithTextCollectionParameters.getParameters(
						"add",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(acceptAddNewNameSides),
								FloatCoordinates.newCoordinates(
										screenWidth/2 - bigSquareSides.getCoordinateX()/2 + acceptAddNewNameSides.getCoordinateX()/2 + sigmaSpace ,
										screenHeight/2 - bigSquareSides.getCoordinateY()/2 + acceptAddNewNameSides.getCoordinateY()/2 + 3*sigmaSpace),
								"FEITO",
								Color.GRAY,
								Color.WHITE
								)
						),
				
				BarWithTextCollectionParameters.getParameters(
						"decline",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(declineAddNewNameSides),
								FloatCoordinates.newCoordinates(
										screenWidth/2 + bigSquareSides.getCoordinateX()/2 - declineAddNewNameSides.getCoordinateX()/2 - sigmaSpace ,
										screenHeight/2 - bigSquareSides.getCoordinateY()/2 + declineAddNewNameSides.getCoordinateY()/2 + 3*sigmaSpace),
								"NEGAR",
								Color.GRAY,
								Color.WHITE
								)
						
						)
				
				
				
				);
		
		nameBar = new WritableBar(
				FloatCoordinates.newCoordinates(fieldForNameSides.getCoordinateX()/2 ,fieldForNameSides.getCoordinateY()),
				FloatCoordinates.newCoordinates(screenWidth/2, screenHeight/2),
				Color.WHITE ,
				Color.WHITE ,
				Color.BLACK,
				Color.GRAY
				);
		
		
	}
		

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void handleInput() {
		super.handleInput();
		
		if(addNameInteraction.inAction()) {
			if(nameSpaceBar.actorInListedBars(mouse.getMousePosition(), "add" , "decline")) {
				Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
				
				
				if(leftClickInteraction.inAction()) {
					if(nameSpaceBar.actorInListedBars(mouse.getMousePosition(), "decline")) {
						addNameInteraction.closeInteraction();
						leftClickInteraction.stopInteraction();
					}
					
					if(nameSpaceBar.actorInListedBars(mouse.getMousePosition(), "add")) {
						addNameInteraction.closeInteraction();
						leftClickInteraction.stopInteraction();
						
						SaveToScoreBoardManager saveManager = new SaveToScoreBoardManager();
						
						saveManager.publishName(nameBar.getWritten() , difficulty , gamePoints);
						
						
					
					}
				
				}
					
			}
			
		}
		
		
		if(gamePointsInteraction.inAction()) {
			if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), nextGameBar.getBar("nextBar").getBarRegion())) {
				Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

				if(leftClickInteraction.inAction()) {
					if(GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), nextGameBar.getBar("nextBar").getBarRegion())) {						
						((EndlessModeManager)gameplayManager).RebuildField((ClassicField)field);
						gamePointsInteraction.stopInteraction();
						leftClickInteraction.stopInteraction();
						}
			}	
				
			}
			
		}
		
		
		if(leftClickInteraction.inAction()) {
			leftClickInteraction.stopInteraction();
			}
	}
	@Override
	public void update(float dt) {

		if(gameplayManager.isWinStatus()) {
			
			if(!gamePointsInteraction.inAction()) {
				gamePointsInteraction.startInteraction();
				gamePoints++;
				
			}
			
		}
		
		if(gameplayManager.getGameOverStatus()) {
			if(!addNameInteraction.inAction()) {
				addNameInteraction.startInteraction();
			}
		}
		
		
		pointsBar.getBar("pointsBar").setStringText("PONTOS : " + gamePoints);
		super.update(dt);
		
	}

	@Override
	public void render(SpriteBatch sprite) {
		super.render(sprite);
		
		pointsBar.drawBars(sprite, "pointsBar");
		
		if(gameplayManager.isWinStatus()) {
			nextGameBar.drawBars(sprite, "nextBar");
		}
		
	
		if(addNameInteraction.inAction()) {
			nameSpaceBar.drawBars(sprite,"bigSquareBar" , "addRequest" , "add" , "decline");
			nameBar.draw();
		}
		
		
		
		
	}

	@Override
	public void dispose() {
		super.dispose();
		nextGameBar.disposeAll();
		nameSpaceBar.disposeAll();
	
	}

	

}
