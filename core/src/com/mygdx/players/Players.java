package com.mygdx.players;

import java.util.ArrayList;
import java.util.HashMap;


public class Players {
	
	private HashMap<String, Player> playerMap = new HashMap<String, Player>();
	
	public Players() {
		
	}
	
	public Players(String... args) {

        for (int i = 0; i < args.length; i++) {
            String stringId = args[i];
            
            addPlayer(stringId);
        }
    }
	
	
	public void addPlayer(String... args) {
		 for (int i = 0; i < args.length; i++) {
	            String stringId = args[i];
	            
	            addPlayer(stringId);
	        }
	}
	
	
	public void addPlayer(String stringId) {
		int playerId = playerMap.size();
		Player player = new Player(playerId);
		
		playerMap.put(stringId, player);
		
	}
	
	
	
	
	public Player getPlayer(String stringId) {
		return playerMap.get(stringId);
		
	}
	
	public int getPlayersSize() {
		return playerMap.size();
	}
	
	public Player getPlayerByIndex(int index) {
		 ArrayList<Player> playersList = new ArrayList<>(playerMap.values());
	        
	        if (index >= 0 && index < playersList.size()) {
	            return playersList.get(index);
	        } else {
	            return null; 
	        }
	}
	
	public String getPlayerStringTextByIndex(int index) {
		 String[] keys = playerMap.keySet().toArray(new String[0]);
		 return keys[index];
			 
	}
	
	
	
	
	
	
	
}
