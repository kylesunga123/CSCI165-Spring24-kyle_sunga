/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */
public class Driver {
    public static void main(String[] args) {
        // Initialize default employee using no-argument constructor
        Employee defaultEmployee = new Employee();
        System.out.println("Default Employee using no-argument constructor:");
        System.out.println(defaultEmployee);

        // Initialize employee using personal details
        Date dob = new Date(80, 5, 5); // Example DOB: June 5, 1980
        Person personDetails = new Person("Alice", "Johnson", "1234567890", dob);
        Date hireDate = new Date(); // Use current date for hire date
        Employee detailedEmployee = new Employee(personDetails, hireDate, 102, "Marketing");
        System.out.println("\nDetailed Employee using Person details:");
        System.out.println(detailedEmployee);

        // Initialize employee using just first and last name
        Employee simpleEmployee = new Employee("Bob", "Smith");
        System.out.println("\nSimple Employee using first and last name:");
        System.out.println(simpleEmployee);

        // Using the copy constructor to create a copy of the detailed employee
        Employee copyOfDetailedEmployee = new Employee(detailedEmployee);
        System.out.println("\nCopy of Detailed Employee:");
        System.out.println(copyOfDetailedEmployee);

        // Comparing the original and the copy using equals method
        System.out.println("\nComparing original and copy of Detailed Employee:");
        System.out.println("Are they equal? " + detailedEmployee.equals(copyOfDetailedEmployee));

        // Modify the copy and compare again
        copyOfDetailedEmployee.setId(103); // Changing the ID
        System.out.println("\nAfter modifying the copy's ID:");
        System.out.println("Are they equal? " + detailedEmployee.equals(copyOfDetailedEmployee));

        // customer class
        Customer customerOne = new Customer();
        System.out.println("\033[32mNo argument Customer:\033[0m\n" + customerOne);
        System.out.println();

        // Creating a customer with a linked Person object and specific hire date
        Person personOne = new Person("Toby", "Sunga", "0987654321", new Date());
        Date hireDateC2 = new Date(4,19,2024);
        Customer customerTwo = new Customer(personOne, hireDateC2, "1234");
        System.out.println("\033[32mCustomer Two:\033[0m\nParameter One: PersonOne(Composition)\nParameter Two: Hire Date\nParameter Three: ID\n" + customerTwo);
        System.out.println();

        // Detailed customer creation with explicit data
        Date c3Birthday = new Date(2,13,2011);
        Date hireDateC3 = new Date(03,06,2024);
        Customer DUCKY = new Customer("Donald", "Duck", "1122334455", c3Birthday, hireDateC3, "1224");
        System.out.println("\033[32mCustomer Three (Detailed Information):\033[0m\n" + DUCKY);


    }
}
