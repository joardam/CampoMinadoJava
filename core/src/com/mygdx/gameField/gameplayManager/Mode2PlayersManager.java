package com.mygdx.gameField.gameplayManager;
import com.mygdx.collections.PlayerCollection;
import com.mygdx.gameField.ClassicField;

public class Mode2PlayersManager extends GameplayManager {
	PlayerCollection players ;
	
	public Mode2PlayersManager(PlayerCollection players){
		this.players = players;
	}
	
	
	 public void tryToUncoverThisCell(int posX ,int posY, ClassicField field) {
	  
		 super.tryToUncoverThisCell(posX,posY,field);
	  
	    	if((gameOverStatus == true) || (winStatus == true)) {
	        	return;
	    	}
	        
	        this.rounds.passPlayerRound(players);
	        
	    }

	   
	    
	    
	
}
