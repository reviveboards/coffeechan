package moe.crx.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public final class ConfigurationFactory {

    private static Configuration configuration = null;

    @NotNull
    public Configuration getInstance(@NotNull String filePath) {
        if (configuration == null) {
            var file = new File(filePath);

            try {
                configuration = new ObjectMapper().readValue(file, Configuration.class);
            } catch (Exception e) {
                configuration = new Configuration();
                e.printStackTrace();
            }

            configuration.setFile(file);
            configuration.save();
        }

        return configuration;
    }

    @NotNull
    public Configuration getInstance(@NotNull String[] args) {
        if (args.length == 0) {
            return getInstance();
        }

        return getInstance(args[0]);
    }

    @NotNull
    public Configuration getInstance() {
        return getInstance("config.json");
    }
}
