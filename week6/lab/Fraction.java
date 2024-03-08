/*
 * File:		Fraction.java
 * Author:		Ken Whitener
 * Modified By: kyle sunga
 * Date:		February 25, 2024
 * 
 * This file contains the definition of a class that represents a fraction.
 * 
 * TASK:	Complete the implementation of the Fraction class as described in the comments below.
 * 			Respond to each TO DO comment by implementing the described functionality.
 * 
 * 			Add your name to the "Modified By" line above.
 */

import static org.junit.jupiter.api.Assumptions.abort;

public class Fraction {

	// +============================+
	// | PRIVATE INSTANCE VARIABLES |
	// +============================+
	private int numerator;		// the numerator of the fraction
	private int denominator;

	// TO DO: add a private int instance variable for the denominator

	// +==============+
	// | CONSTRUCTORS |
	// +==============+

	/**
	 * Fraction constructor that takes 2 arguments
	 * 
	 * @param n	the numerator of the fraction
	 * @param d	the denominator of the fraction
	 */
	public Fraction(int n, int d) { 
		this.numerator = n;
		this.setDenominator(d);
		// TO DO: implement this constructor.
		// denominator should not be set to 0. If it is, set it to 1
		// but you may not duplicate validation code in the constructor
	}
	
	// TO DO: add a constructor that takes 1 argument (the numerator) and sets the denominator to 1
	public Fraction (int n){
		this.numerator = n;
		this.denominator = 1;

	}

	// +=========================+
	// | PUBLIC INSTANCE METHODS |
	// +=========================+

	/**
	 * Sets the numerator of the fraction
	 * @param n
	 */
	public void setNumerator(int n) {
		this.numerator = n;
		// TO DO: implement this method
	}

	/**
	 * 
	 * @return the numerator of the fraction
	 */
	public int getNumerator() {
		// TO DO: implement this method
		return this.numerator;	// replace this with the correct return value
	}

	// TO DO: add a method to set the denominator of the fraction
	//		  prevent the denominator from being set to 0.
	//		  Set it to 1 if so. Call this method from the constructor to validate the denominator.

	// TO DO: add a method to get the denominator of the fraction
	public int getDenominator(){
		return this.denominator;
	}
	public void setDenominator(int d){
		if (d > 0){
			this.denominator = d;
		}

	}

	/**
	 * Method to add a fraction to this fraction
	 * @return	nothing
	 */
	public void add(Fraction f) {
        // Find new numerator
        int newNumerator = this.numerator * f.denominator + f.numerator * this.denominator;
        // Find new denominator
        int newDenominator = this.denominator * f.denominator;

        // Reduce the new fraction (simplifying)
        int gcd = gcd(newNumerator, newDenominator); // Assuming you have a gcd method

        this.numerator = newNumerator / gcd;
        this.denominator = newDenominator / gcd;
    }
	

	// TO DO: add a void method to subtract a fraction from this fraction
	public void subtract(Fraction f) {
        // Find new numerator
        int newNumerator = this.numerator * f.denominator - f.numerator * this.denominator;
        // Find new denominator
        int newDenominator = this.denominator * f.denominator;

        // Reduce the new fraction (simplifying)
        int gcd = gcd(newNumerator, newDenominator); // Assuming you have a gcd method

        this.numerator = newNumerator / gcd;
        this.denominator = newDenominator / gcd;
    }
	// TO DO: add a void method to multiply this fraction by another fraction
	public void multiply(Fraction f) {
        // Multiply the numerators and denominators
        this.numerator *= f.numerator;
		this.denominator *= f.denominator;

        // Reduce the result to its simplest form
        reduce();
    }
	// TO DO: add a void method to divide this fraction by another fraction
	public void divide(Fraction f){
		this.numerator *= f.denominator;
		this.denominator *= f.numerator;
		reduce();
		
	}
	// TO DO: add a void method to reduce the fraction to lowest terms

	/**
	 * 
	 * @return the value of the fraction as a double
	 */
	public double toDecimal() {
		// TO DO: implement this method
		return (double) this.numerator / this.denominator;	// replace this with the correct return value
	}

	/**
	 * 
	 * @return the value of the fraction as a string "numerator/denominator"
	 */
	public String toString() {
		this.reduce();
		return this.numerator + "/" + this.denominator;

	}
	//chat gpt'd a reduce function to add it to my tostring function.
	//now i just have to find a way to carry the negative down into the output to pass the test
	public void reduce() {
		int gcdValue = gcd(this.numerator, this.denominator); // Use the gcd method to find the GCD of the numerator and denominator.
		this.numerator /= gcdValue; // Divide both numerator and denominator by the GCD to reduce the fraction.
		this.denominator /= gcdValue;
	
		// If the denominator is negative, move the negative sign to the numerator for standard form
		if (this.denominator < 0) {
			this.numerator *= -1;
			this.denominator *= -1;
		}
	}
	

	/**
	 * Determines if this fraction is equal to another fraction
	 * @param f	the fraction to compare to
	 * @return	true if the fractions are equal, false otherwise
	 */
	public boolean equals(Fraction f) {
		// Reduce this fraction
		int thisGcd = gcd(this.numerator, this.denominator);
		int reducedNumThis = this.numerator / thisGcd;
		int reducedDenThis = this.denominator / thisGcd;
	
		// Reduce the other fraction
		int otherGcd = gcd(f.numerator, f.denominator);
		int reducedNumOther = f.numerator / otherGcd;
		int reducedDenOther = f.denominator / otherGcd;
	
		// Compare the reduced forms
		return reducedNumThis == reducedNumOther && reducedDenThis == reducedDenOther;
	}
	

	/**
	 * Compares this fraction to another fraction to determine lexical ordering
	 * @param f	the fraction to compare to
	 * @return	-1 if this fraction is less than f, 0 if they are equal, 1 if this fraction is greater than f
	 */
	public int compareTo(Fraction f) {
		// Cross multiply to compare fractions without converting them to decimals
		
		
		long thisNumeratorLong = (long) this.numerator * f.denominator; //taking the numerator of 1st fraction multiplying 
		long otherNumeratorLong = (long) f.numerator * this.denominator; // taking numerator of 2nd fraction multiplying by first denominator
	
		// Compare the results of the cross multiplication
		if (thisNumeratorLong < otherNumeratorLong) {
			return -1;
		} else if (thisNumeratorLong > otherNumeratorLong) {
			return 1;
		} else {
			return 0;
		}
	}
	

	// +=================+
	// | PRIVATE METHODS |
	// +=================+

	// In practice we do not document private methods using javadoc comments
	// because they are not part of the public interface of the class.
	private int gcd(int a, int b) {
		// Ensure that a and b are positive for the algorithm to work
		a = Math.abs(a);
		b = Math.abs(b);
	
		while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
	
	
	
	
	

}
