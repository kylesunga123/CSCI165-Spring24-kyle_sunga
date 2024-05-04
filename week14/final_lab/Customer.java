/*Kyle Sunga
 * April 19,2024
 * CSCI 165
 */
//added java docs using AI
public class Customer extends Person {

    private Date dateJoined;
    private String custID;

    /**
     * Default constructor initializes the customer with default values.
     */
    public Customer() {
        super(); // Calls Person's default constructor
        this.dateJoined = new Date(); // Set to current date to avoid nulls
        this.custID = "UNKNOWN"; // Default customer ID
    }

    /**
     * Constructs a customer with a specific ID.
     * 
     * @param id The customer ID to set, must follow a specific format.
     * @throws IDNotWellFormedException if the ID format is invalid.
     */
    public Customer(String id) throws IDNotWellFormedException {
        setCustID(id);
    }

    /**
     * Constructs a customer with detailed information.
     * 
     * @param firstName  The first name of the customer.
     * @param lastName   The last name of the customer.
     * @param phone      The phone number of the customer.
     * @param DOB        The date of birth of the customer.
     * @param dateJoined The date the customer joined.
     * @param custID     The customer's ID.
     */
    public Customer(String firstName, String lastName, String phone, Date DOB, Date dateJoined, String custID) {
        super(firstName, lastName, phone, DOB); // Initialize Person fields
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
        this.custID = (custID != null) ? custID : "UNKNOWN";
    }

    /**
     * Constructs a customer based on a Person object and additional details.
     * 
     * @param person     A Person object to copy attributes from.
     * @param dateJoined The date the customer joined.
     * @param custID     The customer's ID.
     */
    public Customer(Person person, Date dateJoined, String custID) {
        super(person); // Use Person copy constructor
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
        this.custID = (custID != null) ? custID : "UNKNOWN";
    }

    /**
     * Copy constructor to create a new Customer instance from another instance.
     * 
     * @param toCopy The customer instance to copy from.
     */
    public Customer(Customer toCopy) {
        super(toCopy); // Copy Person attributes
        this.dateJoined = new Date(toCopy.dateJoined); // Create a new Date object based on toCopy
        this.custID = toCopy.custID;
    }

    // GETTERS AND SETTERS
    /**
     * Sets the date the customer joined.
     * 
     * @param dateJoined The new join date for the customer.
     */
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = (dateJoined != null) ? new Date(dateJoined) : new Date();
    }

    // public void setCustID(String custID) {
    // this.custID = (custID != null) ? custID : "UNKNOWN";
    // }

    /**
     * Sets the customer ID after validating it against a specific format.
     * The ID must start with a letter followed by three digits.
     * 
     * @param id The customer ID to be set.
     * @throws IDNotWellFormedException If the ID does not meet the required format.
     * @note This code was generated with the assistance of AI
     */
    public void setCustID(String id) throws IDNotWellFormedException {
        if (!id.matches("^[a-zA-Z]\\d{3}$")) { //chatgpt gave me this code block
            throw new IDNotWellFormedException(
                    "Invalid customer ID: " + id + ". ID must start with a letter followed by 3 digits.");
        }
        this.custID = id;
    }

    /**
     * Returns a new Date object representing the date the customer joined.
     * This prevents external modifications to the internal date object.
     * 
     * @return A new Date object representing the join date.
     */
    public Date getDateJoined() {
        return new Date(this.dateJoined); // Return a new Date object to prevent external modifications
    }

    /**
     * Returns the customer ID.
     * 
     * @return The customer ID.
     */
    public String getCustID() {
        return custID;
    }

    // Override equals method
    /**
     * Overrides the equals method to compare Customer objects based on the
     * superclass attributes,
     * the date joined, and the customer ID.
     * 
     * @param obj The object to compare this customer against.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Customer))
            return false;
        if (!super.equals(obj))
            return false; // Check superclass equality

        Customer other = (Customer) obj;
        return this.dateJoined.equals(other.dateJoined) && this.custID.equals(other.custID);
    }

    // Override toString method
    /**
     * Overrides the toString method to provide a string representation of this
     * customer,
     * including superclass attributes, join date, and customer ID.
     * 
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return super.toString() + "\nDate Joined: " + dateJoined + "\nCustomer ID: " + custID;
    }

    /**
     * after using chatgpt i learned about whats going on line 163. having the alphabet caps and not caps. then taking a digit with 3 digits, hense the 3 in d{3}$
     * Validates the format of a customer ID.
     * The ID must start with a letter followed by three digits.
     * 
     * @param id The customer ID to be validated.
     * @throws IDNotWellFormedException If the ID does not meet the required format.
     */
    public static void validateID(String id) throws IDNotWellFormedException {
        if (!id.matches("^[a-zA-Z]\\d{3}$")) { //chat gpt gave me this line so if necessary i will use it in future code. 
            throw new IDNotWellFormedException("Invalid customer ID: " + id +
                ". ID must start with a letter followed by 3 digits.");
        }
    }
}
