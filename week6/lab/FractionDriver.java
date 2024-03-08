/**
 * Kyle Sunga
 * March 5th, 2024
 * FractionDriver.java
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FractionDriver {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 0);
        System.out.println("Fraction 1 is 2/0. can't divide by 0 so this fraction is changed to: " + f1);
        Fraction f2 = new Fraction(16, 32);
        System.out.println("Fraction 2 is 16/32. reduced form is: " + f2);
        Fraction f3 = new Fraction(33, 99);
        System.out.println(
                "Fraction 3 is 33/99. reduced form is: " + f3 + ". Fraction as a decimal is: " + f3.toDecimal());
        Fraction f4 = new Fraction(-3, 8);
        System.out.println("Fraction 4 is: " + f4);
        System.out.println();
        System.out.println("here is some arithmetic:");
        f2.add(f3);
        System.out.println("Fraction 2 + Fraction 3 = " + f2);
        System.out.print("Fraction 2 is now: " + f2 + ". " + f2 + " multiplied by Fraction 3 will give: ");
        f2.multiply(f3);
        System.out.println(f2);
        System.out.print(f2 + " divided by Fraction 1 will give: ");
        f2.divide(f1);
        System.out.println(f2);
        System.out.print("Fraction 4 subtracted from Fraction 2 (" + f2 + "), will result in: ");
        f2.subtract(f4);
        System.out.println(f2);

        String fileName = "Fractions.txt";
        Fraction[] fractions = loadData(fileName);// load fractions from file into an array
        Fraction largestFraction = largestFraction(fractions); // largest fraction in the array
        System.out.println(largestFraction);
    }

    public static Fraction[] loadData(String fileName) {
        Fraction[] fractions = new Fraction[100];// array with max 100
        int index = 0;// Index for inserting fractions into the array

        try {
            File input_file = new File(fileName);
            Scanner file_scanner = new Scanner(input_file);
            while (file_scanner.hasNext()) {
                String line = file_scanner.nextLine();
                String[] sliced_line = line.split(",", 2);
                int numerator = Integer.parseInt(sliced_line[0]);
                int denominator = Integer.parseInt(sliced_line[1]);
                fractions[index] = new Fraction(numerator, denominator);
                index++; // increment the index

            }
            file_scanner.close(); // close scanner
        } catch (IOException ioe) {
            System.out.println("There was a problem reading in the fractions file");
        }
        return fractions;
    }

    public static Fraction largestFraction(Fraction[] fractions) {
        Fraction largestFraction = new Fraction(1, 1); // default fraction
        for (int index = 0; index < fractions.length; ++index) { // loop through index
            if (fractions[index].compareTo(largestFraction) > 0) {
                largestFraction = fractions[index]; // Update largestFraction to the current fraction if it is larger

            }
        }
        return largestFraction;
    }

}
