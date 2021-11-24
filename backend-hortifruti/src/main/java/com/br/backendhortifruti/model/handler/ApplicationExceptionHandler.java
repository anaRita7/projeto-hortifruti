package com.br.backendhortifruti.model.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity npException(Exception e){
        return new ResponseEntity("Não encontrado!", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(IvalidDocumentException.class)
    public ResponseEntity docException(Exception e){
        return new ResponseEntity("Documento inválido", HttpStatus.EXPECTATION_FAILED);
    }

}
