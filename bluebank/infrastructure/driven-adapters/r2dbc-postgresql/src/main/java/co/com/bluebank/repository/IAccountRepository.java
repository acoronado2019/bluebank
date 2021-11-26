package co.com.bluebank.repository;

import co.com.bluebank.data.AccountData;
import co.com.bluebank.model.domain.account.dto.AccountResponse;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IAccountRepository extends ReactiveCrudRepository<AccountData, Long> {

    @Query("INSERT INTO bluebank.account(name_person, initial_value, number, balance) " +
            "VALUES (:namePerson, :initialValue, :number, :initialValue) returning id")
    Mono<AccountResponse> createAccount(String namePerson, Double initialValue, Integer number);

    @Query("SELECT * FROM bluebank.account WHERE (:number is null or number=:number)")
    Mono<AccountData> getBalance(@Param("number") Integer number);


    @Query("UPDATE bluebank.account SET balance= balance + :balance  WHERE number=:number returning balance")
    Mono<AccountResponse> consignment(@Param("number") Integer number, @Param("balance") Integer balance);

    @Query("UPDATE bluebank.account SET balance= balance - :balance  WHERE number=:number returning balance")
    Mono<AccountResponse> withdrawMoney(@Param("number") Integer number, @Param("balance") Integer balance);
}
