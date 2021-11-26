package co.com.bluebank.api;

import co.com.bluebank.api.dto.AccountDTO;
import co.com.bluebank.api.utils.ResponseDTO;
import co.com.bluebank.model.Request;
import co.com.bluebank.model.dto.AccountRequest;
import co.com.bluebank.model.enums.BusinessExceptionEnum;
import co.com.bluebank.model.enums.TechnicalExceptionEnum;
import co.com.bluebank.model.exception.BusinessException;
import co.com.bluebank.model.exception.TechnicalException;
import co.com.bluebank.usecase.gestioncuenta.AccountManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class Handler extends GenericBaseHandler{

    private final AccountManagementUseCase gestationCentUseCase;

    public Mono<ServerResponse> createAccount(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(AccountRequest.class)
                .doOnNext(System.out::println)
                .flatMap(gestationCentUseCase::createAccount)
                .flatMap(resp ->
                        ServerResponse.status(HttpStatus.OK)
                                .contentType(APPLICATION_JSON)
                                .bodyValue(ResponseDTO.success("Datos Almacenados Correctamente", serverRequest)))
                .onErrorResume(TechnicalException.class, error -> {
                    return ServerResponse.status(HttpStatus.CONFLICT)
                            .contentType(APPLICATION_JSON)
                            .bodyValue(ResponseDTO.failed(TechnicalExceptionEnum.TECHNICAL_MISSING_PARAMETER.getMessage(), serverRequest));
                })
                .onErrorResume(BusinessException.class, error -> {
                    return ServerResponse.status(HttpStatus.CONFLICT)
                            .contentType(APPLICATION_JSON)
                            .bodyValue(ResponseDTO.failed(BusinessExceptionEnum.APPLICATION_NOT_FOUND.getDetail(), serverRequest));
                });
    }

    public Mono<ServerResponse> consignment(ServerRequest serverRequest) {
       return serverRequest.bodyToMono(AccountRequest.class)
                .flatMap(gestationCentUseCase::consignment)
                .flatMap(resp ->
                        ServerResponse.status(HttpStatus.OK)
                                .contentType(APPLICATION_JSON)
                                .bodyValue(ResponseDTO.success(resp, serverRequest)));
    }

    public Mono<ServerResponse> withdrawMoney(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(AccountRequest.class)
                .flatMap(gestationCentUseCase::withdrawMoney)
                .flatMap(resp ->
                        ServerResponse.status(HttpStatus.OK)
                                .contentType(APPLICATION_JSON)
                                .bodyValue(ResponseDTO.success(resp, serverRequest)));
    }

    public Mono<ServerResponse> checkBalance(ServerRequest serverRequest) {
        return accountDTOMono(serverRequest)
                .flatMap(AccountDTO::toModel)
                .map(accountRequest -> accountRequest.headers(setHeaders(serverRequest)))
                .map(Request::getHeaders).flatMap(gestationCentUseCase::getBalance)
                .flatMap(resp -> ServerResponse.status(HttpStatus.OK).contentType(APPLICATION_JSON)
                .bodyValue(ResponseDTO.success(resp, serverRequest)))
                .onErrorResume(TechnicalException.class, error -> ServerResponse.status(HttpStatus.CONFLICT)
                .contentType(APPLICATION_JSON).bodyValue(ResponseDTO.failed(ErrorHandler.technical(error), serverRequest)))
                .onErrorResume(BusinessException.class, error -> ServerResponse.status(HttpStatus.CONFLICT).contentType(APPLICATION_JSON)
                        .bodyValue(ResponseDTO.failed(ErrorHandler.business(error), serverRequest)));}


    protected Mono<AccountDTO> accountDTOMono(ServerRequest serverRequest) {
        return Mono.just(setHeaders(serverRequest)).map(stringStringMap ->
                AccountDTO.builder().number(stringStringMap.get("number")).build())
                .switchIfEmpty(Mono.empty());}
}
