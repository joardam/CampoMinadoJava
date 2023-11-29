package com.mygdx.game.states.gameModeState.gameEndlessMode;

import java.io.BufferedReader;
import java.io.IOException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class SaveToScoreBoardManager {
  

    private String fileName = "scoreBoard.txt";
    private FileHandle fileHandle = Gdx.files.local(fileName);

    public void ifDontExistCreate() {
    	if (!fileHandle.exists()) {
            fileHandle.writeString("", false);
            
        } else {
            //pass
        }
    }
    
    public void publishName(String username,int difficulty, int points) {
    	if (username.strip().isEmpty()) {
    		username = "null";
    	}
    	
    	
    	ifDontExistCreate();
    	int counter = countLines();
    	if(counter == 0) {
    		 String newLine = String.format("%s %d %d", username, difficulty, points);
    		 fileHandle.writeString(newLine + "\n", true);
    	}
    	else {
    		
    		int usersSameDifficulty = countUsersSameDifficulty(difficulty);
    		
    		 if (usersSameDifficulty >= 5) {
    			 if (isNewScoreGreater(difficulty, points)) {
    	              
    	                removeOldestLowestScore(difficulty);
    	              
    	                String newLine = String.format("%s %d %d", username, difficulty, points);
    	                fileHandle.writeString(newLine + "\n", true);
    	            
    			 }
    		 } 
    			 
    		 else {
    			 String newLine = String.format("%s %d %d", username.strip(), difficulty, points);
    	         fileHandle.writeString(newLine + "\n", true);
    		 }
    		
    		
    	}
    
    	
    	
    }
    
    private int countLines() {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            while (reader.readLine() != null) {
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
    
    private int countUsersSameDifficulty(int difficulty) {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                if (parts.length >= 2) {
              
                    int lineDifficulty = Integer.parseInt(parts[1]);
               
                    if (lineDifficulty == difficulty) {
                        counter++;
                    }
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return counter;
    }
    
    
    
    private boolean isNewScoreGreater(int difficulty, int newScore) {
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            String line;
            int lowestScore = Integer.MAX_VALUE;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    int lineDifficulty = Integer.parseInt(parts[1]);
                    int score = Integer.parseInt(parts[2]);
                    if (lineDifficulty == difficulty && score < lowestScore) {
                        lowestScore = score;
                    }
                }
            }
            reader.close();
            return newScore > lowestScore;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void removeOldestLowestScore(int difficulty) {
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            StringBuilder newContent = new StringBuilder();
            String line;
            String oldestLowestScoreLine = "";
            int lowestScore = Integer.MAX_VALUE;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    int lineDifficulty = Integer.parseInt(parts[1]);
                    int score = Integer.parseInt(parts[2]);
                    if (lineDifficulty == difficulty && score < lowestScore) {
                        lowestScore = score;
                        oldestLowestScoreLine = line;
                    }
                }
                newContent.append(line).append("\n");
            }
            reader.close();
            newContent.replace(newContent.indexOf(oldestLowestScoreLine), newContent.indexOf(oldestLowestScoreLine) + oldestLowestScoreLine.length() + 1, "");
            fileHandle.writeString(newContent.toString(), false);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
}


    
    
    
    

