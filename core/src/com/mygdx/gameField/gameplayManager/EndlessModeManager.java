package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.ClassicField;
import com.mygdx.utils.InteractionManager;

public class EndlessModeManager extends ClassicManager {
	
	public void RebuildField(ClassicField field) {
		field.fillCells(field.getCells().length, field.getCells()[0].length);
		field.placeBombs();
		field.placeCountersInSafeCells();
		
		winStatus = false;
		
		
	}
	
	
	public void winInEndlessShowAddNameInteraction(InteractionManager gamePointsInteraction , int gamePoints){
		gameStatus.winInEndlessInteraction(gamePointsInteraction , gamePoints);
		
	}


	public void looseInEndlessShowAddNameInteraction(InteractionManager addNameInteraction) {
		gameStatus.looseInEndlessInteraction(addNameInteraction);
		
	}
}
