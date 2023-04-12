package moe.crx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Post {
    private long id;
    private long poster;
    private long parent;
    private Date creationDate;
    private String title;
    private String message;
    private List<Long> images;
    private boolean locked;
    private boolean visible;
}
