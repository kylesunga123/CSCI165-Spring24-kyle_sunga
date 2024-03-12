import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<MenuItem> menuItems = new ArrayList<>();
    private static ArrayList<MenuItem> userMenuItems = new ArrayList<>();
    private static String name, email, phone;
    private static Date date = new Date(2024, 3, 10); // Assuming the date is fixed for this example

    public static void main(String[] args) {
        loadMenuItems("products.txt");
        printMenu(menuItems); //print the menu 

        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter your first and last name:");
        name = scanner.nextLine();
        System.out.println("Please enter your email address:");
        email = scanner.nextLine();
        System.out.println("Please enter your phone number:");
        phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        System.out.println("How many items would you like to order?");
        int numItems = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter the Menu Item Number for item " + (i + 1) + ":");
            int itemNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (itemNumber >= 0 && itemNumber < menuItems.size()) {
                userMenuItems.add(menuItems.get(itemNumber));
            }
        }
        scanner.close(); //close scanner

        printOrder(userMenuItems, customer, date);
    }

    private static void loadMenuItems(String filename) { //load file 
        try (Scanner scanner = new Scanner(new File(filename))) { //new scanner
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(","); //add new menuitem to menuitem arraylist
                menuItems.add(new MenuItem(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    private static void printMenu(ArrayList<MenuItem> items) {
        System.out.println("Welcome to the Food Truck, see the menu below:\n");
        for (int i = 0; i < items.size(); i++) { //loop through 
            System.out.println("Menu Item " + (i + 1) + ": " + items.get(i));
        }
    }

    private static void printOrder(ArrayList<MenuItem> order, Customer customer, Date today) { 
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS); //local time
        double subtotal = order.stream().mapToDouble(MenuItem::getPrice).sum(); //calculater sub total
        double salesTax = subtotal * 0.0625; //getting sale tax
        double total = subtotal + salesTax;

        StringBuilder receipt = new StringBuilder();
        receipt.append("\nRECEIPT\n\n")
               .append("Customer: ").append(customer.getName()).append("\n")
               .append("Email: ").append(customer.getEmail()).append("\n")
               .append("Phone: ").append(customer.getPhone()).append("\n\n")
               .append("Invoice Number: ").append(getInvoiceNumber(customer, today)).append("\n")
               .append("Date: ").append(today).append("\n")
               .append("Time: ").append(currentTime).append("\n\n")
               .append("Item                             Price       Calories\n")
               .append("=====================================================\n");
        order.forEach(item -> receipt.append(item.toReceiptString()).append("\n"));
        receipt.append("\nTotal Calories: ").append(order.stream().mapToInt(MenuItem::getCalories).sum()).append("\n")
               .append("=====================================================\n")
               .append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n")
               .append("Sales Tax: $").append(String.format("%.2f", salesTax)).append("\n")
               .append("Total: $").append(String.format("%.2f", total)).append("\n");
        
        System.out.println(receipt);

        try (PrintWriter out = new PrintWriter("receipt.txt")) {
            out.println(receipt);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    private static String getInvoiceNumber(Customer customer, Date today) {
        String[] names = customer.getName().split(" "); //split full name
        String initials = names[0].substring(0, 2).toUpperCase() + names[1].substring(0, 2).toUpperCase(); //extract first 2 letters
        int unicodeSum = names[0].charAt(0) + names[1].charAt(0);    // Generate an ID  multiply  Unicode sum with  total length of  customer name
        int id = unicodeSum * customer.getName().length();
        return initials + id + today.getDay() + today.getMonth();
    }
}
