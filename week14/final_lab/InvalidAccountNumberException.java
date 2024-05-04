public class InvalidAccountNumberException extends Exception {
    /**
     * Default constructor for InvalidAccountNumberException.
     * Creates a new instance of InvalidAccountNumberException without a detail
     * message.
     */
    public InvalidAccountNumberException() {
    }

    /**
     * Constructs an InvalidAccountNumberException with a detailed message.
     * 
     * @param message A String that provides a detailed message for the exception.
     */
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}
