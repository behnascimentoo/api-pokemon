package com.pokemon.api_pokemon.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class ErrorMessage {
    private String path;
    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,String> errors;

    public ErrorMessage(HttpServletRequest request, HttpStatus statusCode, String message){
        this.statusCode = statusCode.value();
        this.message = message;
        this.path = request.getRequestURI();
    }

    public ErrorMessage(HttpServletRequest request, HttpStatus statusCode, String message, BindingResult bindingResult){
        this.statusCode = statusCode.value();
        this.message = message;
        this.path = request.getRequestURI();
        addErrors(bindingResult);
    }

    private void addErrors(BindingResult bindingResult) {
        this.errors = new HashMap<>();

        for(FieldError fieldError : bindingResult.getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
