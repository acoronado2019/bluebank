package co.com.bluebank.usecase.gestioncuenta;

import co.com.bluebank.model.domain.account.dto.AccountResponse;
import co.com.bluebank.model.domain.account.gateway.AccountRepository;
import co.com.bluebank.model.dto.AccountRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
public class AccountManagementUseCase {

    private final AccountRepository accountRepository;

    public Mono<AccountResponse> createAccount (AccountRequest accountRequest){
        return accountRepository.createAccount(accountRequest);
    }

    public Mono<AccountResponse> consignment (AccountRequest accountRequest){
        return accountRepository.consignment(accountRequest);
    }

    public Mono<AccountResponse> withdrawMoney (AccountRequest accountRequest){
        return accountRepository.withdrawMoney(accountRequest);
    }

    public Mono<AccountResponse> getBalance (Map<String, String> header){
        return accountRepository.getBalance(header.get("number"));
    }
}
