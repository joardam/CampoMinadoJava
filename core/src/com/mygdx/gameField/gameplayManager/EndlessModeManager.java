package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.ClassicField;

public class EndlessModeManager extends ClassicManager {
	
	public void RebuildField(ClassicField field) {
		field.fillCells(field.getCells().length, field.getCells()[0].length);
		field.placeBombs();
		field.placeCountersInSafeCells();
		
		restartGame();
		
	}
}
