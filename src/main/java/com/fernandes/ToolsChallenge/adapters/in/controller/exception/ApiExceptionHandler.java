package com.fernandes.ToolsChallenge.adapters.in.controller.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fernandes.ToolsChallenge.application.core.exception.ApiException;
import com.fernandes.ToolsChallenge.application.core.exception.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
        StandardError erro = new StandardError();
        erro.setCodigo(404);
        erro.setMensagem(e.getMsg());
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<StandardError> apiException(ApiException e){
        StandardError erro = new StandardError();
        erro.setCodigo(e.getCodigo());
        erro.setMensagem(e.getMsg());
        return ResponseEntity.status(erro.getCodigo()).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));
        return ResponseEntity.status(e.getStatusCode()).body(errors);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException e){
        Throwable cause = e.getCause();
        StandardError erro = new StandardError();

        if (cause instanceof InvalidFormatException invalidFormat) {

            Class<?> targetType = invalidFormat.getTargetType();

            if (targetType.isEnum()) {
                Object[] valores = targetType.getEnumConstants();
                erro.setCodigo(400);
                erro.setMensagem("Valor inválido para enum. Valores permitidos: " + Arrays.toString(valores));
                return ResponseEntity.status(erro.getCodigo()).body(erro);
            }

            if (targetType.getSimpleName().equals("LocalDateTime")) {
                erro.setCodigo(400);
                erro.setMensagem("Formato de data inválido. Use: dd/MM/yyyy HH:mm:ss");
                return ResponseEntity.status(erro.getCodigo()).body(erro);
            }
        }

        erro.setCodigo(400);
        erro.setMensagem("Erro no formato do JSON enviado.");
        return ResponseEntity.status(erro.getCodigo()).body(erro);
    }




}
