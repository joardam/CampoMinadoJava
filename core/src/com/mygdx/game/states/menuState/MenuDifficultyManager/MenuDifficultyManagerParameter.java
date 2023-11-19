package com.mygdx.game.states.menuState.MenuDifficultyManager;

import com.badlogic.gdx.graphics.Color;

public class MenuDifficultyManagerParameter {
	String difficultyString;
	Color difficultyColor;
	
	
	public MenuDifficultyManagerParameter(String difficultyString, Color difficultyColor) {
		this.difficultyString  = difficultyString ; 
		this.difficultyColor = difficultyColor ; 
	}


	public String getDifficultyString() {
		return difficultyString;
	}


	public Color getDifficultyColor() {
		return difficultyColor;
	}
	
	
}
	

