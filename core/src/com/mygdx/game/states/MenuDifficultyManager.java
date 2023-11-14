package com.mygdx.game.states;

import java.util.ArrayList;
import java.util.HashMap;

import com.mygdx.gameField.texts.Text;
import com.mygdx.gameField.texts.TextCollection;

public class MenuDifficultyManager{
	private HashMap<String, Text> textMap;
	ArrayList<String> textList;
	
	
	
	private int difficultyIndexNow = 0;
	private String difficultyStringIdNow;
	
	
	public int getDifficultyIndexNow() {
		return difficultyIndexNow;
	}

	public String getDifficultyStringIdNow() {
		return difficultyStringIdNow;
	}

	public MenuDifficultyManager(TextCollection textCollection) {
		textMap = textCollection.getHashMap();
		textList = new ArrayList<String>(textMap.keySet()); 
		
		this.difficultyStringIdNow = textList.get(0);
		
	}
	
	public void increaseDificultyIndex() {
		
		if (difficultyIndexNow == textList.size() - 1) {
			return;
		}
		
		this.difficultyIndexNow++;	
		this.difficultyStringIdNow = textList.get(difficultyIndexNow);
		
		
	}
	public void decreaseDificultyIndex() {
		
		if (difficultyIndexNow == 0) {
			return;
		}
		
		this.difficultyIndexNow--;	
		this.difficultyStringIdNow = textList.get(difficultyIndexNow);
		
		
	}
	

		
}
	
	
	
	

