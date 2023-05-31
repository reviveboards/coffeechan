package moe.crx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class APIError {
    private int errorCode = 0;
    private String errorMessage = "Unknown error";
}
