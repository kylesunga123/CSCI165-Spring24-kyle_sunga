/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTests {

    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        // Initialize SavingsAccount with some example data
        account = new SavingsAccount(123, new Customer("John", "Doe", "123456789", new Date(), new Date(), "987654321"), new Date(), 1000);
    }

    @Test
    void testAddInterest() {
        account.addInterest();
        // Expect that the interest added is 1% of 1000, which is 10
        assertEquals(1010, account.getBalance());
    }

    

    @Test
    void testEqualsSameObject() {
        SavingsAccount anotherAccount = new SavingsAccount(123, new Customer("John", "Doe", "123456789", new Date(), new Date(), "987654321"), new Date(), 1000);
        assertEquals(account, anotherAccount);
    }

    @Test
    void testEqualsDifferentObject() {
        SavingsAccount differentAccount = new SavingsAccount(456, new Customer("Jane", "Doe", "987654321", new Date(), new Date(), "123456789"), new Date(), 2000);
        assertNotEquals(account, differentAccount);
    }

    @Test
    void testUpdateAccount() {
        account.updateAccount();
        // The balance should reflect the addition of interest
        assertEquals(1010, account.getBalance());
    }
}
