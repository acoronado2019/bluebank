package co.com.bluebank.model.exception;

import co.com.bluebank.model.enums.TechnicalExceptionEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TechnicalException extends RuntimeException {

    private final TechnicalExceptionEnum technicalExceptionEnum;

    public TechnicalException(Throwable cause, TechnicalExceptionEnum message){
        super(cause);
        this.technicalExceptionEnum = message;
    }

}

