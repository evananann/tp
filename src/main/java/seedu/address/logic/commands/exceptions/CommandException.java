package seedu.address.logic.commands.exceptions;

/**
 * Represents an error which occurs during execution of a {@link Command}.
 */
public class CommandException extends Exception {
    /**
     * Creates a command exception with a detail message and no cause.
     *
     * @param message detail message shown to the user
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code CommandException} with the specified detail {@code message} and {@code cause}.
     *
     * @param message detail message shown to the user
     * @param cause the cause (which is saved for later retrieval by the getCause() method)
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
