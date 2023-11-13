package com.mygdx.draw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gameField.cell.ClassicCell;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.utils.Coordinates;
import com.mygdx.gameField.ClassicField;
import com.mygdx.gameField.Field;

public class FieldDraw {
	private final Field field;
	private final int spriteSize;
	
	public FieldDraw(Field field,int spriteSize){
		this.field = field;
		this.spriteSize = spriteSize;
	}
	
	
	
	public void drawField(SpriteBatch sprite, Texture texture) {
		FieldCell[][] cells = field.getCells();
		for(FieldCell[] cellsByCol: cells) {
			for(FieldCell cellInCol : cellsByCol) {
				Coordinates position;
				int posX;
				int posY;
				
				int textureId = CellTextureManager.getTextureByCell(cellInCol);
				
				position = cellInCol.getCellPosition();
				
				posX = position.getCoordinateX();
				posY = position.getCoordinateY();
				
				
				int x = textureId * spriteSize;
				int y = 0;
				int width = spriteSize;
				int height = spriteSize;
				
				int renderX = (posX + 1 ) * spriteSize;
				int renderY = (posY + 1 ) * spriteSize;
				
				TextureRegion region = new TextureRegion(texture,x,y,width,height);
				sprite.draw(region,renderX, renderY);
				
				
			}
		
		}
		
	}
	
	
	
}
