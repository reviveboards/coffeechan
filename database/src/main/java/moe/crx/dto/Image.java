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
    private String squaredUrl;
    private String fileName;
    private int width;
    private int height;
    private long fileSize;
    private String alt;
}
