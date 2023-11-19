package com.mygdx.game.states.menuState.MenuDifficultyManager;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.collections.TextCollection;
import com.mygdx.text.Text;

public class MenuDifficultyManager{
	ArrayList<String> difficultyList = new ArrayList<String>();
	ArrayList<Color> difficultyColor = new ArrayList<Color>();
	
	private int difficultyIndexNow = 0;

	public MenuDifficultyManager(MenuDifficultyManagerParameter... args) {
	
		for(int i = 0 ; i < args.length ; i++) {
			MenuDifficultyManagerParameter parameter = (MenuDifficultyManagerParameter) args[i];
			difficultyList.add(parameter.getDifficultyString());
			difficultyColor.add(parameter.getDifficultyColor());
		}
		
	}
	
	public int getDifficultyIndexNow() {
		return difficultyIndexNow;
	}



	public ArrayList<String> getDifficultyList() {
		return difficultyList;
	}

	
	
	public void increaseDificultyIndex() {
		
		if (difficultyIndexNow == difficultyList.size() - 1) {
			return;
		}
		
		this.difficultyIndexNow++;
		
	}
	public void decreaseDificultyIndex() {
		
		if (difficultyIndexNow == 0) {
			return;
		}
		
		this.difficultyIndexNow--;	
		
		
	}
	
	public String getDifficultyStringNow() {
		return difficultyList.get(difficultyIndexNow);
	}

	public Color getDifficultyColorNow() {
		return difficultyColor.get(difficultyIndexNow);
	}
	
	
}
	
	
	
	

