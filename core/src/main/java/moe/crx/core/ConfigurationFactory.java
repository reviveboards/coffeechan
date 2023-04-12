package moe.crx.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public final class ConfigurationFactory {

    private static Configuration configuration = null;

    public @NotNull Configuration getInstance(@NotNull String filePath) {
        if (configuration == null) {
            var file = new File(filePath);

            try {
                configuration = new ObjectMapper().readValue(file, Configuration.class);
            } catch (Exception e) {
                configuration = new Configuration();
                e.printStackTrace();
            }

            configuration.setFile(file);
        }

        return configuration;
    }

    public @NotNull Configuration getInstance() {
        return getInstance("config.json");
    }
}
