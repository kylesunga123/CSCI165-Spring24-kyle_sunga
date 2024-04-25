/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */

import java.util.ArrayList;
import java.util.Iterator;
//asked chatgpt to write me java docs. 
public class Bank {
    private static final double DIVIDEND_PERCENTAGE = 0.01;
    ArrayList<Account> bankAccounts;

    public Bank() {
        bankAccounts = new ArrayList<>();
    }

    /**
     * Updates all accounts in the bank.
     * Polymorphically processes each account, applying interest or checking for
     * overdrafts.
     */
    public void update() {
        bankAccounts.forEach(Account::updateAccount);
    }

    /**
     * Closes an account based on the account number.
     * 
     * @param accountNumber the account number of the account to close
     */
    public void closeAccount(double accountNumber) {
        Iterator<Account> iterator = bankAccounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getAccountNumber() == accountNumber) {
                iterator.remove();
                System.out.println("Account number " + accountNumber + " was closed successfully.");
                return;
            }
        }
        System.out.println("No account found with account number " + accountNumber);
    }

    /**
     * Opens a new account and prints the account number.
     * 
     * @param account an account object to add to the bank
     */
    public void openAccount(Account account) {
        bankAccounts.add(account);
        System.out.println("Account opened: Account number is " + account.getAccountNumber());
    }

    /**
     * Pays a dividend to each account in the bank.
     */
    public void payDividend() {
        bankAccounts.forEach(account -> {
            double dividend = account.getBalance() * DIVIDEND_PERCENTAGE;
            account.deposit(dividend);
        });
    }
}
