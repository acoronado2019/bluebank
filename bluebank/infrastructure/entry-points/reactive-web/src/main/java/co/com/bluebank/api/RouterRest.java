package co.com.bluebank.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
@RequiredArgsConstructor
public class RouterRest {

    private final ApiProperties apiProperties;

    @Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(POST(apiProperties.getCreateAccount()).and(accept(MediaType.APPLICATION_JSON)), handler::createAccount)
            .andRoute(POST(apiProperties.getConsignment()).and(accept(MediaType.APPLICATION_JSON)), handler::consignment)
            .andRoute(POST(apiProperties.getWithdrawMoney()).and(accept(MediaType.APPLICATION_JSON)), handler::withdrawMoney)
            .and(route(GET(apiProperties.getCheckBalance()).and(accept(MediaType.APPLICATION_JSON)), handler::checkBalance));

    }
}
