package co.com.bluebank.model;

import co.com.bluebank.model.enums.TechnicalExceptionEnum;
import co.com.bluebank.model.exception.TechnicalException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TechnicalExceptionTest {

    @Test
    public void exceptionStructureTest(){
        TechnicalExceptionEnum exception = TechnicalExceptionEnum.TECHNICAL_METHOD_NOT_SUPPORTED;
        TechnicalException appExc = new TechnicalException(TechnicalExceptionEnum.TECHNICAL_METHOD_NOT_SUPPORTED);
        assertThat(appExc).isNotNull();
        assertThat(appExc.getTechnicalExceptionEnum().getMessage()).isEqualTo(exception.getMessage());
        assertThat(appExc.getTechnicalExceptionEnum().getCode()).isEqualTo(exception.getCode());
    }

    @Test
    public void exceptionTest(){
        TechnicalException exception = new TechnicalException(TechnicalExceptionEnum.TECHNICAL_METHOD_NOT_SUPPORTED);
        assertThat(exception.getTechnicalExceptionEnum().getMessage()).isEqualTo(exception.getTechnicalExceptionEnum().getMessage());
    }
}
