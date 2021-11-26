package co.com.bluebank.model.domain.account.gateway;

import co.com.bluebank.model.domain.account.dto.AccountResponse;
import co.com.bluebank.model.dto.AccountRequest;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<AccountResponse> createAccount(AccountRequest accountRequest);
    Mono<AccountResponse> getBalance(String number);
    Mono<AccountResponse> consignment(AccountRequest accountRequest);
    Mono<AccountResponse> withdrawMoney(AccountRequest accountRequest);

}
