package com.mygdx.players;

public class Player {
	
	private int playerId;
	private int playerPoints;
	
	
	public Player(int playerId) {
		this.playerId = playerId;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	
	public int getPlayerPoints() {
		return playerPoints;
	}
	public void addPlayerPoint() {
		this.playerPoints++;
	}
	
	
	
	
	
	
}
