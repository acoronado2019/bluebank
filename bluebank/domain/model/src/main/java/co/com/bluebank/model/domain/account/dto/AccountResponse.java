package co.com.bluebank.model.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountResponse {
    private Integer id;
    private Integer balance;
    private Integer number;
    private String namePerson;
}
