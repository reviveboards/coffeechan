package moe.crx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    private long id;
    private String name;
    private String country;
    private String ip;
    private String hash;
    private boolean admin;
}
