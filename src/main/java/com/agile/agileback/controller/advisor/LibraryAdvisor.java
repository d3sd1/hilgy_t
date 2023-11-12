package com.agile.agileback.controller.advisor;

import com.agile.agileback.exception.BookAlreadyExistsException;
import com.agile.agileback.exception.BookLendException;
import com.agile.agileback.exception.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LibraryAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}