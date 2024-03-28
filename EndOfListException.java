/*
Tarun Vaidhyanathan
115510562
Homework#2
 */
/**
 * This exception is thrown when attempting to perform an operation that involves the cursor at the end of the list.
 */
public class EndOfListException extends Exception {
    /**
     * Constructs a new EndOfListException with the specified error message.
     *
     * @param error The error message for this exception.
     */
    public EndOfListException(String error){
        super(error);
    }
}
