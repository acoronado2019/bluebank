package co.com.bluebank.model.exception;

import co.com.bluebank.model.enums.BusinessExceptionEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    private final BusinessExceptionEnum exception;
}