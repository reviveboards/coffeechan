package moe.crx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Image {
    private long id;
    private String url;
    private String squared;
    private String filename;
    private int width;
    private int height;
    private long filesize;
    private String alt;
}
