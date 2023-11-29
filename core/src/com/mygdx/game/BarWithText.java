package com.mygdx.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.draw.TextDraw;
import com.mygdx.text.Text;
import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.Region2d;


public class BarWithText {
		private Rectangle bar;
	    private Text text;
	    private FloatCoordinates barPosition;
	    private Region2d barRegion;
	    private String stringText ;
	    private Color barColor;
	
	
	
	public BarWithText(FloatCoordinates size,FloatCoordinates barPosition ,String stringText , Color barColor , Color textColor) {		
		
		this.barPosition = barPosition;
		this.text = new Text();
		
		this.bar = new Rectangle(barPosition.getCoordinateX() -  size.getCoordinateX()/2, barPosition.getCoordinateY() - size.getCoordinateY()/2, size.getCoordinateX(), size.getCoordinateY());
	    this.barColor = barColor;
	    this.stringText = stringText;
	   
	    
	    
	    text.setSize((int) (0.60* size.getCoordinateY()));
	    text.initialize();
	    text.setColor(textColor);
	    text.setTextString(stringText);
	    
	    
	    GlyphLayout layout = new GlyphLayout(text.getFont(), stringText);

		float centerX = bar.x + size.getCoordinateX()/2 - layout.width / 2;
		float centerY = bar.y + size.getCoordinateY()/2 + layout.height /2;

		
		text.setTextPosition(centerX , centerY);
	 
	    
		
		barRegion = new Region2d(
				new FloatCoordinates(bar.x ,bar.y) , 
				new FloatCoordinates( bar.x + size.getCoordinateX() , bar.y + size.getCoordinateY()
						)
				);
		

	}
	
	
	
	
	
	 public Text getText() {
		return text;
	}


	private Texture createTexture(Color color) {
	        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
	        pixmap.setColor(color);
	        pixmap.fill();
	        Texture texture = new Texture(pixmap);
	        pixmap.dispose();
	        return texture;
	    }

	
	
	
	
	public void drawBar(SpriteBatch spriteBatch) {
	
		spriteBatch.begin();
		
        spriteBatch.draw(createTexture(barColor), bar.x, bar.y, bar.width, bar.height);
		TextDraw.draw(spriteBatch, text);
		
		spriteBatch.end();
		
	}

	
	public void setColor(Color color) {
		this.text.getFont().setColor(color);
	}
	
	public void setStringText(String stringText) {
		text.setTextString(stringText);
	}


	public Region2d getBarRegion() {
		return barRegion;
	}
	
	
	
	public static BarWithText newBarWithText(FloatCoordinates widthAndHeight ,FloatCoordinates barPosition,String stringText , Color barColor , Color textColor) {
		return new BarWithText(widthAndHeight, barPosition, stringText, barColor, textColor);
	}
	
	public void dispose() {
		text.getFont().dispose();
	}
	
	
}
