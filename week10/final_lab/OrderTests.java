/*Kyle Sunga
 * CSCI2
 * April 8, 2024
*/



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;


public class OrderTests {
    Order orderOne;
    MenuItem menuItemOne, menuItemTwo;   // menu items
    Date dateOne;
    Customer customerOne;
    OrderItem orderItemOne;
    String msg;                          // test message

    @BeforeEach
    public void setup() {
        dateOne = new Date(4, 8, 2024);
        customerOne = new Customer("Kyle", "Kyle_Sunga@gmail.com", "2014437054");
        orderOne = new Order(customerOne, dateOne, new ArrayList<OrderItem>(), "0000");
    }

    @Test
    public void testOrderPrivacyProtection() {
        Customer customerOneCopy = orderOne.getCustomer();
        msg = "The states are not the same. They should be";
        assertTrue(customerOneCopy.equals(customerOne), msg);
        msg = "The identities are the same. They should not be";
        assertFalse(customerOneCopy == customerOne, msg);

        // Test Date privacy
        Date dateCopy = orderOne.getDate();
        msg = "The states are not the same. They should be";
        assertTrue(dateCopy.equals(dateOne), msg);
        msg = "The identities are the same. They should not be";
        assertFalse(dateCopy == dateOne, msg);
    }

    @Test
    public void testAddItem(){
        menuItemOne = new MenuItem("Burger", 5.99, 700);
        orderItemOne = new OrderItem(menuItemOne, 2);
        orderOne.addItem(orderItemOne);

        // check that the shopping cart contains the added item
        assertTrue(orderOne.getCart().contains(orderItemOne));

        // check that the quantity is correct
        assertEquals(2, orderOne.getCart().get(0).getQuantity());

        assertEquals(11.98, orderOne.calculateTotal());
    }

    @Test
    public void testShoppingCartPrivacyProtection() {
        // Add an item to the order
        menuItemOne = new MenuItem("Burger", 5.99, 700);
        orderItemOne = new OrderItem(menuItemOne, 2);
        orderOne.addItem(orderItemOne);
    
        // Get the shopping cart and modify it
        ArrayList<OrderItem> shoppingCartCopy = orderOne.getCart();
        shoppingCartCopy.clear();
    
        // Check that the original shopping cart is unchanged
        assertEquals(1, orderOne.getCart().size(), "The original shopping cart should be unchanged");
    
        // Check that the shopping cart copy is a clone
        assertNotSame(shoppingCartCopy, orderOne.getCart(), "The shopping cart copy should be a clone, not the same object");
    }
    
    @Test
    public void testCalculateTax() {
        menuItemOne = new MenuItem("Burger", 10.00, 700);
        orderItemOne = new OrderItem(menuItemOne, 1);
        orderOne.addItem(orderItemOne);

        double tax = orderOne.calculateTax(orderOne.calculateTotal());
        assertEquals(0.625, tax, "The calculated tax is incorrect");
    }
    
}
