package com.mygdx.game;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.draw.TextDraw;
import com.mygdx.text.Text;
import com.mygdx.utils.Coordinates;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.Region2d;


public class BarWithText {
	private ShapeRenderer shape;
	private Text text;
	private String stringText;
	private FloatCoordinates barPosition;
	private FloatCoordinates widthAndHeight;
	private Region2d barRegion;
	
	
	
	
	public BarWithText(FloatCoordinates widthAndHeight ,FloatCoordinates barPosition,String stringText , Color barColor , Color textColor) {		
		
		//transfer the point to center
		this.barPosition = new FloatCoordinates(barPosition.getCoordinateX() - widthAndHeight.getCoordinateX()/2 ,barPosition.getCoordinateY() - widthAndHeight.getCoordinateY()/2  );
		this.widthAndHeight = widthAndHeight;
		
		shape = new ShapeRenderer();		
		shape.setColor(barColor);
		
		text = new Text();
		int textSizeHeight = (int) (0.65 * widthAndHeight.getCoordinateY());
		text.setSize(textSizeHeight);
		text.initialize();
		text.setTextString(stringText);
		text.getFont().setColor(textColor);
		
		GlyphLayout layout = new GlyphLayout(text.getFont(), text.getTextString());

		float centerX = this.barPosition.getCoordinateX() + this.widthAndHeight.getCoordinateX()/2 - layout.width / 2;
		float centerY = this.barPosition.getCoordinateY() + this.widthAndHeight.getCoordinateY()/2 + layout.height / 2;

		
		text.setTextPosition(centerX , centerY);
		
		barRegion = new Region2d(
				new FloatCoordinates(this.barPosition) , 
				new FloatCoordinates(this.barPosition.getCoordinateX() + this.widthAndHeight.getCoordinateX(), this.barPosition.getCoordinateY() + this.widthAndHeight.getCoordinateY()));
		

	}
	
	
	

	
	public void drawBar(SpriteBatch sprite) {
		shape.begin(ShapeType.Filled);
		shape.rect(barPosition.getCoordinateX(),barPosition.getCoordinateY() ,widthAndHeight.getCoordinateX() , widthAndHeight.getCoordinateY());
		shape.end();
		
		
		sprite.begin();
		TextDraw.draw(sprite, text);
		sprite.end();
		
	}

	
	public void setColor(Color color) {
		this.text.getFont().setColor(color);
	}
	
	public void setStringText(String stringText) {
		this.text.setTextString(stringText); 
	}
	
	
	public ShapeRenderer getShape() {
		return shape;
	}





	public void setShape(ShapeRenderer shape) {
		this.shape = shape;
	}





	public Text getText() {
		return text;
	}





	public void setText(Text text) {
		this.text = text;
	}





	public Region2d getBarRegion() {
		return barRegion;
	}
	
	
	
	public static BarWithText newBarWithText(FloatCoordinates widthAndHeight ,FloatCoordinates barPosition,String stringText , Color barColor , Color textColor) {
		return new BarWithText(widthAndHeight, barPosition, stringText, barColor, textColor);
	}
	
	public void dispose() {
		text.dispose();
		shape.dispose();
	}
	
	
}
