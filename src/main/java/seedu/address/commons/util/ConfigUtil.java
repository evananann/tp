package seedu.address.commons.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.core.Config;
import seedu.address.commons.exceptions.DataLoadingException;

/**
 * Utility methods for reading and writing application {@link Config}.
 */
public class ConfigUtil {

    /**
     * Reads a {@link Config} from a JSON file.
     *
     * @param configFilePath path to config file
     * @return optional containing config when the file exists and is valid;
     *         empty optional when the config file does not exist
     * @throws DataLoadingException if the file content is invalid
     */
    public static Optional<Config> readConfig(Path configFilePath) throws DataLoadingException {
        return JsonUtil.readJsonFile(configFilePath, Config.class);
    }

    /**
     * Writes a {@link Config} to a JSON file.
     *
     * @param config config to save
     * @param configFilePath destination config file path
     * @throws IOException if writing fails
     */
    public static void saveConfig(Config config, Path configFilePath) throws IOException {
        JsonUtil.saveJsonFile(config, configFilePath);
    }

}
