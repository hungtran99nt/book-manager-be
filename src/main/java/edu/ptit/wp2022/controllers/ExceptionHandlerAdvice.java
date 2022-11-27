package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.exceptions.BusinessException;
import edu.ptit.wp2022.exceptions.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponse> handleException(BusinessException e, HttpServletRequest request) {
        ErrorResponse error =
                new ErrorResponse(request.getRequestURI(), e.getHttpStatus().value(), e.getMessage(), new Date());
        return new ResponseEntity<>(error, e.getHttpStatus());
    }
}
