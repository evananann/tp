package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Stores and loads {@link UserPrefs} from a JSON file on disk.
 */
public class JsonUserPrefsStorage implements UserPrefsStorage {

    private Path filePath;

    /**
     * Creates a storage backed by the given user preferences file path.
     *
     * @param filePath path of the JSON user preferences file
     */
    public JsonUserPrefsStorage(Path filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns the path of the JSON file used to store user preferences.
     *
     * @return user preferences file path
     */
    @Override
    public Path getUserPrefsFilePath() {
        return filePath;
    }

    /**
     * Reads user preferences from the configured file path.
     *
     * @return optional user preferences read from disk
     * @throws DataLoadingException if the file format is not as expected.
     */
    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return readUserPrefs(filePath);
    }

    /**
     * Similar to {@link #readUserPrefs()}
     * @param prefsFilePath location of the data. Cannot be null.
     * @throws DataLoadingException if the file format is not as expected.
     */
    public Optional<UserPrefs> readUserPrefs(Path prefsFilePath) throws DataLoadingException {
        return JsonUtil.readJsonFile(prefsFilePath, UserPrefs.class);
    }

    /**
     * Saves user preferences to the configured file path.
     *
     * @param userPrefs user preferences data to persist
     * @throws IOException if writing to disk fails
     */
    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        JsonUtil.saveJsonFile(userPrefs, filePath);
    }

}
