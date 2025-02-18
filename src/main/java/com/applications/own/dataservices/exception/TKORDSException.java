package com.applications.own.dataservices.exception;

import com.applications.own.dataservices.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Component
public class TKORDSException extends Exception{

    @Autowired
    private ErrorList errorList;
    
    private static final long serialVersionUID = 1L;
//    private ErrorList errorList  = new ErrorList();

    public TKORDSException(){
        super();
    }
    public TKORDSException(String message){
        super(message);
    }
//    public TKORDSException(ErrorList errorList){
//        super(String.valueOf(errorList));
//    }
    public TKORDSException(String message, Throwable e){
        super(message, e);
    }

    public TKORDSException(Throwable e){
        super(e);
    }

    public ErrorList getErrorList()throws TKORDSException {
        return this.errorList;
    }

    public void setErrorList(ErrorList errorList) throws TKORDSException {
        this.errorList = errorList;
    }
//
//    @ExceptionHandler(EmailCheckException.class)
//    public ResponseEntity<String> handleEmailCheckException(EmailCheckException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//    }

//    @ExceptionHandler(EmailCheckException.class)
//    public ResponseEntity<String> errorList(ErrorList errorList) {
//        return new ResponseEntity<>(errorList.getErrors().toString(), HttpStatus.CONFLICT);
//    }
}
