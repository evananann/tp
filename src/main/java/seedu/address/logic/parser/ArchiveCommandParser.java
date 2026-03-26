package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ArchiveCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/** Parses index arguments into an ArchiveCommand. */
public class ArchiveCommandParser implements Parser<ArchiveCommand> {

    /**
     * Parses input arguments and creates an {@link ArchiveCommand}.
     *
     * @param args raw arguments after the archive command word
     * @return archive command targeting the parsed index
     * @throws ParseException if the input is not a valid single index
     */
    @Override
    public ArchiveCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ArchiveCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ArchiveCommand.MESSAGE_USAGE), pe);
        }
    }
}
