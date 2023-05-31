package moe.crx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Category {
    private long id;
    private String name;
    private List<Long> boards = List.of();
    private boolean visible;
}
