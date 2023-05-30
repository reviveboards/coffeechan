package moe.crx.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DatabaseConfigurationEntry {
    private String type = "postgresql";
    private String hostname = "localhost";
    private String database = "coffeechan";
    private String username = "postgres";
    private String password = "verystrongpassword";
}
