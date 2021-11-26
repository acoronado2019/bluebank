package co.com.bluebank.model;

import co.com.bluebank.model.enums.BusinessExceptionEnum;
import co.com.bluebank.model.enums.TechnicalExceptionEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnumTest {

    @Test
    public void technicalExceptionEnumGetType(){
        assertThat(TechnicalExceptionEnum.TECHNICAL_SAVE.getMessage()).isNotNull();
        assertThat(TechnicalExceptionEnum.TECHNICAL_SAVE.getCode()).isEqualTo(TechnicalExceptionEnum.TECHNICAL_SAVE.getCode());
    }

    @Test
    public void enumTest(){
        assertThat(BusinessExceptionEnum.APPLICATION_NOT_FOUND).isNotNull();
    }
}
