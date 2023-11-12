package com.mygdx.gameField;
import com.mygdx.players.Players;

public class Mode2PlayersManager extends GameplayManager {
	Players players ;
	
	public Mode2PlayersManager(Players players){
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
