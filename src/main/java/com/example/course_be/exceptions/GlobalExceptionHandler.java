package com.example.course_be.exceptions;

import com.example.course_be.response.error.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<?>> handleAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = {
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse<?>> handleValidationExceptions(Exception exception) {
        String message = extractValidationMessage(exception);
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setMessage("Validation failed: " + message);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    private String extractValidationMessage(Exception exception) {
        if (exception instanceof ConstraintViolationException) {
            return ((ConstraintViolationException) exception).getConstraintViolations()
                    .stream()
                    .map(violation -> violation.getMessage())
                    .collect(Collectors.joining(", "));
        } else if (exception instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) exception).getBindingResult().getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
        } else {
            throw new IllegalArgumentException("Unexpected validation exception type");
        }
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericException(Exception exception) {
        log.error("Exception: ", exception);
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
        return ResponseEntity.internalServerError().body(apiResponse);
    }
}