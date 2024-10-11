package houseInception.gptComm.exception;

import houseInception.gptComm.response.BaseErrorResponse;
import houseInception.gptComm.response.status.BaseErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.NoSuchElementException;

import static houseInception.gptComm.response.status.BaseErrorCode.*;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class, TypeMismatchException.class})
    public ResponseEntity<BaseErrorResponse> handleBadRequest(Exception e) {
        log.error("Bad Request Exception: {}", e.getMessage(), e);
        return BaseErrorResponse.get(BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BaseErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e) {
        log.error("Method Not Allowed Exception: {}", e.getMessage(), e);
        return BaseErrorResponse.get(METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({IllegalArgumentException.class, IOException.class})
    public ResponseEntity<BaseErrorResponse> handleInternalServerError(Exception e) {
        log.error("Internal Server Error: {}", e.getMessage(), e);
        return BaseErrorResponse.get(INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<BaseErrorResponse> handleNoSuchElementException(NoSuchElementException e) {
        log.error("No Such Element Exception: {}", e.getMessage(), e);
        return BaseErrorResponse.get(NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseErrorResponse> handleRuntimeException(RuntimeException e) {
        log.error("Runtime Exception: {}", e.getMessage(), e);
        return BaseErrorResponse.get(INTERNAL_SERVER_ERROR);
    }
}