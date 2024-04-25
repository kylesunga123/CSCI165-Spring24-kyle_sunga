/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTests {
    private CheckingAccount account;
    private Customer owner;
    private Date dateCreated;

    @BeforeEach
    void setUp() {
        // Create a Customer instance for testing
        owner = new Customer("John", "Doe", "123456789", new Date(1, 1, 1990), new Date(1, 1, 2010), "987654321");
        dateCreated = new Date(4, 20, 2024);
        account = new CheckingAccount(1001, owner, dateCreated, 1000);
    }

    @Test
    void constructorSetsDefaultsProperly() {
        assertEquals(1000, account.getBalance());
        assertEquals(1000, account.getOverdraftLimit());
    }

    @Test
    void setOverdraftLimitValid() {
        account.setOverdraftLimit(1500);
        assertEquals(1500, account.getOverdraftLimit());
    }

    

    @Test
    void withdrawWithinLimit() {
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawToLimit() {
        account.withdraw(1000);
        assertEquals(0, account.getBalance());
    }

    

    @Test
    void isInOverDraft() {
        assertFalse(account.isInOverDraft());
        account.withdraw(1100); // Withdraw within overdraft limit
        assertTrue(account.isInOverDraft());
    }

   
    

    @Test
    void testEqualsMethod() {
        CheckingAccount sameAccount = new CheckingAccount(1001, owner, dateCreated, 1000);
        assertEquals(account, sameAccount);

        CheckingAccount differentAccount = new CheckingAccount(1002, owner, dateCreated, 2000);
        assertNotEquals(account, differentAccount);
    }

    @Test
    void testUpdateAccount() {
        account.withdraw(1050);
        account.updateAccount();
        assertTrue(account.isInOverDraft());
    }
}
