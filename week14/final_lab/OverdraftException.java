
public class OverdraftException extends Exception {

    /**
     * Constructs an OverdraftException with no detail message.
     * The default constructor creates an exception without any specific message
     * about the overdraft condition.
     */
    public OverdraftException() {
        super(); 
    }

    /**
     * Constructs an OverdraftException with a specified detail message.
     * This constructor allows for the specification of a message that may include
     * details
     * such as the amount attempted to be withdrawn and the balance allowed.
     * 
     * @param message A String providing details about the specific condition that
     *                caused the exception.
     */
    public OverdraftException(String message) {
        super(message); 
    }
}
