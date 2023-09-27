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
    private long board;
    private long parent;
    private Date creationtime = new Date();
    private String title;
    private String message;
    private boolean locked;
    private boolean visible;
    private List<Long> images = List.of();
}
