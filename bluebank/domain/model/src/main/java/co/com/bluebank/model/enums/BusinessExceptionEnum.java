package co.com.bluebank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessExceptionEnum {

    CATEGORY_NOT_FOUND( "No existe la categoria", "No se encuentra ninguna categoria con este codigo o id"),
    DELETED_CONSUMER("Consumidor eliminado","El consumidor ha sido eliminado previamente"),
    NOT_CATEGORIES_TO_JOIN("No hay categorias asociadas", "Debe haber por lo menos una categoria para asociar"),
    DELETED_CATEGORY("Categoria eliminada", "Esta categoria fue eliminada"),
    CONSUMER_NOT_FOUND( "No existe el consumidor", "No se encuentra ningun consumidor con los parametros dados"),
    APPLICATION_CATEGORY_NOT_FOUND("No existe el application category", "No existe un application category con el que se quiere relacionar"),
    CONSUMER_ALREADY_CREATED("Consumidor existente", "El consumidor ya existe"),
    INVALID_CODE("Codigo no valido","%s"),
    INVALID_NAME("Nombre no valido","%s"),
    INVALID_DESCRIPTION("Descripcion no valida","%s"),
    INVALID_STATUS("Estado no valido", "%s"),
    PROVIDER_NAME_ALREADY_CREATED("Nombre del proveedor ya existe", "%s"),
    INVALID_MULTI_USER("Dato multiuser invalido", "%s"),
    INVALID_PROVIDER_CLIENT_SECRET("Provider client secret no valido", "%s"),
    INVALID_PROVIDER_APPLICATION_ID("Provider application id no es valido", "%s"),
    INVALID_PROVIDER_APPLICATION_KEY("Provider application Key no es valido", "%s"),
    APPLICATION_ALREADY_CREATED("Applicacion ya existente", "La aplicacion ya existe"),
    PROVIDER_NOT_FOUND("No existe el proveedor", "No se encuentra ningun proveedor con este Id"),
    PROVIDER_ALREADY_CREATED("Proveedor ya existente", "Proveedor ya existente"),
    APPLICATION_NOT_FOUND("No existe la aplicaci�n", "No se encuentra ninguna aplicacion con este codigo"),
    CATEGORY_ALREADY_CREATED("Categoria ya existente","Categoria ya creada");

    private String title;
    private String detail;

}
