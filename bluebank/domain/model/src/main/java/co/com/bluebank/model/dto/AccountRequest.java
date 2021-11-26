package co.com.bluebank.model.dto;

import co.com.bluebank.model.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class AccountRequest extends Request {

    private Long id;
    private String namePerson;
    private Double initialValue;
    private Integer number;
    private Integer balance;
}
