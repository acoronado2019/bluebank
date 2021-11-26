package co.com.bluebank.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ErrorDTO {

    private String id;
    private String type;
    private String code;
    private String title;
    private String detail;
    private String source;
    private String display;

}
