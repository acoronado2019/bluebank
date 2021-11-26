package co.com.bluebank.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TechnicalExceptionEnum {

    TECHNICAL_SAVE("", "Error al guardar la aplicacion"),
    TECHNICAL_METHOD_NOT_SUPPORTED("","Metodo no soportado"),
    TECHNICAL_UNSUPPORTED_MEDIA_TYPE("","Tipo de formato no compatible"),
    TECHNICAL_INVALID_PARAMETER_VALUE("","Datos de entrada incorrectos"),
    TECHNICAL_CONSTRAINT_VIOLATION("","Datos de entrada no cumplen las validaciones"),
    TECHNICAL_INVALID_BODY_PARAMETER("","Datos de la peticion no son validos"),
    TECHNICAL_MISSING_PARAMETER("","Parametros incompletos, ingresar el c�digo de la aplicaci�n"),
    TECHNICAL_SECRET_EXCEPTION("", "Error obteniendo los secretos de AWS");

    private final String code;
    private final String message;
}
