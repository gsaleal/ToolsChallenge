package com.toolschallenge.toolschallenge.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTransactionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleInvalidTransaction(InvalidTransactionException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidEnumValue(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        Map<String, String> response = new HashMap<>();

        if (cause instanceof InvalidFormatException invalidFormatException) {
            Class<?> targetType = invalidFormatException.getTargetType();

            if (targetType.isEnum()) {
                response.put("error", "Valor inválido para o campo tipo.");
                response.put("message", "Os valores permitidos são: " + getEnumValues(targetType));
                return ResponseEntity.badRequest().body(response);
            }
        }

        response.put("error", "Requisição inválida");
        response.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    private String getEnumValues(Class<?> enumType) {
        Object[] enumConstants = enumType.getEnumConstants();
        StringBuilder values = new StringBuilder();
        for (Object constant : enumConstants) {
            values.append(constant.toString()).append(", ");
        }
        return values.substring(0, values.length() - 2); // Remove a última vírgula
    }
}

