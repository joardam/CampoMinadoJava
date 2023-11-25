package com.mygdx.gameField.gameplayManager;
import com.mygdx.collections.TextCollection;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.CharacteristicsOfTwoPlayersMode;

public class Mode2PlayersManager extends GameplayManager {
	RoundPlayerManager roundManager;
	

	
	 public RoundPlayerManager getRoundManager() {
		return roundManager;
	}




	public void setRoundManager(TextCollection textMap) {
		this.roundManager = new RoundPlayerManager(textMap);
	}


	@Override
	public void startTryToUncoverThisCell(int posX ,int posY, Field field) {
	  
		FieldCell[][] cells = field.getCells();
        FieldCell cell = cells[posX][posY];
       
        ((CharacteristicsOfTwoPlayersMode)cell.getCharacteristics()).startAnalyzeInteraction(roundManager);
        
        cell.analyzeLoss(gameStatus);
        cell.analyzeWin(field, gameStatus);
		 
			 
		 }
	        


//intern methods e classes
	
	public void passPlayerIndex() {
		 roundManager.passPlayerIndex();
	}
	
	    
	    
	   
	    
	    
	
}
