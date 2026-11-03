package com.sio.backend.exception;

import com.sio.backend.generics.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * - EntityNotFoundException: Gestisce le eccezioni quando un'entità non viene trovata nel database. -> 404
 * - NoSuchElementException: Gestisce le eccezioni quando un elemento richiesto non esiste in una collezione o in un flusso di dati. -> 404
 * - MethodArgumentNotValidException: Gestisce le eccezioni quando i parametri di un metodo non sono validi. -> 400
 * - HttpMessageNotReadableException: Gestisce le eccezioni quando il corpo della richiesta HTTP non può essere letto correttamente. -> 400
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gestione delle eccezioni generali
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Imposta lo status HTTP della risposta a 500 Internal Server Error
    public ApiResponse<Void> handleAll(Exception ex) {

        List<StackTraceElement> errors = List.of(ex.getStackTrace());

        return ApiResponse.error(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "GENERIC_ERROR",
                ex.getStackTrace()[1].toString()
        );

        /* return ApiResponse.builder()
                .status(ApiResponseStatus.ERROR)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .errorCode(ex.getMessage())
                .build(); */
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(IllegalArgumentException ex) {
        ApiResponse<Void> body = ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(EntityNotFoundException ex) {
        return ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(NoSuchElementException ex) {
        return ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleMethNotValid(MethodArgumentNotValidException ex) {
        return ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleMethNotValid(HttpMessageNotReadableException ex) {
        return ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(TransactionSystemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleTransactionSystemException(TransactionSystemException ex) {
        return ApiResponse.fail(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

}
