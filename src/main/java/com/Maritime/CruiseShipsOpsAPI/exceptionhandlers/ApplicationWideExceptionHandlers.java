package com.Maritime.CruiseShipsOpsAPI.exceptionhandlers;


import com.Maritime.CruiseShipsOpsAPI.exception.OperationNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.PortNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.ShipNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationWideExceptionHandlers {

    @ExceptionHandler(ShipNotFoundException.class)
    public ResponseEntity<StandardResponse> shipNotFoundExceptionHandler(RuntimeException ex){
        return new ResponseEntity<>(
                new StandardResponse(
                        404 , ex.getMessage(), null
                ),HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PortNotFoundException.class)
    public ResponseEntity<StandardResponse> portNotFoundExceptionHandler(RuntimeException ex){
        return new ResponseEntity<>(
                new StandardResponse(
                        404 , ex.getMessage(), null
                ),HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(OperationNotFoundException.class)
    public ResponseEntity<StandardResponse> operationNotFoundException(RuntimeException ex){
        return new ResponseEntity<>(
                new StandardResponse(
                        404 , ex.getMessage(), null
                ),HttpStatus.NOT_FOUND
        );
    }

}
