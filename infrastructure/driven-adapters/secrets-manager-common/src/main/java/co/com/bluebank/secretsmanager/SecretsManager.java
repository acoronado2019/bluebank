package co.com.bluebank.secretsmanager;


import co.com.bancolombia.common.enums.TechnicalExceptionEnum;
import co.com.bancolombia.common.exception.TechnicalException;
import connector.AWSSecretManagerConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SecretsManager {

    private final AWSSecretManagerConnector awsSecretManagerConnector;

    public <T> Mono<T> getSecret(String secret, Class<T> cls) {
        return awsSecretManagerConnector.getSecret(secret, cls)
                .doOnSuccess(e -> {

                })
                .onErrorMap(error -> {
                    var message = String.join(" ", secret, error.getMessage());
                    return new TechnicalException(TechnicalExceptionEnum.TECHNICAL_SECRET_EXCEPTION);
                });
    }

}
