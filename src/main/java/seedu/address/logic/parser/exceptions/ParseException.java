package seedu.address.logic.parser.exceptions;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a parse error encountered by a parser.
 */
public class ParseException extends IllegalValueException {

    /**
     * Creates a parse exception with a human-readable error message.
     *
     * @param message description of the parse failure
     */
    public ParseException(String message) {
        super(message);
    }

    /**
     * Creates a parse exception with a message and an underlying cause.
     *
     * @param message description of the parse failure
     * @param cause original exception that caused this parse failure
     */
    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
