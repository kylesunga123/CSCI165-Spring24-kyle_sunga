import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * date: Febuary 26
 * Author: Francis Kyle Sunga
 * class: CSCI2
 */

public class rot {
    // public static void main(String[] args) {
    // String characterSet13 = rotCharacterSet(13);

    // System.out.println(characterSet13);

    // String characterSet47 = rotCharacterSet(47);

    // System.out.println(characterSet47);

    // }

    public static String rotCharacterSet(int number) {
        int rot47 = 33;
        int rot13 = 65;
        StringBuilder encoded47 = new StringBuilder();
        StringBuilder encoded13 = new StringBuilder();
        while (rot47 <= 126) {
            encoded47.append((char) rot47);
            rot47++;
        }
        while (rot13 <= 90) {
            encoded13.append((char) rot13);
            rot13++;
        }
        String result;
        if (number == 13) {
            result = encoded13.toString();
        } else {
            result = encoded47.toString();
        }
        return result;
    }

    public static String applyROT(String str, int number) {
        str = str.toUpperCase(); // set my string to upper case
        char[] wordArray = str.toCharArray(); // putting str into an arraw list returning an array of char
        for (int i = 0; i < wordArray.length; i++) {
            char currentChar = wordArray[i];

            if (Character.isLetter(currentChar)) {
                // Adjust the ASCII value based on the rotation number
                char base = (Character.isUpperCase(currentChar)) ? 'A' : 'a';
                wordArray[i] = (char) ((currentChar - base + number) % 26 + base);
            }
            // If the character is not a letter, leave it unchanged
        }

        // Convert the char array back to a string
        return new String(wordArray);

    }

    // file reader from my spelling bee lab. just copied and pasted changed
    // variabvle names so i wouldnt get confused
    public static ArrayList<String> loadData(String name) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File ifile = new File(name);
            Scanner reader = new Scanner(ifile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                data.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return data;
    }
    // appliocation #1 validations a,b,c,d.
    // public static void main(String[] args) {
    // Check if the correct number of command line arguments is provided
    // if (args.length != 3) {
    // System.out.println("Usage: java Rot <file_name> <e/d> <rotation_number>");
    // return;
    // String fileName = args[0];
    // String operation = args[1].toLowerCase(); // Convert to lowercase for
    // case-insensitivity
    // int rotationNumber = Integer.parseInt(args[2]);

    // ^^^^^ above was some code chat gpt game me. just a little push to get me in
    // the right direction

    public static void main(String[] args) {
        if (args.length != 3) { // validation A complete.
            System.out.println("not three agruments");// if the arg length is not 3
            return;
        }
        String fileName = args[0];
        
        String operation = args[1];
        operation = operation.toLowerCase();

        if (!operation.equals("e") && !operation.equals("d")) {
            System.out.println("invalid arg. not d or e");
            return;
        }
        //int number = Integer.parseInt(args[2]);
        int number = 13;
        if (number != 13 && number != 47) {
            System.out.println("invalid arg. ROT13 will be applied");
            return;
        }
        ArrayList<String> data = loadData(fileName);
        String name;

        if (operation.equals("e")) {
            String[] slicedfile = fileName.split("\\.", 2); // splittin file by the period
            name = slicedfile[0] + "_encrypted.txt";
        } else {
            String[] slicedfile = fileName.split("_", 2);
            name = slicedfile[0] + ".txt";
        }
        // if(operation.equals("d")){
        // if (fileName.contains("_encryypted")){
        // name = fileName.replaceFirst("_encrypted", "");
        // }
        // }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name));
            for (int index = 0; index < data.size(); ++index) {
                String line = data.get(index); // get each line in the array storing file data
                String result = applyROT(line, number); // apply ROT13 or ROT47 to each line
                writer.write(result + "\n"); // write the new line to the file and add a newline
            }
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Error writing to file");
        }

    }

}
