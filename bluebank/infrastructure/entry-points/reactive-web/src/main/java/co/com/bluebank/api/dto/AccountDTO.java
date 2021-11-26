package co.com.bluebank.api.dto;

import co.com.bluebank.model.dto.AccountRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountDTO {

    @NotNull(message = "campo obligatorio")
    @Size(min = 1, max = 50, message = "longitud maxima de 50 caracteres")
    private String number;

    private Integer balance;

    public Mono<AccountRequest> toModel() {
        return Mono.just(AccountRequest.builder()
                .number(this.number == null ? 0 :  Integer.valueOf(this.number))
                .balance(this.balance).build());
    }
}
