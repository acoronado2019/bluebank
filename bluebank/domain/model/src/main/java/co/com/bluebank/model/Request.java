package co.com.bluebank.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class Request implements Serializable {
    private Map<String, String> headers;

    public Request headers(Map<String, String> headers) {
        headers.forEach((s, s2) -> {
            if (s2.isBlank()) {
                headers.replace(s, null);
            }
        });
        if (this.getHeaders() != null) {
            this.getHeaders().putAll(headers);
        } else {setHeaders(headers); }
        return this;
    }
}
