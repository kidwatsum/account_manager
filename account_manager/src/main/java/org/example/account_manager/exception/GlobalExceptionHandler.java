package org.example.account_manager.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This is a global exception handler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler method for EntityNotFound
     * exception
     *
     * @param e - the EntityNotFoundException
     *          parameter
     *
     * @return - returns the error message
     *          and the error code 404 NOT FOUND
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {

        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
