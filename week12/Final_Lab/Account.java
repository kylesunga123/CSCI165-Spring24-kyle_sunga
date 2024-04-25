/*
	File:	Account.java
	Author:	Ken Whitener
	Date:	4/15/2024

 	A class for bank accounts.
	This class provides the basic functionality of accounts.
	It allows deposits and withdrawals but not overdraft limits or interest rates.
*/

public class Account {
	private Customer owner; // the owner of the account
	private Employee accountManager; // the manager of the account
	private Date dateCreated; // date the account was created
	private int accountNumber; // The account number
	private double balance; // The current balance

	/**
	 * 
	 * @param accountNumber
	 * @param manager
	 */
	public Account(int accountNumber, Customer owner, Date created, double balance) {
		this.accountNumber = accountNumber;
		this.owner = new Customer(owner);
		this.dateCreated = new Date(created);
		this.balance = balance;
	}
	
	/*
	 * @Override
    // Override updateAccount method from Account class and print a message if checking accont is in overdraft
    public void updateAccount(){
        if (isInOverDraft()) {
            System.out.println("Account is in overdraft");
        }
    }
	 */
	
	public void updateAccount(){} 
	
	
	/**
	 * Default constructor
	 * 
	 * @param account
	 */
	public Account() {
		this(0, null, null, 0d); // Pass fields
	}

	/**
	 * Copy constructor
	 * 
	 * @param account
	 */
	public Account(Account account) {
		this(account.accountNumber, account.owner, account.dateCreated, account.balance); // Pass fields
	}

	/**
	 * 
	 * @param accountNumber
	 * @param manager
	 * @param owner
	 * @param created
	 */
	public Account(int accountNumber, Employee manager, Customer owner, Date created) {
		this(accountNumber, owner, created, 0); // call to overloaded constructor
		this.accountManager = new Employee(manager);// privacy protection
	}

	/**
	 * 
	 * @param sum
	 */
	public void deposit(double sum) {
		if (sum > 0)
			this.balance += sum;
		else
			System.err.println("Account.deposit(...): cannot deposit negative amount.");
	}

	/**
	 * 
	 * @param sum
	 */
	public void withdraw(double sum) {
		if (sum > 0)
			this.balance -= sum;
		else
			System.err.println("Account.withdraw(...): cannot withdraw negative amount.");
	}

	public void transferTo(Account otherAccount, double amount) {
		if (this.owner.equals(otherAccount.owner) && amount < this.balance)
			otherAccount.deposit(amount);
	}

	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @return the account number
	 */
	public double getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 
	 * @param manager
	 */
	public void setManager(Employee manager) {
		this.accountManager = new Employee(manager); // privacy protection
	}

	/**
	 * 
	 * @return The account manager for this account
	 */
	public Employee getManager() {
		return new Employee(this.accountManager); // privacy protection
	}

	/**
	 * 
	 * @return The date the account was created
	 */
	public Date getDateCreated() {
		return new Date(dateCreated); // privacy protection
	}

	/**
	 * 
	 * @return The account owner
	 */
	public Customer getOwner() {
		return new Customer(this.owner); // privacy protection
	}

	
	@Override
	public String toString() {
		return "Account Number: " + accountNumber +
				"\nOpened: " + dateCreated + // calls Date.toString
				"\nOwner: " + owner + // calls Customer.toString
				"\nManager: " + accountManager + // calls Employee.toString
				"\nBalance: " + balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // identity check
		if (obj == null)
			return false; // null check
		if (getClass() != obj.getClass())
			return false; // origin check

		Account other = (Account) obj; // down cast

		if (accountManager == null) {
			if (other.accountManager != null)
				return false;
		} else if (!accountManager.equals(other.accountManager)) // calls Employee.equals (composition)
			return false;
		if (accountNumber != other.accountNumber) // check account number (primitive)
			return false;
		if (balance != other.balance) // check balance (primitive)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner)) // calls Customer.equals (composition)
			return false;
		return true;
	}
	public void updateAccont(){}
}
