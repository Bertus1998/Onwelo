package com.example.onwelo.controller;

import com.example.onwelo.exception.EntityNotFoundException;
import com.example.onwelo.exception.NotValidStringException;
import com.example.onwelo.model.ErrorRs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//@Slf4j
public class AdvisorController {
    @ExceptionHandler(NotValidStringException.class)
    public ResponseEntity<ErrorRs> handleNotValidStringException(NotValidStringException notValidStringException){
//        log.info(notValidStringException.getMessage());
        return ResponseEntity.internalServerError().body(new ErrorRs().errorCode(500).comment(notValidStringException.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorRs> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
//        log.info(entityNotFoundException.getMessage());
        return ResponseEntity.internalServerError().body(new ErrorRs().errorCode(500).comment(entityNotFoundException.getMessage()));
    }
}
