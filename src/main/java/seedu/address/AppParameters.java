package seedu.address;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import javafx.application.Application;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents the parsed command-line parameters given to the application.
 */
public class AppParameters {
    private static final Logger logger = LogsCenter.getLogger(AppParameters.class);

    private Path configPath;

    /**
     * Returns the optional config file path supplied via command line.
     *
     * @return config file path, or null if not provided
     */
    public Path getConfigPath() {
        return configPath;
    }

    /**
     * Sets the config file path parsed from command line parameters.
     *
     * @param configPath config file path, or null to use default behavior
     */
    public void setConfigPath(Path configPath) {
        this.configPath = configPath;
    }

    /**
     * Parses the application command-line parameters.
     */
    public static AppParameters parse(Application.Parameters parameters) {
        AppParameters appParameters = new AppParameters();
        Map<String, String> namedParameters = parameters.getNamed();

        String configPathParameter = namedParameters.get("config");
        if (configPathParameter != null && !FileUtil.isValidPath(configPathParameter)) {
            logger.warning("Invalid config path " + configPathParameter + ". Using default config path.");
            configPathParameter = null;
        }
        appParameters.setConfigPath(configPathParameter != null ? Paths.get(configPathParameter) : null);

        return appParameters;
    }

    /**
     * Returns whether this object contains the same parsed parameters as another object.
     *
     * @param other object to compare against
     * @return true if both objects hold equivalent parameter values
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AppParameters)) {
            return false;
        }

        AppParameters otherAppParameters = (AppParameters) other;
        return Objects.equals(configPath, otherAppParameters.configPath);
    }

    /**
     * Returns a hash code consistent with {@link #equals(Object)}.
     *
     * @return hash code for this parameter object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(configPath);
    }

    /**
     * Returns a debug-friendly string representation of parsed parameters.
     *
     * @return string representation of parsed command-line options
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("configPath", configPath)
                .toString();
    }
}
