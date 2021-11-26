package co.com.bluebank.adapter;

import co.com.bluebank.model.domain.account.dto.AccountResponse;
import co.com.bluebank.model.domain.account.gateway.AccountRepository;
import co.com.bluebank.model.dto.AccountRequest;
import co.com.bluebank.repository.IAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class AccountAdapter implements AccountRepository {

    private final IAccountRepository iAccountRepository;

    @Override
    public Mono<AccountResponse> createAccount(AccountRequest accountRequest) {
        return iAccountRepository.createAccount(accountRequest.getNamePerson(), accountRequest.getInitialValue(), accountRequest.getNumber());
    }

    @Override
    public Mono<AccountResponse> getBalance(String number) {
        return iAccountRepository.getBalance(Integer.valueOf(number))
                .map(accountData ->  AccountResponse.builder().balance(accountData.getBalance()).namePerson(accountData.getNamePerson()).build());
    }

    @Override
    public Mono<AccountResponse> consignment(AccountRequest accountRequest) {
        return iAccountRepository.consignment(accountRequest.getNumber(), accountRequest.getBalance())
                .map(accountData -> AccountResponse.builder().balance(accountData.getBalance()).number(accountRequest.getNumber()).build());

    }

    @Override
    public Mono<AccountResponse> withdrawMoney(AccountRequest accountRequest) {
        return iAccountRepository.withdrawMoney(accountRequest.getNumber(), accountRequest.getBalance())
                .map(accountData -> AccountResponse.builder().balance(accountData.getBalance()).number(accountRequest.getNumber()).build());

    }
}
