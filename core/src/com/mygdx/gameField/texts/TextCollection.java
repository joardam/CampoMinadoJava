package com.mygdx.gameField.texts;
import java.util.HashMap;

import com.mygdx.utils.RgbaColor;
import com.mygdx.utils.FloatCoordinates;

public class TextCollection {
    private HashMap<String, Text> textMap = new HashMap<String, Text>();

    public TextCollection() {

    }

    public TextCollection(Object... args) {
        try {
            if (args.length % 3 != 0 && args.length % 5 != 0) {
                throw new IllegalArgumentException("Parameters pattern must be (String, String, int) or (String, String, int, Color, FloatCoordinates)");
            }

            boolean not3Parameter = false;
            boolean not5Parameter = false;

            for (int i = 0; i < args.length; i += 3) {
                if (!(args[i] instanceof String) || !(args[i + 1] instanceof String) || !(args[i + 2] instanceof Integer)) {
                    not3Parameter = true;
                    break;
                }
            }

            if (not3Parameter) {
                for (int i = 0; i < args.length; i += 5) {
                    if (!(args[i] instanceof String) || !(args[i + 1] instanceof String) || !(args[i + 2] instanceof Integer) ||
                        !(args[i + 3] instanceof RgbaColor) || !(args[i + 4] instanceof FloatCoordinates)) {
                        throw new IllegalArgumentException("Parameters types must be (String, String, int) or (String, String, int, Color, FloatCoordinates)");
                    }
                }
            }

            if (!not3Parameter) {
                not5Parameter = true;
                for (int i = 0; i < args.length; i += 3) {
                    String stringId = (String) args[i];
                    String textString = (String) args[i + 1];
                    int size = (int) args[i + 2];

                    addText(stringId, textString, size);
                }
            }

            if (!not5Parameter) {
                for (int i = 0; i < args.length; i += 5) {
                    String stringId = (String) args[i];
                    String textString = (String) args[i + 1];
                    int size = (int) args[i + 2];
                    RgbaColor color = (RgbaColor) args[i + 3];
                    FloatCoordinates coordinates = (FloatCoordinates) args[i + 4];

                    addText(stringId, textString, size);
                    Text text = textMap.get(stringId);

                   

                    text.setColor(color.getColor()[0], color.getColor()[1], color.getColor()[2], color.getColor()[3]);
                    text.setTextPosition(coordinates.getCoordinateX(), coordinates.getCoordinateY());
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void addText(String stringId, int size) {
        Text text = new Text();
        text.setSize(size);
        text.initialize();
        textMap.put(stringId, text);
    }

    public void addText(String stringId, String textString, int size) {
        Text text = new Text();
        text.setSize(size);
        text.initialize();
        text.setTextString(textString);
        textMap.put(stringId, text);
    }

    public Text getText(String stringId) {
        try {
            Text text = textMap.get(stringId);

            if (text == null) {
                throw new IllegalArgumentException("stringId not found: " + stringId);
            }

            return text;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return null; 
        }
    }

    public HashMap<String, Text> getHashMap() {
        return this.textMap;
    }

    public void setColors(Object... args) {
        try {
            if (args.length % 5 != 0) {
                throw new IllegalArgumentException("Not enough parameters per key. Each group of parameters should consist of a String and four float values.");
            }

            for (int i = 0; i < args.length; i += 5) {
                if (!(args[i] instanceof String) ||
                    !(args[i + 1] instanceof Float) ||
                    !(args[i + 2] instanceof Float) ||
                    !(args[i + 3] instanceof Float) ||
                    !(args[i + 4] instanceof Float)) {
                    throw new IllegalArgumentException("Wrong type. Each group of parameters should consist of a String and four float values.");
                }

                String stringId = (String) args[i];
                float x1 = (float) args[i + 1];
                float x2 = (float) args[i + 2];
                float x3 = (float) args[i + 3];
                float x4 = (float) args[i + 4];
                Text text = textMap.get(stringId);


                text.setColor(x1, x2, x3, x4);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setTextPositions(Object... args) {
        try {
            if (args.length % 3 != 0) {
                throw new IllegalArgumentException("Not enough parameters per key. Each group of parameters should consist of a String, a float for x, and a float for y.");
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
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void disposeAll() {
        for (Text text : textMap.values()) {
            text.dispose();
        }
    }
}
