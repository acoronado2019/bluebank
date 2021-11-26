package co.com.bluebank.usecase.gestioncuenta.dataTest;


import co.com.bluebank.model.dto.AccountRequest;

public class DataTest {


    public static AccountRequest accountRequest(){
        return AccountRequest.builder()
                .number(1)
                .balance(253)
                .namePerson("Test")
                .initialValue(255D)
                .build();
    }
}
