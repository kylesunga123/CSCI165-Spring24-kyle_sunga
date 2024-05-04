public class ExceptionDriver {

    public static void main(String[] args) {
        // Creating necessary Date and Customer objects
        Date DOB = new Date(3, 6, 2005);
        Date startDate = new Date(4, 4, 2024);
        Customer customer = new Customer("Toby", "Sunga", "2036063038", DOB, startDate, "T037");

        // Creating Checking and Savings accounts for testing
        CheckingAccount checkingAccount = new CheckingAccount(11111, customer, startDate, 1000);
        SavingsAccount savingsAccount = new SavingsAccount(11111, customer, startDate, 1000);
        CheckingAccount checkingAccount2 = new CheckingAccount(11111, customer, startDate, 1200);
        SavingsAccount savingsAccount2 = new SavingsAccount(11111, customer, startDate, 1200);

        // Testing Customer ID validation
        try {
            Customer.validateID("037"); // Valid ID format, should not throw an exception
        } catch (IDNotWellFormedException e) {
            System.out.println(e.getMessage());
        }

        try {
            Customer.validateID("TT037"); // Invalid ID format, should throw an exception
        } catch (IDNotWellFormedException e){
            System.out.println(e.getMessage());
        }

        // Testing Account Number and Deposit Limits
        try {
            Account.validateAccountNumber(1234); // Valid account number, should not throw an exception
        } catch (InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkingAccount.deposit(1600); // Deposit amount exceeds limit, should throw an exception
        } catch (InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkingAccount.withdraw(2500); // Withdrawal amount exceeds balance, should throw an exception
        } catch (OverdraftException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        // Testing Savings Account Withdrawals
        try {
            savingsAccount.withdraw(75); // First withdrawal, should be fine
        } catch (OverdraftException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            savingsAccount.withdraw(100); // Second withdrawal, should be fine too
        } catch (OverdraftException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            savingsAccount.withdraw(200); // Third withdrawal, should exceed the limit
        } catch (OverdraftException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        // Valid operations checks
        try {
            checkingAccount2.deposit(1499); // Under limit, should be fine
            System.out.println("Successfully deposited $1499. New balance: $" + checkingAccount2.getBalance());
        } catch (InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            savingsAccount2.withdraw(400); // Should be a valid withdrawal
            System.out.println("Successfully withdrew $400. New balance: $" + savingsAccount2.getBalance());
        } catch (OverdraftException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        // Additional scenarios for Customer ID validation
        try {
            Customer.validateID("FKS365"); // Assuming this is invalid
        } catch (IDNotWellFormedException e) {
            System.out.println("Customer ID Validation Error: " + e.getMessage());
        }
    }
}
