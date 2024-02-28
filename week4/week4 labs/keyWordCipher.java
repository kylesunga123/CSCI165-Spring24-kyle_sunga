import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * date: Febuary 26
 * Author: Francis Kyle Sunga
 * class: CSCI2
 */
public class keyWordCipher {
    public static void main(String[] args) {
        // Encipher file
        String encodeKeyword = "Krryptos"; // used for debugging
        // String encodeKeyword = args[0];
        encodeKeyword = encodeKeyword.toUpperCase();
        String fileName = "galadriel.txt"; // used for debugging
        // String fileName = args[1];

        ArrayList<String> fileData = loadData(fileName);
        String keyword = prepareKeyword(encodeKeyword);
        String cipherAlphabet = generateCipherAlphabet(keyword);
        String toEncipher = convertArray(fileData);
        String encipheredString = encipher(cipherAlphabet, toEncipher);
        String encipheredWithSpaces = insertSpaces(encipheredString);
        writeToFile(encipheredWithSpaces, "KeywordEncrypted.txt");

        // Decipher
        ArrayList<String> encryptedFile = loadData("KeywordEncrypted.txt");
        String encipheredFromFile = convertArray(encryptedFile);
        String decipheredString = decipher(cipherAlphabet, encipheredFromFile);
        String decipheredWithSpaces = insertSpaces(decipheredString);
        writeToFile(decipheredWithSpaces, "KeywordDecrypted.txt");
    }

    public static String prepareKeyword(String str) {
        ArrayList<Character> uniqueChars = new ArrayList<>();   //array list to store chars 
        for (char letter : str.toCharArray()) {                 //loop through each char
            if (!uniqueChars.contains(letter)) {                //check if its in list
                uniqueChars.add(letter);                        //if not add to the list
            }
        }
        StringBuilder newWord = new StringBuilder();            //add new words
        uniqueChars.forEach(newWord::append);                   //append to string builder
        return newWord.toString();                              //return it as a string
    }

    public static String generateAlphabet() {
        StringBuilder alphabet = new StringBuilder();           //store everything
        for (char letter = 'A'; letter <= 'Z'; letter++) {      //starting at A loop until Z
            alphabet.append(letter);                            //add letters to stringbuilder
        }
        return alphabet.toString();                             //return as a string
    }
//CHAT GPT. USED IT TO GET A GENERAL IDEA. DIDNT END UP USING IT CREATED MY OWN INSTEAD
    //public static String generateCipherAlphabet(String keyword) {
        //String alphabet = generateAlphabet();                   //call function above
        //ArrayList<Character> alphabetArray = new ArrayList<>(); // list to store alphabet
        //for (char letter : alphabet.toCharArray()) {
            //alphabetArray.add(letter);
        //}

        //for (char keywordChar : keyword.toCharArray()) {
          //  alphabetArray.remove((Character) keywordChar);
        //}

        //StringBuilder cipherAlphabet = new StringBuilder();
        //alphabetArray.forEach(cipherAlphabet::append);          //append

        //return keyword + cipherAlphabet;                        //concatinate 
    //}


    public static String generateCipherAlphabet(String keyWord) {
        StringBuilder cipherAlpha = new StringBuilder(26); // alphabet only has 26 letters

        keyWord = prepareKeyWord(keyWord); // prepare a key word

        cipherAlpha.append(keyWord); // add to the cipher

        for (char letter = 'A'; letter < 'Z'; letter++) { // loops through each letter starting at a ending at z
            // Add letters that are not included in the keyword
            if (keyWord.indexOf(letter) < 0) {
                cipherAlpha.append(letter);
            }
        }
        return cipherAlpha.toString();

    }
    public static String prepareKeyWord(String str) {

        ArrayList<String> letters = new ArrayList<String>(); // non dup letters added to array list
        for (int index = 0; index < str.length(); ++index) { // loops through each character in string
            char letter = str.charAt(index); // get at current index
            String stringLetter = String.valueOf(letter); // convert to a string
            stringLetter = stringLetter.toLowerCase();
            boolean dupe = letters.contains(stringLetter); // checks for dupes
            // if character is not in array, add it to the array
            if (!dupe) {
                letters.add(stringLetter);
            }

        }
        StringBuilder newWord = new StringBuilder(); // new stringbuilder. strings w no dupes
        for (int i = 0; i < letters.size(); ++i) { // loop through each letter in letters
            String newLetter = letters.get(i); // getting a letter from the list
            newWord.append(newLetter); // append new letter into the new word
        }
        String strWithoutDuplicates = newWord.toString(); // turn into a string
        return strWithoutDuplicates;
    }

    public static String encipher(String cipherAlphabet, String toEncipher) {
        toEncipher = toEncipher.toUpperCase();
        String alphabet = generateAlphabet(); // call fucntion
        StringBuilder encipheredString = new StringBuilder(); //storage area

        for (char currentCharacter : toEncipher.toCharArray()) { //loop through
            String strCurrentChar = String.valueOf(currentCharacter);//turn to string
            int alphabetIndex = alphabet.indexOf(strCurrentChar); // get index

            if (alphabetIndex != -1) { //if in standard aplhabet 
                char encipheredCharacter = cipherAlphabet.charAt(alphabetIndex); //substitute with letter from cipher alphabet
                encipheredString.append(encipheredCharacter); //append 
            }
        }

        return encipheredString.toString(); 
    }
//same thing as the encipher
    public static String decipher(String cipherAlphabet, String encipheredFromFile) {
        String alphabet = generateAlphabet(); 
        StringBuilder decipheredString = new StringBuilder();

        for (char currentCharacter : encipheredFromFile.toCharArray()) {
            String currentChar = String.valueOf(currentCharacter);
            int cipherAlphabetIndex = cipherAlphabet.indexOf(currentChar);

            if (cipherAlphabetIndex != -1) {
                char decipheredChar = alphabet.charAt(cipherAlphabetIndex);
                decipheredString.append(decipheredChar);
            }
        }

        return decipheredString.toString();
    }

    public static String insertSpaces(String encipheredString) {
        StringBuilder stringWithSpaces = new StringBuilder(encipheredString); //storage 
        for (int index = 5; index < stringWithSpaces.length(); index += 6) { //loop through at intervals of 6
            stringWithSpaces.insert(index, ' '); //add spaces at index
        }
        return stringWithSpaces.toString();
    }

    public static void writeToFile(String content, String fileName) {
        String[] lines = content.split(" ");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Problem writing to file");
        }
    }

    public static ArrayList<String> loadData(String fileName) {
        ArrayList<String> data = new ArrayList<>();
        try {
            File inputFile = new File(fileName);
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                data.add(line);
            }
            fileScanner.close();
        } catch (IOException ioe) {
            System.out.println("File does not exist");
        }
        return data;
    }

    public static String convertArray(ArrayList<String> fileData) {
        StringBuilder fileContents = new StringBuilder();
        for (String line : fileData) {
            fileContents.append(line);
        }
        return fileContents.toString();
    }
}
