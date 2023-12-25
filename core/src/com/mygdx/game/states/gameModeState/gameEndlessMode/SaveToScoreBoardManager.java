package com.mygdx.game.states.gameModeState.gameEndlessMode;

import java.io.BufferedReader;
import java.io.IOException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class SaveToScoreBoardManager {
  

    private String fileNameEazy = "scoreEazy.txt";
    private String fileNameMedium = "scoreMedium.txt";
    private String fileNameHard = "scoreHard.txt";
    		
    		
    private FileHandle fileHandleEazy = Gdx.files.local(fileNameEazy);
    private FileHandle fileHandleMedium = Gdx.files.local(fileNameMedium);
    private FileHandle fileHandleHard = Gdx.files.local(fileNameHard);
    

    public void ifDontExistCreate(FileHandle fileHandle) {
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
    	
    	FileHandle fileHandle = null;
    	if(difficulty == 0) {
    		fileHandle = this.fileHandleEazy;
    	}
    	
    	if(difficulty == 1) {
    		fileHandle = this.fileHandleMedium;
    	}
    	
    	if(difficulty == 2) {
    		fileHandle = this.fileHandleHard;
    	}
    	ifDontExistCreate(fileHandle);
    	
    	int counter = countLines(fileHandle);
    	if(counter == 0) {
    		 String newLine = String.format("%s %d", username, points);
    		 fileHandle.writeString(newLine + "\n", true);
    	}
    	else {
    		
    		int usersSameDifficulty = countUsersSameDifficulty(fileHandle);
    		 if (usersSameDifficulty >= 5) {
    			 if (isNewScoreGreater(points , fileHandle)) {
    	              
    	                removeOldestLowestScore(fileHandle);
    	              
    	                String newLine = String.format("%s %d", username, points);
    	                fileHandle.writeString(newLine + "\n", true);
    	            
    			 }
    		 } 
    			 
    		 else {
    			 String newLine = String.format("%s %d", username.strip(), difficulty, points);
    	         fileHandle.writeString(newLine + "\n", true);
    		 }
    		
    		
    	}
    
    	
    	
    }
    
    private int countLines(FileHandle fileHandle) {
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
    
    private int countUsersSameDifficulty(FileHandle fileHandle) {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            String line;
            while ((line = reader.readLine()) != null) {
                   counter++;

                
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return counter;
    }
    
    
    
    private boolean isNewScoreGreater(int newScore , FileHandle fileHandle) {
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            String line;
            int lowestScore = Integer.MAX_VALUE;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    int score = Integer.parseInt(parts[1]);
                    if (score < lowestScore) {
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
    
    private void removeOldestLowestScore(FileHandle fileHandle) {
        try {
            BufferedReader reader = new BufferedReader(fileHandle.reader());
            StringBuilder newContent = new StringBuilder();
            String line;
            String oldestLowestScoreLine = "";
            int lowestScore = Integer.MAX_VALUE;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    int score = Integer.parseInt(parts[1]);
                    if (score < lowestScore) {
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


    
    
    
    

