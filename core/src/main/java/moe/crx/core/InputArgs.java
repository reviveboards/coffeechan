package moe.crx.core;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
public final class InputArgs {

    private enum ParseState {
        NONE, HOSTNAME, DBNAME, USERNAME, PASSWORD
    }

    private String hostname;
    private String database;
    private String username;
    private String password;

    @Inject public InputArgs(@NotNull @Named("consoleArgs") String[] args) {
        parse(args);
    }

    private void parse(@NotNull String[] args) {
        ParseState state = ParseState.NONE;
        if (args != null) for (String arg : args) {
            switch (arg) {
                case "--hostname", "--host", "--ip", "--address", "--destination" -> state = ParseState.HOSTNAME;
                case "--dbname", "--name", "--db", "--database" -> state = ParseState.DBNAME;
                case "--user", "--username", "--login" -> state = ParseState.USERNAME;
                case "--pass", "--password" -> state = ParseState.PASSWORD;
                default -> {
                    switch (state) {
                        case HOSTNAME -> hostname = arg;
                        case DBNAME -> database = arg;
                        case USERNAME -> username = arg;
                        case PASSWORD -> password = arg;
                    }
                    state = ParseState.NONE;
                }
            }
        }

        if (hostname == null) {
            System.out.println("Hostname is not declared, using localhost. Use launch argument --hostname.");
            hostname = "localhost";
        }
        if (hostname.indexOf(':') == -1 || hostname.indexOf(':') + 1 == hostname.length()) {
            System.out.println("Port is not declared. Using standard (5432).");
            hostname += ":5432";
        }
        if (database == null) {
            System.out.println("Database is not declared, using standard (database). Use launch argument --database.");
            database = "coffeechan";
        }
        if (username == null) {
            System.out.println("Username is not declared, using standard (postgres). Use launch argument --username.");
            username = "postgres";
        }
        if (password == null) {
            System.out.println("Password is not declared, using standard (verystrongpassword). Use launch argument --password.");
            password = "verystrongpassword";
        }
    }
}
