public class Initials {
    public static void main(String[] args) {
        String fullName = args[0];
        char firstName = fullName.charAt(0);
        int space = fullName.indexOf(" ");
        char lastName = fullName.charAt(space + 1);
        System.out.println(firstName + "." + lastName + ".");

        char letter = firstName;
        char letter2 = lastName;
        int unicodeValue2 = (int)letter2;
        int unicodeValue = (int)letter;
        System.out.println(letter + "=" + unicodeValue + "," + letter2 + "=" + unicodeValue2);

        int add1 = unicodeValue;
        int add2 = unicodeValue2;
        int sum = add1 + add2;
        System.out.println(add1 + "+" + add2 + "=" + sum);

        
        System.out.println("" + firstName + lastName);
        

    }
}