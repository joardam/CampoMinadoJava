package com.mygdx.gameField.gameplayManager;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.mygdx.collections.TextCollection;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;

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
	  
		FieldCell[][] cells = field.getCells();
		FieldCell cell = cells[posX][posY];
		cell.roundPassFilter(roundManager);
		super.tryToUncoverThisCell(posX,posY,field);
	  
	        
	        
	        
	    }

	   
	    
	    
	
}
