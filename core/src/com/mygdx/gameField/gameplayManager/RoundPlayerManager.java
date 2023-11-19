package com.mygdx.gameField.gameplayManager;

import java.util.ArrayList;
import java.util.HashMap;
import com.mygdx.collections.TextCollection;
import com.mygdx.text.Text;

public class RoundPlayerManager {
	private HashMap<String, Text> textMap;
	ArrayList<String> textList;
	
	
	private int playerIndexNow = 0;
	private String playerStringIdNow;
	
	
	public int getPlayerIndexNow() {
		return playerIndexNow;
	}

	public String getPlayerStringIdNow() {
		return playerStringIdNow;
	}

	public RoundPlayerManager(TextCollection textCollection) {
		textMap = textCollection.getHashMap();
		textList = new ArrayList<String>(textMap.keySet()); 
		
		this.playerStringIdNow = textList.get(0);
		
	}
	
	public void passPlayerIndex() {
		
		if (playerIndexNow == textList.size() - 1) {
			this.playerIndexNow = 0;
			this.playerStringIdNow = textList.get(playerIndexNow);
			return;
		}
		
		this.playerIndexNow++;	
		this.playerStringIdNow = textList.get(playerIndexNow);
		
		
	}


		
}
	
	

