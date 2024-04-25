/* Kyle Sunga
 * April 19, 2024
 * CSCI 165
 */
public class BankDriver {

    public static void main(String[] args) {
        
        // Initialize Date and Customer details
        Date customerOneBirthday = new Date(3, 6, 2005); 
        Date customerOneHireDate = new Date(1, 12, 2024); 
        Customer ownerOne = new Customer("Kyle", "Sunga", "2014437054", customerOneBirthday, customerOneHireDate, "123456789");

        // Create a Bank instance
        Bank myBank = new Bank();

        // Create and register a Savings Account
        SavingsAccount savingsAccountOne = new SavingsAccount(1357, ownerOne, new Date(4, 19, 2024), 10000);
        myBank.openAccount(savingsAccountOne);
        
        // Create and register a Checking Account
        CheckingAccount checkingAccountOne = new CheckingAccount(9876, ownerOne, new Date(4, 19, 2024), 5000);
        myBank.openAccount(checkingAccountOne);

        // Display all accounts before closing any
        System.out.println("Accounts in the bank before closing any account:");
        for (Account account : myBank.bankAccounts) {
            System.out.println(account);
        }

        // Close the Checking Account using its account number
        myBank.closeAccount(9876);

        // Display the remaining accounts after closing the checking account
        System.out.println("\nAccounts in the bank after closing the checking account:");
        for (Account account : myBank.bankAccounts) {
            System.out.println(account);
        }

        // Update interest in the savings account
        myBank.update();

        // Display savings account after interest update
        System.out.println("\nAccounts in the bank after update:");
        for (Account account : myBank.bankAccounts) {
            System.out.println(account);
        }
    }
}
