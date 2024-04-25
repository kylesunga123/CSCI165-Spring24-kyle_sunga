/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */


public class Customer extends Person {

    private Date dateJoined;
    private String custID;

    // Default Constructor
    public Customer() {
        super(); // Calls Person's default constructor
        this.dateJoined = new Date(); // Set to current date to avoid nulls
        this.custID = "UNKNOWN"; // Default customer ID
    }

    // Parameterized Constructor
    public Customer(String firstName, String lastName, String phone, Date DOB, Date dateJoined, String custID) {
        super(firstName, lastName, phone, DOB); // Initialize Person fields
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
        this.custID = (custID != null) ? custID : "UNKNOWN";
    }

    // Constructor with Person object
    public Customer(Person person, Date dateJoined, String custID) {
        super(person); // Use Person copy constructor
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
        this.custID = (custID != null) ? custID : "UNKNOWN";
    }

    // Copy Constructor
    public Customer(Customer toCopy) {
        super(toCopy); // Copy Person attributes
        this.dateJoined = new Date(toCopy.dateJoined); // Create a new Date object based on toCopy
        this.custID = toCopy.custID;
    }

    // GETTERS AND SETTERS
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
    }

    public void setCustID(String custID) {
        this.custID = (custID != null) ? custID : "UNKNOWN";
    }

    public Date getDateJoined() {
        return new Date(this.dateJoined); // Return a new Date object to prevent external modifications
    }

    public String getCustID() {
        return custID;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        if (!super.equals(obj)) return false; // Check superclass equality

        Customer other = (Customer) obj;
        return this.dateJoined.equals(other.dateJoined) && this.custID.equals(other.custID);
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() + "\nDate Joined: " + dateJoined + "\nCustomer ID: " + custID;
    }
}
