package com.sio.backend.generics;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Collection;

@Data // Annotazione Lombok per generare i metodi getter, setter, toString, equals e hashCode
@Builder // Annotazione Lombok per generare un builder per la classe
@NoArgsConstructor // Annotazione Lombok per generare un costruttore senza argomenti
@AllArgsConstructor // Annotazione Lombok per generare un costruttore con tutti gli argomenti
@JsonInclude(JsonInclude.Include.NON_NULL) // Annotazione Jackson per escludere i campi null dalla serializzazione JSON
public class ApiResponse<T> {
    private ApiResponseStatus status;
    private Integer statusCode;
    private Instant timestamp;

    private T data; // Generic type to hold any data

    private String message;
    private String errorCode;
    private String stackTrace;

    // -- SUCCESS --, funzione per creare una risposta di successo con i dati forniti
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.SUCCESS)
                .statusCode(HttpStatus.OK.value())
                .timestamp(Instant.now())
                .data(data)
                .build();
    }

    public static <T extends Collection<?>> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.SUCCESS)
                .statusCode(HttpStatus.OK.value())
                .timestamp(Instant.now())
                .data(data)
                .build();
    }

    // -- ERROR --
    public static <T> ApiResponse<T> error(String message, Integer statusCode) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.ERROR)
                .statusCode(statusCode)
                .timestamp(Instant.now())
                .message(message)
                .build();
    }

    // Overload di ERROR per includere anche stackTrace e errorCode se necessari
    public static <T> ApiResponse<T> error(String message, Integer statusCode, String errorCode, String stackTrace) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.ERROR)
                .statusCode(statusCode)
                .timestamp(Instant.now())
                .message(message)
                .errorCode(errorCode)
                .stackTrace(stackTrace)
                .build();
    }

    // -- FAIL --
    public static <T> ApiResponse<T> fail(String message, Integer code) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.FAIL)
                .timestamp(Instant.now())
                .message(message)
                .statusCode(code)
                .build();
    }

    // Overload di FAIL nel caso in cui il fail contenga una lista di errori (es. Validazioni dei campi)
    public static <T extends Collection<?>> ApiResponse<T> fail(String message, Integer statusCode, String errorCode) {
        return ApiResponse.<T>builder()
                .status(ApiResponseStatus.FAIL)
                .message(message)
                .statusCode(statusCode)
                .timestamp(Instant.now())
                .errorCode(errorCode)
                .build();
    }
}
