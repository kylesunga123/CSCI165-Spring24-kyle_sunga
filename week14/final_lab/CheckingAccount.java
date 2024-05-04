/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public static final double MaxDeposit = 1200;

    public CheckingAccount() {
        super();
        this.overdraftLimit = 1000;
    }

    /**
     * Constructs a CheckingAccount with specified details and a default overdraft
     * limit of 1000.
     *
     * @param accountNumber the account number
     * @param owner         the owner of the account as a Customer object
     * @param dateCreated   the date the account was created
     * @param balance       the initial balance of the account
     */
    public CheckingAccount(int accountNumber, Customer owner, Date dateCreated, double balance) {
        super(accountNumber, owner, dateCreated, balance);
        this.overdraftLimit = 1000;
    }

    /**
     * Copy constructor that creates a new CheckingAccount instance by copying
     * another CheckingAccount instance.
     *
     * @param toCopy the CheckingAccount to copy
     */
    public CheckingAccount(CheckingAccount toCopy) {
        super(toCopy);
        this.overdraftLimit = toCopy.overdraftLimit;
    }

    // getters and setters

    /**
     * Retrieves the overdraft limit for this account.
     *
     * @return the overdraft limit as a double
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets the overdraft limit for this account. The limit cannot be negative.
     *
     * @param overdraftLimit the new overdraft limit, must be non-negative
     */
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) {
            System.err.println("Overdraft limit cannot be negative.");
        } else {
            this.overdraftLimit = overdraftLimit;
        }
    }

    /**
     * Checks whether the account is currently in overdraft.
     *
     * @return true if the account's balance is less than the negative overdraft
     *         limit, false otherwise
     */
    public boolean isInOverDraft() {
        if (this.getBalance() - overdraftLimit < -1000)
            return true;
        else
            return false;
    }

    /**
     * Withdraws a specified sum from the account if the sum is positive and the
     * transaction does not
     * exceed the overdraft limit.
     *
     * @param sum the amount to withdraw, must be a positive value.
     * @throws InvalidBalanceException if the withdrawal amount is negative or zero.
     * @throws OverdraftException      if the withdrawal exceeds the account's
     *                                 overdraft limit.
     */
    @Override
    public void withdraw(double sum) throws InvalidBalanceException, OverdraftException {

        if (sum <= 0) {
            throw new InvalidBalanceException("Cannot withdraw non-positive amounts.");
        }
        if (this.getBalance() - sum < -this.overdraftLimit) {
            throw new OverdraftException("Withdrawal would exceed overdraft limit. Transaction cancelled.");
        }
        super.withdraw(sum);

    }

    /**
     * Deposits a specified sum into the account, ensuring the deposit does not
     * exceed the maximum allowable limit.
     *
     * @param sum the amount to deposit, must not exceed the defined maximum deposit
     *            limit.
     * @throws InvalidBalanceException if the deposit amount exceeds the maximum
     *                                 allowed deposit limit.
     */
    @Override
    public void deposit(double sum) throws InvalidBalanceException {
        // Check if the deposit amount exceeds the maximum allowed limit
        if (sum > MaxDeposit) {
            throw new InvalidBalanceException(
                    "Deposit exceeds the maximum limit of $1500. Attempted to deposit: $" + sum);
        }

        // If the deposit is within the limit, proceed with the deposit operation
        super.deposit(sum);
    }

    /**
     * Validates that the deposit amount does not exceed the maximum allowed limit.
     * This method is designed to enforce a deposit cap, preventing deposits over a
     * specified maximum amount.
     *
     * @param sum The amount being deposited.
     * @throws InvalidBalanceException If the deposit amount exceeds the maximum
     *                                 limit of $1500.
     */
    public void validateBalance(double sum) throws InvalidBalanceException {
        // Check if the deposit amount exceeds the maximum allowed limit
        if (sum > MaxDeposit) {
            throw new InvalidBalanceException("You cannot deposit a sum over $1200. Attempted deposit: $" + sum);
        }
    }

    /**
     * Returns a string representation of the CheckingAccount including the account
     * details and overdraft limit.
     *
     * @return a string representation of the CheckingAccount
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n\033[33mOverdraft Limit:\033[0m " + overdraftLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof CheckingAccount))
            return false;
        CheckingAccount other = (CheckingAccount) obj;
        return Double.compare(this.overdraftLimit, other.overdraftLimit) == 0;
    }

    /**
     * Updates the account, checking for any conditions such as overdraft.
     * If the account is in overdraft, a warning message is printed.
     */
    @Override
    public void updateAccount() {

        if (isInOverDraft()) {
            System.out.println("Warning: Account is currently in overdraft!");
        }
    }

}
