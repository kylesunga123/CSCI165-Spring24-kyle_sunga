/*Kyle Sunga
 * April 19, 2024
 * CSCI 165
 */

public class SavingsAccount extends Account {

    // Constant for the interest rate
    private final double INTEREST_RATE = 0.01;

    public static final double MINIMUM_BALANCE = 100;
    public static final int MAX_WITHDRAWALS = 2;
    private int currentWithdrawals = 0;
    private static final double MAX_WITHDRAWAL_AMOUNT = 500;

    /**
     * Default constructor for SavingsAccount which initializes a new account with
     * default settings.
     */
    public SavingsAccount() {
        super();
    }

    /**
     * Constructs a SavingsAccount with specified details.
     * 
     * @param accountNum  the account number
     * @param owner       the owner of the account as a Customer object
     * @param dateCreated the date the account was created
     * @param balance     the initial balance of the account
     */
    public SavingsAccount(int accountNumber, Customer owner, Date dateCreated, double balance) {
        super(accountNumber, owner, dateCreated, balance);
    }

    /**
     * Copy constructor that creates a new SavingsAccount instance by copying
     * another SavingsAccount instance.
     *
     * @param toCopy the SavingsAccount to copy
     */
    public SavingsAccount(SavingsAccount toCopy) {
        super(toCopy);
    }

    /**
     * Adds interest to the current balance of the account.
     * 
     * @throws InvalidBalanceException
     *
     */
    public void addInterest() throws InvalidBalanceException {
        double interestAmount = this.getBalance() * INTEREST_RATE;
        this.deposit(interestAmount);
    }

    /**
     * Validates the balance of the savings account to ensure it meets the minimum
     * required balance.
     * If the balance falls below the minimum required after a transaction, it
     * throws an InvalidBalanceException.
     *
     * @param amount The amount to be withdrawn, which could potentially bring the
     *               balance below the minimum.
     * @throws InvalidBalanceException if the post-transaction balance would be less
     *                                 than the minimum required balance.
     */
    public void validateBalance(double amount) throws InvalidBalanceException {
        double projectedBalance = this.getBalance() - amount;
        if (projectedBalance < MINIMUM_BALANCE) {
            throw new InvalidBalanceException(
                    "Transaction would reduce balance below the required minimum of $" + MINIMUM_BALANCE);
        }
    }

    /**
     * withdraw ammout was a bit buggy so i asket chat gpt for assistance.
     * Withdraws a specified sum from the account, ensuring it does not exceed the
     * maximum allowable withdrawals or withdrawal amount.
     *
     * @param amount the amount to withdraw, must be within the allowed maximum for
     *               a single withdrawal and must not exceed available balance.
     * @throws InvalidBalanceException if the withdrawal request is greater than the
     *                                 balance.
     * @throws OverdraftException      if the withdrawal exceeds the allowed number
     *                                 of withdrawals or the maximum withdrawal
     *                                 amount.
     */
    public void withdraw(double amount) throws InvalidBalanceException, OverdraftException {
        // Check if the maximum number of withdrawals has been reached
        if (currentWithdrawals >= MAX_WITHDRAWALS) {
            throw new OverdraftException("Maximum number of withdrawals reached.");
        }

        // Check if the withdrawal amount exceeds the maximum allowed amount
        if (amount > MAX_WITHDRAWAL_AMOUNT) {
            throw new OverdraftException("Withdrawal amount exceeds the maximum limit of $" + MAX_WITHDRAWAL_AMOUNT);
        }

        // Check if the withdrawal amount is more than the current balance
        if (amount > this.getBalance()) {
            throw new InvalidBalanceException("Insufficient funds for withdrawal.");
        }

        // Perform the withdrawal and increment the withdrawal count
        super.withdraw(amount); // Assuming the base Account class handles the actual subtraction from balance
        currentWithdrawals++;
    }

    /**
     * Returns a string representation of the SavingsAccount including the account
     * details and interest rate.
     *
     * @return a string representation of the SavingsAccount
     */
    @Override
    public String toString() {
        return super.toString() + "\n\033[33mInterest Rate:\033[0m " + (INTEREST_RATE * 100) + "%";
    }

    /**
     * Compares this SavingsAccount with another object for equality based on the
     * Account class properties.
     *
     * @param obj the object to compare
     * @return true if the objects are the same instance or if they are both
     *         instances of SavingsAccount and have identical account properties
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        return obj instanceof SavingsAccount;
    }

    /**
     * Updates the account by adding interest to the balance.
     */
    @Override
    public void updateAccount() throws InvalidBalanceException {
        addInterest();
    };
}
