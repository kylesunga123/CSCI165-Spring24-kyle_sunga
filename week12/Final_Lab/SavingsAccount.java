/*Kyle Sunga
 * April 19, 2024
 * CSCI 165
 */

 public class SavingsAccount extends Account {

    // Constant for the interest rate
    private final double INTEREST_RATE = 0.01;

    /**
     * Default constructor for SavingsAccount which initializes a new account with default settings.
     */
    public SavingsAccount() {
        super();
    }

    /**
     * Constructs a SavingsAccount with specified details.
     * 
     * @param accountNum   the account number
     * @param owner        the owner of the account as a Customer object
     * @param dateCreated  the date the account was created
     * @param balance      the initial balance of the account
     */
    public SavingsAccount(int accountNumber, Customer owner, Date dateCreated, double balance) {
        super(accountNumber, owner, dateCreated, balance);
    }

    /**
     * Copy constructor that creates a new SavingsAccount instance by copying another SavingsAccount instance.
     *
     * @param toCopy  the SavingsAccount to copy
     */
    public SavingsAccount(SavingsAccount toCopy) {
        super(toCopy);
    }

    /**
     * Adds interest to the current balance of the account.
     */
    public void addInterest() {
        double interestAmount = this.getBalance() * INTEREST_RATE;
        this.deposit(interestAmount);
    }

    /**
     * Returns a string representation of the SavingsAccount including the account details and interest rate.
     *
     * @return a string representation of the SavingsAccount
     */
    @Override
    public String toString() {
        return super.toString() + "\n\033[33mInterest Rate:\033[0m " + (INTEREST_RATE * 100) + "%";  
    }

    /**
     * Compares this SavingsAccount with another object for equality based on the Account class properties.
     *
     * @param obj the object to compare
     * @return true if the objects are the same instance or if they are both instances of SavingsAccount and have identical account properties
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        return obj instanceof SavingsAccount;
    }

    /**
     * Updates the account by adding interest to the balance.
     */
    @Override
    public void updateAccount() {
        addInterest();
    }
}
