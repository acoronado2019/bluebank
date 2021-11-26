package co.com.bluebank.api.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;

@Component
public class MetaDTO {

    private static String deploymentVersion = "0.0.1";

    @Data
    @Builder(toBuilder = true)
    public static class Meta {

        @JsonProperty("_version")
        private String version;

        @JsonProperty("_requestDate")
        private LocalDateTime requestDate;

        @JsonProperty("_responseSize")
        private int responseSize;

        @JsonProperty("_requestClient")
        private String requestClient;

    }

    public static <T> Meta build(T data, ServerRequest request){
        return Meta.builder()
                .version(deploymentVersion)
                .requestDate(LocalDateTime.now())
                .responseSize(1)
                .requestClient("")
                .build();
    }

}

