package com.mygdx.gameField;

import com.mygdx.gameField.cell.CellStructureManager;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.MinedCell;
import com.mygdx.gameField.cell.SafeCell;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.gameField.cell.state.covered.CoveredCellAndFlaggedState;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.utils.Utils;

public class FieldCellsInteractionManager {
	public static void tryToUncoverThisCell(MouseTrack mouse , GameField field){
		
		int posX = mouse.getMouseCordinates().getCoordinateX();
    	int posY  = mouse.getMouseCordinates().getCoordinateY();
    	
    	FieldCell[][] cells = field.getCells(); 
    	FieldCell cell = cells[posX - 1][posY - 1];
    	CellStructureManager.UncoverCell(cell);
    	
    	
    	if(cell instanceof MinedCell && !(cell.getCellState() instanceof CoveredCellAndFlaggedState)) {
    		explodeField(cell , cells);
    	}
    	
    	
    	if(cell instanceof SafeCell && (((SafeCell) cell).getNearBombs() == 0)) {
    		boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
    		uncoverFlood(cells,posX - 1,posY - 1,virtualArrayForFieldCheck);
    	}
    	
    	
	}
	
	public static void tryToToggleFlagThisCell(MouseTrack mouse , GameField field) {
		int posX = mouse.getMouseCordinates().getCoordinateX();
    	int posY  = mouse.getMouseCordinates().getCoordinateY();
    	
    	
    	FieldCell cell = field.getCells()[posX - 1][posY - 1];
    	CellStructureManager.ToggleFlagCell(cell);
	}
	
	public static void explodeField(FieldCell cell,FieldCell[][] cells) {
		for (int i = 0; i < cells.length; i++) {
		        for (int j = 0; j < cells[i].length; j++) {
		            if(!(cells[i][j].getCellState() instanceof UncoveredCellState)) {
		            	CellStructureManager.forceUncoverCell(cells[i][j]);
		            }
		            
		            }
		        }
		    }
	
	public static void uncoverFlood(FieldCell[][] cells , int arrayPosX, int arrayPosY ,boolean[][] virtualArrayForFieldCheck){
		
		if(!Utils.isIn2DArrayBound(arrayPosX, arrayPosY, cells.length, cells[0].length)||
				(virtualArrayForFieldCheck[arrayPosX][arrayPosY]) ||
				(cells[arrayPosX][arrayPosY] instanceof MinedCell)) {
			return;
		};
		
		if ((cells[arrayPosX][arrayPosY] instanceof SafeCell) &&
				(((SafeCell)cells[arrayPosX][arrayPosY]).getNearBombs() != 0) 
				){
			
			CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);	
			virtualArrayForFieldCheck[arrayPosX][arrayPosY] = true;
				
			
				for (int k = -1; k <= 1; k++) {
					int loopX = arrayPosX + k;
					int loopY = arrayPosY + k;
					
					if( Utils.isIn2DArrayBound( loopX, arrayPosY, cells.length, cells[0].length) &&
							( virtualArrayForFieldCheck[loopX][arrayPosY] )  &&
							( cells[loopX][arrayPosY] instanceof SafeCell) && ( ( (SafeCell)cells[loopX][arrayPosY] ).getNearBombs() == 0 ) ){
						loopEdges(virtualArrayForFieldCheck , cells , loopX ,arrayPosY);
					}
					
					if( Utils.isIn2DArrayBound( arrayPosX, loopY, cells.length, cells[0].length) &&
							( virtualArrayForFieldCheck[arrayPosX][loopY] )  &&
							( cells[arrayPosX][loopY] instanceof SafeCell) && ( ( (SafeCell)cells[arrayPosX][loopY] ).getNearBombs() == 0 ) ){
						loopEdges(virtualArrayForFieldCheck , cells , arrayPosX ,loopY);
					}
						
			}
				return;
		}
		
		virtualArrayForFieldCheck[arrayPosX][arrayPosY] = true;
		
		if (!(cells[arrayPosX][arrayPosY] instanceof MinedCell)) {
			CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);
			
			//Faz um Flood fill
			uncoverFlood(cells, arrayPosX - 1, arrayPosY,virtualArrayForFieldCheck);
			uncoverFlood(cells, arrayPosX + 1, arrayPosY,virtualArrayForFieldCheck);
			uncoverFlood(cells, arrayPosX , arrayPosY - 1 , virtualArrayForFieldCheck);
			uncoverFlood(cells, arrayPosX, arrayPosY + 1,virtualArrayForFieldCheck);

		}
		
		
	}
	
	public static void loopEdges(boolean[][] virtualArrayForFieldCheck ,FieldCell[][] cells ,  int x, int y) {
		for (int k = -1; k <= 1; k++) {
			for (int l = -1; l <= 1; l++) {
				int loopX = x + k;
				int loopY = y + l;
				uncoverFlood(cells , loopX, loopY , virtualArrayForFieldCheck);
				l++;
			}
			k++;
		}
	}
	
}

