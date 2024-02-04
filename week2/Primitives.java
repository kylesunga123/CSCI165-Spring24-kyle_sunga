public class Primitives{
    public static void main(String[] args) {
        System.out.printf("Hello %s?%n", "Kyle");
        // byte
        byte myByte = 0;
        System.out.printf("Byte: %d%n", myByte);
        //short
        short myShort = 0;
        System.out.printf("Short: %d%n", myShort);
        //int
        int myInt = 0;
        System.out.printf("Int: %d%n", myInt);
        //long
        long myLong = 0L;
        System.out.printf("long: %d%n", myLong);
        //float 
        float myFloat = 1.00f;
        System.out.printf("float: %.2f%n", myFloat);
        //double
        double myDouble = 1.2345d;
        System.out.printf("double: %.4f%n", myDouble);
        //char
        char myChar = 'K';
        System.out.printf("char: %c%n", myChar);
        //boolean
        boolean myBool = false;
        System.out.printf("bool: %b%n", myBool);
        
        // char and num literals
        char charliteral = 64;
        System.out.println("character literal: " + charliteral);
        char numliteral = 'H';
        System.out.println("numeral literal: " + numliteral);
       
        //widening byte to short
        byte byteValue = 42;
        short shortValue = byteValue;
        System.out.println("original byte value: " + byteValue);
        System.out.println("widened short value:" + shortValue);
        
        // narrowing short to byte
        double doubleValue = 123.455;
        float floatValue = (float) doubleValue;
        System.out.println("original double value" + doubleValue);
        System.out.println("narrowed float value: " + floatValue);

    
        //i used chat gpt for this section. simply just asking what time minimum and max values would be
        int MIN_VALUE = Integer.MIN_VALUE;
        System.out.println("Minimum Value: " + MIN_VALUE);
        int MAX_VALUE = Integer.MAX_VALUE;
        System.out.println("Maximum Value: " + MAX_VALUE);

        //long max and min values
        long min = Long.MIN_VALUE;
        System.out.println("Minimum Value Long: " + min);
        long max = Long.MAX_VALUE;
        System.out.println("Maximum Value Long: " + max);

        int arg = Integer.parseInt(args[0]);
        System.out.println("The square of" + arg + "is: " + Math.pow(arg,2));
        int cube = Integer.parseInt(args[0]);
        System.out.println("The cube of" + cube + "is: " + Math.pow(cube,3));

        // #6
        int divident = Integer.parseInt(args[1]);
        int divisor = Integer.parseInt(args[2]);
        System.out.println("Floor Division: " + Math.floorDiv(divident,divisor));
        System.out.println("Floor Modulus: " + Math.floorDiv(divident,divisor));






    }
}