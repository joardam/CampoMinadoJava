package com.mygdx.draw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gameField.cell.ClassicCell;
import com.mygdx.utils.Coordinates;
import com.mygdx.gameField.ClassicField;

public class FieldDraw {
	private final ClassicField field;
	private final int spriteSize;
	
	public FieldDraw(ClassicField field,int spriteSize){
		this.field = field;
		this.spriteSize = spriteSize;
	}
	
	
	
	public void drawField(SpriteBatch sprite, Texture texture) {
		ClassicCell[][] cells = field.getCells();
		for(ClassicCell[] cellsByCol: cells) {
			for(ClassicCell cellInCol : cellsByCol) {
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
