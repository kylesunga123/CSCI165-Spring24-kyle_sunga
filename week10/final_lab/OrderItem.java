/* Kyle Sunga
 * CSCI165
 * april 8 , 2024
 */

import java.lang.Math;

public class OrderItem {
    private MenuItem item;
    private int quantity;

    /**
     * Constructs an order item with a specified quantity of a menu item.
     * Creates a deep copy of the provided MenuItem to ensure encapsulation.
     * @param item the menu item consisting of name, price, and calories
     * @param quantity the quantity of the specific menu item being ordered
     */
    public OrderItem(MenuItem item, int quantity) {
        // Assuming MenuItem's constructor properly copies data if needed for immutability
        this.item = new MenuItem(item.getName(), item.getPrice(), item.getCalories());
        this.quantity = quantity;
    }

    /**
     * Updates the quantity of this order item. The change can increase or decrease the quantity.
     * The change is not applied if it would reduce the quantity below zero.
     * @param deltaQuantity the number to adjust the quantity by (positive to increase, negative to decrease)
     */
    public void updateQuantity(int deltaQuantity) {
        if (!(deltaQuantity < 0 && Math.abs(deltaQuantity) > this.quantity)) {
            this.quantity += deltaQuantity;
        }
    }

    /**
     * Returns a formatted string for a receipt that includes the item's name, price, calories, and quantity.
     * @return a formatted string suitable for receipt display
     */
    public String toReceiptString() {
        return String.format("%-32s $%-10.2f %-15d %-10d", item.getName(), item.getPrice(), item.getCalories(), quantity);
    }

    /**
     * Returns a new copy of the MenuItem to ensure encapsulation is not violated.
     * @return a copy of the MenuItem
     */
    public MenuItem getMenuItem() {
        return new MenuItem(item.getName(), item.getPrice(), item.getCalories());
    }

    /**
     * Returns the current quantity of this order item.
     * @return the current quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Provides a string representation of the order item, including the underlying menu item details and quantity.
     * @return a descriptive string of the order item
     */
    @Override
    public String toString() {
        return item.toString() + ", Quantity: " + quantity;
    }

    /**
     * Checks for deep equality between this OrderItem and another object.
     * Two OrderItems are considered equal if they have the same MenuItem and quantity.
     * @param other the object to compare with this OrderItem
     * @return true if the objects are the same or equivalent, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        OrderItem otherOrderItem = (OrderItem) other;
        return item.equals(otherOrderItem.item) && this.quantity == otherOrderItem.quantity;
    }
}
