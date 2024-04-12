/*
 * Kyle Sunga
 * April 9, 2024
 * CSCI 2
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Order {
    private Customer customer;
    LocalDate today = LocalDate.now();
    Date currentDate = new Date(today.getMonthValue(), today.getDayOfMonth(), today.getYear());
    private ArrayList<OrderItem> cart;
    private String numInv;

    /**
     * Order constructor to set all fields
     * 
     * @param customer   customer
     * @param currentDate     current date
     * @param cart  list of items ordered by customer
     * @param numInv based on the date and the customer's name part of
     *                      reciept
     */
    public Order(Customer customer, Date currentDate, ArrayList<OrderItem> cart, String numInv) {
        this.customer = new Customer(customer.getName(), customer.getEmail(), customer.getPhone());
        this.currentDate = new Date(currentDate.getMonth(), currentDate.getDay(), currentDate.getYear());
        this.cart = cart;
        this.numInv = numInv;

    }

    /**
     * Method to add a quantity of one single item to the cart. If the item already
     * exists in the cart, the quantity will be increased
     * 
     * @param orderItem the menu item
     */
    public void addItem(OrderItem orderItem) {
        cart.add(orderItem);
    }

    /**
     * Overloaded method which adds a specified quantity of an item to the cart if
     * the item already exists the quantity should be increased
     * 
     * @param item     the menu item
     * @param quantity the quantity
     */
    public void addItem(MenuItem item, int quantity) {
        OrderItem orderItem = new OrderItem(item, quantity);
        addItem(orderItem);
    }

    public void writeToFile() {
        String fileName = numInv + ".txt";
        try (PrintWriter out = new PrintWriter(fileName)) {
            // call toString()
            out.println(toString()); 
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Removes the first occurrence of the specified menu item from the order.
     * Iterates through the list of order items, and if the menu item matches
     * the specified item, it is removed from the shopping cart.
     *
     * @param item the menu item to be removed from the order
     * @return the order item that was removed, or null if the item was not found
     */
    public OrderItem removeItem(MenuItem item) {
        for (int index = 0; index < cart.size(); index++) {
            OrderItem orderItem = cart.get(index);
            if (orderItem.getMenuItem().equals(item)) {
                cart.remove(index);
                return orderItem;
            }
        }
        return null;
    }

    /**
     * Calculates the total price of all items in this order. The total is computed
     * by summing the product of each item's price and quantity.
     *
     * @return The total price of the order.
     */
    public double calculateTotal() {
        return cart.stream()
                .mapToDouble(orderItem -> orderItem.getMenuItem().getPrice() * orderItem.getQuantity())
                .sum();
    }

    /**
     * Calculates the tax on the order
     * 
     * @param total the total price of the order
     * @return the tax on the order
     */
    public double calculateTax(double total) {
        final double TAX_RATE = 0.0625;
        return total * TAX_RATE;
    }

    /**
     * Adds an order item to the shopping cart
     * 
     * @param orderItemOne the orderitem
     */
    public void cart(OrderItem orderItemOne) {
        cart.add(orderItemOne);
    }

    /**
     * Checks if the specified object is equal to this order.
     *
     * @param obj the object to compare with this order
     * @return true if the object is an order with the same properties, false
     *         otherwise
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // reference equality
            return true;
        if (!(obj instanceof Order)) // instance equality check. make sure object is not null
            return false;
        Order other = (Order) obj;
        return customer.equals(other.customer) &&
                currentDate.equals(other.currentDate) &&
                numInv.equals(other.numInv) &&
                cart.equals(other.cart);
    }

    /**
     * Compares this Order object with another Order object based on their order
     * dates.
     * Utilizes the compareTo method from the Date class to determine the ordering.
     *
     * @param otherOrder The other Order object to compare against this order.
     * @return 
     *         
     */
    public int compareTo(Order otherOrder) {
        return this.currentDate.compareTo(otherOrder.currentDate);
    }

//GETTERS AND SETTERS

    public Customer getCustomer() {
        return new Customer(customer.getName(), customer.getEmail(), customer.getPhone());
    }

    public Date getDate() {
        return new Date(currentDate.getMonth(), currentDate.getDay(), currentDate.getYear());
    }

    public ArrayList<OrderItem> getCart() {
        return new ArrayList<>(cart);
    }


    public String getNumInv() {
        return numInv;
    }
    /**
     * Creates an invoice number 
     *
     * @param customer The customer object
     * @param today    The date object
     * @return The invoice number
     */
    //used chatgpt for this part. added my own comments so i could understand.
    public String getInvoiceNumber(Customer customer, Date today) {
        //extract  initials from the customers name
        String[] nameParts = customer.getName().split(" ");
        String firstI = getInitials(nameParts[0]);
        String secondI = nameParts.length > 1 ? getInitials(nameParts[1]) : "";
    
        // compute a unique identifier based on the Unicode values of the initials
        int firstUnicode = nameParts[0].charAt(0);
        int lastUnicode = nameParts.length > 1 ? nameParts[1].charAt(0) : 0;
        int id = (firstUnicode + lastUnicode) * customer.getName().length();
    
        // format the date components to ensure proper length and order
        String formattedDate = formatDate(today);
    
        // assemble the invoice number from the components
        return firstI + secondI + id + formattedDate;
    }
   //chatgpt also gave me getinitials and format date to go along with the getinvoice number
    private String getInitials(String name) {
        return name.substring(0, Math.min(2, name.length())).toUpperCase();
    }
    
    private String formatDate(Date date) {
        return String.format("%02d%02d%d", date.getMonth() + 1, date.getDay(), date.getYear() + 1900);
    }


    /**
     * print items in shopping cart
     * 
     * @param cartForShopping
     */
    public void printUserOrder(ArrayList<OrderItem> cartForShopping) {
        for (OrderItem orderItem : cartForShopping) {
            System.out.println(orderItem.toReceiptString());
        }
    }

    

    /**
     * Method which formats the receipt of the order as a string. Can call this
     * method to print receipt to the termninal
     * Accepts no paramaters and returns void
     */
    public String generateReceipt() {
        // Create a new string builder to store receipt
        StringBuilder str = new StringBuilder();
    
        // Get the current time
        LocalTime timeRightNow = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String militaryTime = timeRightNow.toString();
    
        // Calculate the total price, tax, and order total
        double totalPrice = calculateTotal();
        double tax = calculateTax(totalPrice);
        double total = totalPrice + tax;
        double orderNoTax = total - tax;
    
        // Get customer details
        String name = customer.getName();
        String email = customer.getEmail();
        String phone = customer.getPhone();
    
        // Format receipt header
        str.append("RECEIPT\n\n");
        str.append("Customer: ").append(name).append("\n");
        str.append("Email address: ").append(email).append("\n");
        str.append("Phone Number: ").append(phone).append("\n\n");
    
        // Generate invoice number and date
        String invoice = getInvoiceNumber(customer, currentDate);
        String date = currentDate.toString();
    
        // Append invoice number, date, and time
        str.append("Invoice Number: ").append(invoice).append("\n");
        str.append("Date: ").append(date).append("\n");
        str.append("Time: ").append(militaryTime).append("\n\n");
    
        // Format item table header
        str.append("Item                             Price       Calories        Quantity\n");
        str.append("=====================================================================\n");
    
        // Loop through shopping cart and append each item's details
        for (OrderItem orderItem : cart) {
            str.append(orderItem.toReceiptString()).append("\n");
        }
    
        // Format subtotal, tax, and order total
        str.append("\n");
        str.append("=====================================================================\n");
        str.append("Subtotal              $").append(String.format("%.2f", orderNoTax)).append("\n");
        str.append("6.25% sales tax       $").append(String.format("%.2f", tax)).append("\n");
        str.append("Order Total           $").append(String.format("%.2f", total)).append("\n");
    
        // Convert string builder to a string and return
        return str.toString();
    }
    
}
