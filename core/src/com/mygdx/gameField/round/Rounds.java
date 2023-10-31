package com.mygdx.gameField.round;

import com.mygdx.players.Players;

public class Rounds {
	private int playerIdInRound = 0;
	
	
	public void passPlayerRound(Players players){
		playerIdInRound++;
		
		if (playerIdInRound > players.getPlayersSize() - 1) {
			playerIdInRound = 0; 
		}
	}
	
	public int getPlayerIdInRound(){
		return this.playerIdInRound;
	}
}
