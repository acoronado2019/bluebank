package co.com.bluebank.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    return route(POST(apiProperties.getCreateAccount()), handler::createAccount)
            .andRoute(POST(apiProperties.getConsignment()), handler::consignment)
            .andRoute(POST(apiProperties.getWithdrawMoney()), handler::withdrawMoney)
            .and(route(GET(apiProperties.getCheckBalance()), handler::checkBalance));

    }
}
