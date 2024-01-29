package com.mygdx.collections;
import java.util.HashMap;

import com.mygdx.utils.RgbaColor;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.text.Text;
import com.mygdx.utils.FloatCoordinates;

public class TextCollection {
    private HashMap<String, Text> textMap = new HashMap<String, Text>();

    public TextCollection() {

    }

    public TextCollection(Object... args) throws CollectionException {
        

    	try {
	        int argIndexNow = 0;
	      
	        while(argIndexNow < args.length) {
	        
	        	
	        	
	        	if(!(args[argIndexNow] instanceof String)) {
	        		throw new CollectionException("(wrong Parameter , must me String)");
	        	}
	        	
	   
	        	boolean caseOfMoreStrings5Parameters = (args[argIndexNow] instanceof String) && !(argIndexNow + 5 >= args.length) && (args[argIndexNow + 5] instanceof String);
	        	boolean caseOfMoreStrings4Parameters = (args[argIndexNow] instanceof String) && !(argIndexNow + 4 >= args.length) && (args[argIndexNow + 4] instanceof String);
	          	boolean caseOfMoreStrings3Parameters = (args[argIndexNow] instanceof String) && !(argIndexNow + 3 >= args.length) && (args[argIndexNow + 3] instanceof String);
	        	boolean caseOfMoreStrings2Parameters = (args[argIndexNow] instanceof String) && !(argIndexNow + 2 >= args.length) && (args[argIndexNow + 2] instanceof String);
	      
	        	
	        	boolean condition2Parameters = (
	        			(argIndexNow + 2 >= args.length) || 
	        			(caseOfMoreStrings2Parameters));
	        	
	        	
	        	boolean condition3Parameters = (
	        			(argIndexNow + 3 >= args.length) || 
	        			(caseOfMoreStrings3Parameters));
	        	
	        	boolean condition4Parameters = (
	        			(argIndexNow + 4 >= args.length) || 
	        			caseOfMoreStrings4Parameters);
	        	
	        	boolean condition5Parameters = (
	        			(argIndexNow + 5 >= args.length) || 
	        			caseOfMoreStrings5Parameters);
	        	
	        	
	        	
	        	if(argIndexNow + 1 >= args.length ) {
	        		throw new CollectionException("String Parameter cannot be alone");
	        		
	        	}
	        	
	        	if(condition2Parameters && (argIndexNow + 3 >= args.length ) && !(args[argIndexNow + 3] instanceof RgbaColor)) {
	        		
	        		if(!(args[argIndexNow + 1] instanceof Integer)) {
	        			throw new CollectionException("(When using 2 parameters must be (String ,Integer)");

	        		}
	        		String stringId = (String) args[argIndexNow];
	        		int size = (int) args[argIndexNow + 1];
	        		
	        		addText(stringId,size);
	        		
	        		argIndexNow += 2;
	        		
	        	}
	        	
	        	else if(condition3Parameters) {
	        		if(     !(args[argIndexNow] instanceof String)  ||
	        				!(args[argIndexNow + 1] instanceof Integer) || 
	        				!(args[argIndexNow + 2] instanceof String)
	        				) {
	        			throw new CollectionException("(When using 3 parameters must be (String ,Integer ,String)");
	        		}
	        		
	        		String stringId = (String) args[argIndexNow];
	        		int size = (int) args[argIndexNow + 1];
	        		String stringText = (String) args[argIndexNow + 2];
	        		addText(stringId,size, stringText);
	        		
	        		argIndexNow += 3;
	        		
	        	}
	        	
	        	else if(condition4Parameters) {
	        		if(
	        						!(args[argIndexNow] instanceof String)  ||
	    	        				!(args[argIndexNow + 1] instanceof Integer) || 
	    	        				!(args[argIndexNow + 2] instanceof String) ||
	        						!(args[argIndexNow + 3] instanceof RgbaColor)
	        				) {
	        			throw new CollectionException("(When using 4 parameters must be (String ,Integer ,String , RgbaColor)");
	        			
	        		}
	        		String stringId = (String) args[argIndexNow];
	        		int size = (int) args[argIndexNow + 1];
	        		String stringText = (String) args[argIndexNow + 2];
	        		RgbaColor colors = (RgbaColor) args[argIndexNow + 3];
	        		addText(stringId,size, stringText);
	        		textMap.get(stringId).setColor(colors.getColor()[0],colors.getColor()[1],colors.getColor()[2],colors.getColor()[3]);
	        		
	        		argIndexNow += 4;
	        
	        	}
	        	
	        	else if(condition5Parameters) {
	        		if(
	        						!(args[argIndexNow]     instanceof String)  ||
	    	        				!(args[argIndexNow + 1] instanceof Integer) || 
	    	        				!(args[argIndexNow + 2] instanceof String)  ||
	        						!(args[argIndexNow + 3] instanceof RgbaColor) ||
	        						!(args[argIndexNow + 4] instanceof FloatCoordinates)
	        					
	        				) {
	        			throw new CollectionException("(When using 5 parameters must be (String ,Integer ,String , RgbaColor, FloatCoordinates)");
	        		}
	        	
	        		
	        		String stringId = (String) args[argIndexNow];
	        		int size = (int) args[argIndexNow + 1];
	        		String stringText = (String) args[argIndexNow + 2];
	        		RgbaColor colors = (RgbaColor) args[argIndexNow + 3];
	        		FloatCoordinates coordinates = (FloatCoordinates) args[argIndexNow + 4];
	        		
	        		addText(stringId,size, stringText);
	        		
	        		Text text = textMap.get(stringId);
	        		
	        		GlyphLayout layout = new GlyphLayout(text.getFont(), text.getTextString());

	        		float centerX = coordinates.getCoordinateX() - layout.width / 2;
	        		float centerY = coordinates.getCoordinateY() + layout.height / 2;

	        		
	        		
	        		
	        		text.setColor(colors.getColor()[0],colors.getColor()[1],colors.getColor()[2],colors.getColor()[3]);
	        		text.setTextPosition(centerX, centerY);
	        		
	        		argIndexNow += 5;
	        		
	        		
	        	}
	        	else {
	        		throw new CollectionException("Wrong Parameters");
	        	}
	        		        	
	        	
	        	
	        }
	        
	       
            
        } catch (CollectionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void addText(String stringId, int size) {
        Text text = new Text();
        text.setSize(size);
        text.initialize();
        textMap.put(stringId, text);
    }

    public void addText(String stringId, int size, String textString) {
        Text text = new Text();
        text.setSize(size);
        text.initialize();
        text.setTextString(textString);
        textMap.put(stringId, text);
    }
    
    public void setTextStringId(String stringId, String textString) {
    	Text text = textMap.get(stringId);
    	text.setTextString(textString);
    }

    public Text getText(String stringId) throws CollectionException {
        try {
            Text text = textMap.get(stringId);

            if (text == null) {
                throw new CollectionException("stringId not found: " + stringId);
            }

            return text;
        } catch (CollectionException e) {
            System.err.println("Error: " + e.getMessage());
            return null; 
        }
    }

    public HashMap<String, Text> getHashMap() {
        return this.textMap;
    }

    public void setColors(Object... args) throws CollectionException {
        try {
            if (args.length % 5 != 0) {
                throw new CollectionException("Not enough parameters per key. Each group of parameters should consist of a String and four float values.");
            }

            for (int i = 0; i < args.length; i += 5) {
                if (!(args[i] instanceof String) ||
                    !(args[i + 1] instanceof Float) ||
                    !(args[i + 2] instanceof Float) ||
                    !(args[i + 3] instanceof Float) ||
                    !(args[i + 4] instanceof Float)) {
                    throw new CollectionException("Wrong type. Each group of parameters should consist of a String and four float values.");
                }

                String stringId = (String) args[i];
                float x1 = (float) args[i + 1];
                float x2 = (float) args[i + 2];
                float x3 = (float) args[i + 3];
                float x4 = (float) args[i + 4];
                Text text = textMap.get(stringId);


                text.setColor(x1, x2, x3, x4);
            }
        } catch (CollectionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setTextPositions(Object... args) throws CollectionException {
        try {
            if (args.length % 3 != 0) {
                throw new CollectionException("Not enough parameters per key. Each group of parameters should consist of a String, a float for x, and a float for y.");
            }

            for (int i = 0; i < args.length; i += 3) {
                if (!(args[i] instanceof String) ||
                    !(args[i + 1] instanceof Float) ||
                    !(args[i + 2] instanceof Float)) {
                    throw new IllegalArgumentException("Wrong type. Each group of parameters should consist of a String, a float for x, and a float for y.");
                }

                String stringId = (String) args[i];
                float x = (float) args[i + 1];
                float y = (float) args[i + 2];
                Text text = textMap.get(stringId);

                

                text.setTextPosition(x, y);
            }
        } catch (CollectionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void disposeAll() {
        for (Text text : textMap.values()) {
            text.dispose();
        }
    }
   
    
    
    
}
