package moe.crx.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Configuration {

    @JsonIgnore
    private final ObjectMapper mapper = new ObjectMapper();
    @JsonIgnore
    private File file;

    private String[] motd = { "This is a default MOTD." };
    private String title = "coffeechan";
    private int webserverPort = 80;
    private DatabaseConfigurationEntry database = new DatabaseConfigurationEntry();

    public void save() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    @JsonIgnore
    public String getRandomMotd() {
        if (motd == null || motd.length == 0) {
            return "";
        }

        var message = motd[ThreadLocalRandom.current().nextInt(motd.length)];

        return message != null ? message : "";
    }
}
