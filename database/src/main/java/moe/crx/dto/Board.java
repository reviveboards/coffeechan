package moe.crx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Board {
    private long id;
    private String tag;
    private String name;
    private String description;
    private boolean visible;
    private boolean locked;
    private boolean nsfw;
    private long header;
    private long category;

    @JsonIgnore
    public String getTagSlashed() {
        return "/" + tag + "/";
    }

    @JsonIgnore
    public String getLink() {
        return getTagSlashed();
    }
}
