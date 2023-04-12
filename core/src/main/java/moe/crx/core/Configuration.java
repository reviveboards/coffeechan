package moe.crx.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Data
public final class Configuration {

    @JsonIgnore
    private final ObjectMapper mapper = new ObjectMapper();
    @JsonIgnore
    private File file;

    private String[] motd;
    private String title;

    public void save() {
        try {
            mapper.writeValue(file, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public @NotNull String getRandomMotd() {
        if (motd == null || motd.length == 0) {
            return "";
        }

        var message = motd[ThreadLocalRandom.current().nextInt(motd.length)];

        return message != null ? message : "";
    }

    public @NotNull String getTitle() {
        return title != null ? title : "";
    }
}
