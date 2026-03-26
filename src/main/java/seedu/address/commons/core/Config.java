package seedu.address.commons.core;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Config values used by the app
 */
public class Config {

    public static final Path DEFAULT_CONFIG_FILE = Paths.get("config.json");

    // Config values customizable through config file
    private Level logLevel = Level.INFO;
    private Path userPrefsFilePath = Paths.get("preferences.json");

    /**
     * Returns the configured log level used by the application logger.
     *
     * @return current log level
     */
    public Level getLogLevel() {
        return logLevel;
    }

    /**
     * Sets the log level used by the application logger.
     *
     * @param logLevel new log level to use
     */
    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Returns the path used to persist user preferences.
     *
     * @return user preferences file path
     */
    public Path getUserPrefsFilePath() {
        return userPrefsFilePath;
    }

    /**
     * Sets the path used to persist user preferences.
     *
     * @param userPrefsFilePath user preferences file path
     */
    public void setUserPrefsFilePath(Path userPrefsFilePath) {
        this.userPrefsFilePath = userPrefsFilePath;
    }

    /**
     * Returns whether this config stores the same values as another object.
     *
     * @param other object to compare against
     * @return true if both objects represent the same configuration
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Config)) {
            return false;
        }

        Config otherConfig = (Config) other;
        return Objects.equals(logLevel, otherConfig.logLevel)
                && Objects.equals(userPrefsFilePath, otherConfig.userPrefsFilePath);
    }

    /**
     * Returns a hash code consistent with {@link #equals(Object)}.
     *
     * @return hash code for this config
     */
    @Override
    public int hashCode() {
        return Objects.hash(logLevel, userPrefsFilePath);
    }

    /**
     * Returns a debug-friendly string representation of this config.
     *
     * @return string representation containing config values
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("logLevel", logLevel)
                .add("userPrefsFilePath", userPrefsFilePath)
                .toString();
    }

}
