
public class InvalidBalanceException extends Exception {

    /**
     * Constructs an InvalidBalanceException with no detail message.
     * This default constructor creates an exception without any specific message about the invalid balance condition,
     * which might be used when the context of the exception is self-evident from the place it is thrown.
     */
    public InvalidBalanceException() {
        super(); 
    }
    
    /**
     * Constructs an InvalidBalanceException with a specified detail message.
     * This constructor allows for the specification of a message that may include details about the invalid operation,
     * such as attempting to deposit a negative amount, which can aid in debugging and user feedback.
     * 
     * @param message A String providing details about the specific condition that caused the exception.
     */
    public InvalidBalanceException(String message) {
        super(message);  
    }
}
