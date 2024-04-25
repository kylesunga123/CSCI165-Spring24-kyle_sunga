/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount() {
        super();
        this.overdraftLimit = 1000;
    }

    /**
     * Constructs a CheckingAccount with specified details and a default overdraft
     * limit of 1000.
     *
     * @param accountNumber  the account number
     * @param owner       the owner of the account as a Customer object
     * @param dateCreated the date the account was created
     * @param balance     the initial balance of the account
     */
    public CheckingAccount(int accountNumber, Customer owner, Date dateCreated, double balance) {
        super(accountNumber, owner, dateCreated, balance);
        this.overdraftLimit = 1000;
    }
    
    /**
     * Copy constructor that creates a new CheckingAccount instance by copying another CheckingAccount instance.
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
     * @return true if the account's balance is less than the negative overdraft limit, false otherwise
     */
    public boolean isInOverDraft() {
        if (this.getBalance() - overdraftLimit < -1000)
            return true;
        else 
        return false;
    }

    /**
     * Withdraws a specified sum from the account if the sum is positive and the transaction does not
     * exceed the overdraft limit.
     *
     * @param sum the amount to withdraw, must be a positive value
     */
    @Override
    public void withdraw(double sum) {
        if (sum <= 0) {
            System.err.println("Cannot withdraw non-positive amounts.");
            return;
        }
        if (this.getBalance() - sum < -this.overdraftLimit) {
            System.err.println("Withdrawal would exceed overdraft limit. Transaction cancelled.");
        } else {
            super.withdraw(sum);
        }
    }

    /**
     * Returns a string representation of the CheckingAccount including the account details and overdraft limit.
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

    @Override
    public void updateAccount() {
        super.updateAccount(); // Call to superclass method, in case it's needed
        if (isInOverDraft()) {
            System.out.println("Warning: Account is currently in overdraft!");
        }
    }

}
