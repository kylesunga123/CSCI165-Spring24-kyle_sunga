public class IDNotWellFormedException extends Exception {
    /**
     * Default constructor for IDNotWellFormedException.
     * Creates a new instance of IDNotWellFormedException without a detail message.
     */
    public IDNotWellFormedException() {
    }

    /**
     * Constructs an IDNotWellFormedException with a detailed message.
     * 
     * @param message A String that provides a detailed message for the exception.
     */
    public IDNotWellFormedException(String message) {
        super(message);
    }

}
