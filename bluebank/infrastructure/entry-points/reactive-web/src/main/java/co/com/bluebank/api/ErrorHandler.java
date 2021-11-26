package co.com.bluebank.api;


import co.com.bluebank.api.dto.ErrorDTO;
import co.com.bluebank.model.exception.BusinessException;
import co.com.bluebank.model.exception.TechnicalException;

public class ErrorHandler {

    public static ErrorDTO business(BusinessException object) {
        return ErrorDTO.builder()
                .id(object.getException().toString())
                .type("Business")
                .title(object.getException().getTitle())
                .detail(object.getException().getDetail())
                .source("sigecbluebank")
                .build();
    }

    public static ErrorDTO technical(TechnicalException object) {
        return ErrorDTO.builder()
                .id(object.getTechnicalExceptionEnum().toString())
                .type("Technical")
                .code(object.getTechnicalExceptionEnum().getCode())
                .title(object.getTechnicalExceptionEnum().getMessage())
                .detail(object.getMessage())
                .source("sigecbluebank")
                .build();
    }
}
