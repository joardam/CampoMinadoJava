package com.mygdx.game.states;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.gameField.GameField;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.Utils;

public class GameClassicModeState extends GameModeState {
	
	
	public GameClassicModeState(StateManager gsm , MouseTrack mouse) {
		super(gsm , mouse);
		create();

	}
		
		
	@Override
	public void create() {
		field = new GameField();
		
		super.create();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
	}
	
	
	@Override 
	public void handleInput() {
		 int mouseFieldX = (int) mouse.getMouseX() / spriteSize - 1 ;
		 int mouseFieldY = (int) mouse.getMouseY() / spriteSize - 1 ;
		 
		if(mouse.eventMouseLeftClickOnce()&&
				Utils.isIn2DArrayBound(mouseFieldX ,mouseFieldY, rows, cols)) {
			
        	gameplayManager.tryToUncoverThisCell(mouseFieldX , mouseFieldY, field);
        	
        }
        
        if(mouse.eventMouseRightClickOnce()) {
        	gameplayManager.tryToToggleFlagThisCell(mouseFieldX,mouseFieldY, field);
        }
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
	}
	
	@Override
	public void render(SpriteBatch sprite) {
		super.render(sprite);
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}




	
	
}
