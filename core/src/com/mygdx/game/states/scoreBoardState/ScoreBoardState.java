package com.mygdx.game.states.scoreBoardState;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.collections.TextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollection;
import com.mygdx.collections.BarWithTextCollection.BarWithTextCollectionParameters;
import com.mygdx.config.SpriteConfig;
import com.mygdx.game.BarWithText;
import com.mygdx.game.states.State;
import com.mygdx.game.states.StateManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManager;
import com.mygdx.game.states.menuState.MenuDifficultyManager.MenuDifficultyManagerParameter;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.scoreBoardManager.ScoreBoardManager;
import com.mygdx.text.Text;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;

public class ScoreBoardState extends State {

	private int screenWidth;
	private int screenHeight;

	
	
	private ScoreBoardManager scoreBoardManager = new ScoreBoardManager();

	List<LinkedList<PlayerInfo>> scoreBoard = new LinkedList<>();

	private MenuDifficultyManager menuDifficultyManager = new MenuDifficultyManager(
			new MenuDifficultyManagerParameter("FACIL", Color.GREEN),
			new MenuDifficultyManagerParameter("MEDIO", Color.YELLOW),
			new MenuDifficultyManagerParameter("DIFICIL", Color.RED));

	private BarWithTextCollection difficultyBars;
	private Text[][] playersTexts = new Text[3][5];
	
	private float selectorRectangleWidth;
	private float selectorRectangleHeight;
	private int spaceBetweenBars;
	private float rectangleWidth;
	private float rectangleHeight;

		
	private BarWithText backToMenu;
	private int backToMenuRectangleWidth = 100;
	private int backToMenuRectangleHeight = 30;

	public ScoreBoardState(StateManager gsm, MouseTrack mouse) {
		super(gsm, mouse);
		configure();
		create();
	}

	@Override
	public void configure() {
		videoConfig.setCamera(cam);
		videoConfig.SetVideoSize(700, 700);
		videoConfig.setFixElements();
		videoConfig.setWindowedMode();
		videoConfig.setResizable(false);
		videoConfig.setTitle("Menu");

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
	}

	@Override
	public void create() {
		spaceBetweenBars = 70;
		
		for (int i = 0; i < 3; i++) {
			scoreBoard.add(new LinkedList<PlayerInfo>());
		}
		
		
		for (int i = 0; i < 3; i++) {
			PlayerInfo[] players = scoreBoardManager.getPlayersByDifficulty(i);
			
			for (int j = 0; j < 5; j++) {
				scoreBoard.get(i).add(players[j]);
			}
		}
		
		
		
		List<LinkedList<PlayerInfo>> scoreBoardCopy = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			scoreBoardCopy.add(new LinkedList<PlayerInfo>());
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				PlayerInfo playerAnalyzed = scoreBoard.get(i).get(j);
				
				if(playerAnalyzed == null) {
					scoreBoardCopy.get(i).add(null);
					continue;
				}
				
				if(j == 0) {
					scoreBoardCopy.get(i).add(playerAnalyzed);
				}
				else {
					int counter = 0;
					for(PlayerInfo playerInCopy : scoreBoardCopy.get(i)) {
						if (playerAnalyzed.getPoints() > playerInCopy.getPoints()) {
							counter++;
						}
					}
					scoreBoardCopy.get(i).add(counter,playerAnalyzed);
				}
			}
			
		}
		
		scoreBoard = scoreBoardCopy;
		
		
		for (int i = 0; i < 3; i++) {
			playersTexts[i] = new Text[5];
			for (int j = 0; j < 5; j++) {
				if(scoreBoard.get(i).get(j) == null) {
					continue;
				}
				playersTexts[i][j] = new Text();
				playersTexts[i][j].setSize(32);
				
				playersTexts[i][j].initialize();
				
				playersTexts[i][j].setTextString(scoreBoard.get(i).get(j).getName() +" " + scoreBoard.get(i).get(j).getPoints() );;
				playersTexts[i][j].setColor(Color.WHITE);;
				playersTexts[i][j].setTextPosition(screenWidth/2 - 32, -(j)*spaceBetweenBars + screenHeight/2 + 32*3);
			}
			
			}
		
		
		
		
		
		
		

		backToMenuRectangleWidth = 100;
		backToMenuRectangleHeight = 30;

		backToMenu = new BarWithText(
				FloatCoordinates.newCoordinates(backToMenuRectangleWidth, backToMenuRectangleHeight), FloatCoordinates
						.newCoordinates(backToMenuRectangleWidth / 2, screenHeight - backToMenuRectangleHeight / 2),
				"<- VOLTAR", Color.GRAY, Color.WHITE);

		rectangleWidth = 500;
		rectangleHeight = 50;

		selectorRectangleWidth = rectangleWidth - rectangleHeight * 2;
		selectorRectangleHeight = rectangleHeight;

		spaceBetweenBars = 70;

		difficultyBars = new BarWithTextCollection(BarWithTextCollectionParameters.getParameters("difficultyBar",
				BarWithText.newBarWithText(
						FloatCoordinates.newCoordinates(selectorRectangleWidth, selectorRectangleHeight),
						FloatCoordinates.newCoordinates(screenWidth / 2, screenHeight / 2 + spaceBetweenBars * 3),
						menuDifficultyManager.getDifficultyStringNow(), Color.DARK_GRAY,
						menuDifficultyManager.getDifficultyColorNow())

		),

				BarWithTextCollectionParameters.getParameters("increaseBar",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight, selectorRectangleHeight),
								FloatCoordinates.newCoordinates(
										screenWidth / 2 + selectorRectangleWidth / 2 + selectorRectangleHeight / 2,
										screenHeight / 2 + spaceBetweenBars * 3),
								">", Color.GRAY, Color.BLACK)),
				BarWithTextCollectionParameters.getParameters("decreaseBar",
						BarWithText.newBarWithText(
								FloatCoordinates.newCoordinates(selectorRectangleHeight, selectorRectangleHeight),
								FloatCoordinates.newCoordinates(
										screenWidth / 2 - selectorRectangleWidth / 2 - selectorRectangleHeight / 2,
										screenHeight / 2 + spaceBetweenBars * 3),
								"<", Color.GRAY, Color.BLACK))

		);
	}

	@Override
	public void handleInput() {
		if (difficultyBars.actorInListedBars(mouse.getMousePosition(), "increaseBar", "decreaseBar")
				|| GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), backToMenu.getBarRegion())) {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
		} else {
			Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
		}

		if (mouse.eventMouseLeftClickOnce()) {
			if (GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),
					difficultyBars.getBar("increaseBar").getBarRegion())) {
				menuDifficultyManager.increaseDificultyIndex();
				updateHandles();
			} else if (GameUtils.isIn2DSpaceBound(mouse.getMousePosition(),
					difficultyBars.getBar("decreaseBar").getBarRegion())) {
				menuDifficultyManager.decreaseDificultyIndex();
				updateHandles();
			} else if (GameUtils.isIn2DSpaceBound(mouse.getMousePosition(), backToMenu.getBarRegion())) {
				gsm.pop();
				dispose();
				gsm.configure();
				return;
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

	}

	@Override
	public void update(float dt) {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		mouse.setMousePosition();
		handleInput();
	}

	public void updateHandles() {
		difficultyBars.getBar("difficultyBar").setStringText(menuDifficultyManager.getDifficultyStringNow());
		difficultyBars.getBar("difficultyBar").setColor(menuDifficultyManager.getDifficultyColorNow());
	}

	@Override
	public void render(SpriteBatch sprite) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		SpriteConfig.setProjectionMatrix(sprite, videoConfig);
		difficultyBars.drawBars(sprite, "difficultyBar", "increaseBar", "decreaseBar");
		backToMenu.drawBar(sprite);
		
		sprite.begin();
		int indexNow = menuDifficultyManager.getDifficultyIndexNow();
		
		for (int j = 0; j < 5; j++) {
			if(playersTexts[indexNow][j] == null) {
				continue;
			}
			
			playersTexts[indexNow][j].draw(sprite);
		}
		sprite.end();
		
	}
		
		
	

	@Override
	public void dispose() {
		difficultyBars.disposeAll();
		backToMenu.dispose();
	}

}
