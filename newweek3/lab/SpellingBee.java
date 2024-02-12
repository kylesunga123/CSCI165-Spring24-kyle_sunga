
/*
* File: SpellingBee.java
* ----------------------
* This program contains the starter file for the SpellingBee application.
*
* Your work will all go here
*
* BE SURE TO CHANGE THIS COMMENT WHEN YOU COMPLETE YOUR SOLUTION.
*
* to run this app, at the terminal, type:
*  javac SpellingBee.java
*  java SpellingBee
*/
 
import java.awt.Color;  // import the Color class
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
 
public class SpellingBee {
    
    public void run() {
        // create a new SpellingBeeGraphics object. Use this to call methods to add fields and buttons
        sbg = new SpellingBeeGraphics();
 
        /*
         *  WORKFLOW:
         *  ========
         * 1. Add a field or button depending on the need: sbg.addField or sbg.addButton
         * 2. Define the action that should be taken when the field or button is used
         * 3. The action will then be defined as a method with the same name
         * 4. Add the action to the field or button
         *
         * Below are two examples of how to add a field and a button
         */
 
        // add a new text field with the name "Puzzle" and the action "puzzleAction"
        // "puzzleAction" should be defined as a method that takes a string as a parameter
        sbg.addField("Puzzle", (s) -> puzzleAction(s));
 
        sbg.addField("Guess Word", (s) -> guessWordAction(s));
		
        // add a new Button with the name "Solve" and the action "solveAction"
        // "solveAction" should be defined as a method that takes no parameters
        sbg.addButton("Solve", (s) -> solveAction());
		sbg.addButton("shuffle", (s) -> shuffleAction()); //shuffle button for task 5
		
    }
 
    private void guessWordAction(String s){
        testWord(s); //i just added the test words function to my guess words action. makes a life a lot easier
		//sbg.showMessage("Correct!");

		//sbg.showMessage("Invalid Word", Color.RED);
    }
    // define the puzzleAction method that will execute when
    // you hit "ENTER" after clicking in the "Puzzle" field
    // The contents of the field will be automatically passed to the method as a string
    private void puzzleAction(String s) {
        // sbg.showMessage("puzzleAction is not yet implemented", Color.RED);
		sbg.clearWordList(); //clear the world list when adding a new puzzle
        if(isValidPuzzle(s)) sbg.setBeehiveLetters(s);
        else sbg.showMessage("Invalid Puzzle", Color.RED);
    }
 
    private boolean isValidPuzzle(String puzzle) {
        if(puzzle.length() != 7) return false;                  // handle length rule
 
        for(int index = 0; index < puzzle.length(); ++index){   // handle letter rule
            if(!Character.isLetter( puzzle.charAt(index))) return false;
            for(int j = index + 1; j < puzzle.length(); ++j){           // check to see if next character matches current character (handles duplicates)
                if(puzzle.charAt(index) == puzzle.charAt(j)) return false;
        
            }
 
        }
 
        return true; // puzzles passes all rules, is valid
 
    }
    // define the solveAction method that will execute when
    // you click the "Solve" button. It does not get the contents of the PUZZLE field
    // but you can change this if you'd like
    private void solveAction() {
       ArrayList<String> dictionary = readDictionary(path); //read dict file
	   int wordCount = 0; //counter
	   int score = 0; //valid score accumalatwr 

	   for (String word : dictionary) { //iterate through each word in dict
		int output = testWord(word); //test if word is valid and add score
		if (output > 0) { //is word is valid add to word count and score
			score += output;
			wordCount++;
		}

	   }
	   sbg.showMessage(wordCount + " words; " + score + "points"); 
    }
    private int testWord(String word) {  //test words was very challenging and buggy at first. I did use chat gpt for this portion
		int scoreVal = 0;   
		String beehiveLetters = sbg.getBeehiveLetters(); //get beehive letters
		
		//Check length requirement
		if (word.length() < 4) { 
			sbg.showMessage("Invalid Word", Color.RED); //error message. if word length is less than 4
			return 0;
		}
	
		//Ensure word contains center letter
		word = word.toUpperCase();
		if (!word.contains("" + beehiveLetters.charAt(0))) {
			sbg.showMessage("Invalid Word", Color.RED); //invalid if doesnt contail center letter
			return 0;
		}
	
		//Ensure all characters in word are beehive letters and in the dictionary
		HashSet<Character> bonusSet = new HashSet<Character>();
		for (int i = 0; i < word.length(); i++) {
			if (!beehiveLetters.contains("" + word.charAt(i))) {
				sbg.showMessage("Invalid Word", Color.RED); //error for words outside the beehive
				return 0;
			}
			bonusSet.add(word.charAt(i));
		}
	
		ArrayList<String> dictionary = readDictionary(path);//read dict to see if word is in there
		if (!dictionary.contains(word.toLowerCase())) { //lowercasing the word thats displayed
			sbg.showMessage("Not in Dictionary", Color.RED); //if words not in dict display it
			return 0;
		}
	
		if (word.length() == 4)//calculate score based on score length
			scoreVal += 1;
		else
			scoreVal += word.length();
	
		if (bonusSet.size() == 7) {//add word with score and color
			scoreVal += 7;
			sbg.addWord(word.toLowerCase() + " (" + scoreVal + ")", Color.BLUE); //if blue it contains all 7 letters
		} else {
			sbg.addWord(word.toLowerCase() + " (" + scoreVal + ")"); //else. display in original color
		}
	
		return scoreVal;
	}
	
	
    
 
    /* Constants */
    // The name of the file containing the puzzle dictionary
    private static final String path = "EnglishWords.txt";
    
    private ArrayList<String> readDictionary(String name) { //array list stores words from dict 
        ArrayList<String> output = new ArrayList<String>();
        try {
            File dictFile = new File(name); //file representating the dict file
            Scanner reader = new Scanner(dictFile); //scanner reads stuff in dict file
            while (reader.hasNextLine()) { //iterate through each line
                String wordFromDic = reader.nextLine(); //read next line from dict file
                output.add(wordFromDic);//add word to array
            }
			reader.close();//always close file. i actually forgot to do that
        } catch (FileNotFoundException e) {
            System.out.println("File not found."); // file not found
        }
 
        return output;
    }
	
	// shuffle method
private void shuffleAction() {
    
    String beehiveLetters = sbg.getBeehiveLetters();//get arrangemts from hexagon
    ArrayList<Character> letters = new ArrayList<Character>();//store letters when shuffling
    char centerLetter = beehiveLetters.charAt(0);//extract center letter from index0
    letters.add(centerLetter);// add center letter to list
    for (int i = 1; i < beehiveLetters.length(); i++) { //extract add remaininf letters to list
        letters.add(beehiveLetters.charAt(i));
    }
    Collections.shuffle(letters.subList(1, letters.size()));//shuffle remaining outside letters
    StringBuilder shuffledString = new StringBuilder();//shuffleded arangements if letters
    for (char letter : letters) {//aopopend letter to string builder
        shuffledString.append(letter);
    }

    
    sbg.setBeehiveLetters(shuffledString.toString());//set beehive letters to shuffled arrange,ents
}

// method to handle player guessing words
// You can add your implementation for word guessing here.


	

		
 
    /* Private instance variables */
    private SpellingBeeGraphics sbg;    // no instance created yet, just scoped the reference variable
 
    /* Startup code */
    public static void main(String[] args) {    // application starts here
        SpellingBee sb = new SpellingBee();
        sb.run();// call the run method (defined below)
    }
}

 