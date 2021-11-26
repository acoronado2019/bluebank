package co.com.bluebank.usecase.gestioncuenta;

import co.com.bluebank.model.domain.account.dto.AccountResponse;
import co.com.bluebank.model.domain.account.gateway.AccountRepository;
import co.com.bluebank.usecase.gestioncuenta.dataTest.DataTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountManagementUseCaseTest {

    @InjectMocks
    private AccountManagementUseCase accountManagementUseCaseTest;

    @Mock
    private AccountRepository accountRepository;

    @BeforeAll
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenAccountSuccessfulTest(){
        Mockito.when(accountRepository.createAccount(DataTest.accountRequest()))
                .thenReturn(Mono.just(AccountResponse.builder().number(1).namePerson("test").build()));
        StepVerifier.create(accountManagementUseCaseTest.createAccount(DataTest.accountRequest())).assertNext(accountResponse -> {
            Assertions.assertThat(accountResponse).isInstanceOf(AccountResponse.class);
        }).verifyComplete();
    }
}
