package co.com.bluebank.secretsmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "secrets")
public class SecretsNameStandard {

    private static final String SERVICE_POSTGRES = "postgres";

    private String postgres;
    private String name;

    public Mono<String> secretForPostgres() {
        return Mono.just(postgres);
    }
}
