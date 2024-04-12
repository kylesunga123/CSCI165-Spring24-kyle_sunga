import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<MenuItem> menuItems;
    private static ArrayList<OrderItem> shoppingCart;
    private static Scanner scanner = new Scanner(System.in);
    private static Customer customer;

    public static void main(String[] args) {
        System.out.println("Welcome to Kyle's Food Truck, Please look at the menu below\n");
        
        String orderAgain = "Y";
        while (orderAgain.equalsIgnoreCase("Y")) {
            menuItems = loadMenuItems("products.txt");
            shoppingCart = new ArrayList<>();
            printMenu();

            System.out.println("Please enter your full name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your email address:");
            String email = scanner.nextLine();
            System.out.println("Please enter your phone number:");
            String phone = scanner.nextLine();

            phone = validatePhoneNumber(phone);
            customer = new Customer(name, email, phone);
            LocalDate today = LocalDate.now();
            Date orderDate = new Date(today.getMonthValue(), today.getDayOfMonth(), today.getYear());

            takeOrders();
            Order order = new Order(customer, orderDate, shoppingCart, "RECIEPT.NO" + System.currentTimeMillis()); //recipet numebr
            System.out.println(order.toString());
            order.writeToFile();

            System.out.println("Would you like to place another order? : (Y/N)");
            orderAgain = scanner.nextLine();
            orderAgain = validateOrderAgainInput(orderAgain);
        }
        scanner.close();
    }

    private static String validatePhoneNumber(String phone) {
        return phone.matches("\\d{10}") ? phone : "unknown";
    }

    private static String validateOrderAgainInput(String input) {
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
            System.out.println("Please enter \"Y\" if you would like to order again, or \"N\" if you do not want to place another order");
            input = scanner.nextLine();
        }
        return input;
    }

    private static void takeOrders() {
        while (true) {
            System.out.println("Please enter the item number and quantity of the item(s) you want to order. then press 0 to complete your order:");
            int itemNum = Integer.parseInt(scanner.nextLine());
            if (itemNum == 0) break;
            if (itemNum < 1 || itemNum > menuItems.size()) {
                System.out.println("Invalid item number. Please enter a number between 1 and " + menuItems.size());
                continue;
            }

            MenuItem selectedItem = menuItems.get(itemNum - 1);
            System.out.println("Please enter the quantity of " + selectedItem.getName() + " you would like to order: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantity > 0) {
                shoppingCart.add(new OrderItem(selectedItem, quantity));
            } else {
                System.out.println("Invalid quantity. Please enter a quantity greater than 0.");
            }
        }
    }

    public static ArrayList<MenuItem> loadMenuItems(String filename) {
        ArrayList<MenuItem> items = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",", 3);
                items.add(new MenuItem(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return items;
    }

    private static void printMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println("Menu Item " + (i + 1) + ": " + item);
        }
    }
}
