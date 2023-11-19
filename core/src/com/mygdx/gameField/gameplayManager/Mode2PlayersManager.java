package com.mygdx.gameField.gameplayManager;
import com.mygdx.collections.TextCollection;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.Field;

public class Mode2PlayersManager extends GameplayManager {
	RoundPlayerManager roundManager ;
	
	
	
	
	 public RoundPlayerManager getRoundManager() {
		return roundManager;
	}




	public void setRoundManager(TextCollection textMap) {
		this.roundManager = new RoundPlayerManager(textMap);
	}



	@Override
	public void tryToUncoverThisCell(int posX ,int posY, Field field) {
	  
		 super.tryToUncoverThisCell(posX,posY,field);
	  
	    	if((gameOverStatus == true) || (winStatus == true)) {
	        	return;
	    	}
	        
	       roundManager.passPlayerIndex();
	        
	        
	    }

	   
	    
	    
	
}
