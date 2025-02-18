package com.applications.own.dataservices.exception;

import com.applications.own.dataservices.model.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@JsonRootName("Errors")
@Component
public class ErrorList implements Serializable {

    private static final long serialVersionUID = 1L;
    private String headerErrorMsg;
    public List<ErrorResponse> errors;
//            = new ArrayList<ErrorResponse>();
    public ErrorList(){
        super();
    }
    public ErrorList(List<ErrorResponse> errors){
        super();
        this.errors = errors;
    }
    public List<ErrorResponse> getErrors(){
        return errors;
    }

    public void setErrors(ErrorList errorList) {
        this.errors = errors;
    }
    public void addError(ErrorResponse error){
        this.getErrors().add(error);
    }
    public String getHeaderErrorMsg(){
        return headerErrorMsg;
    }
    public void setHeaderErrorMsg(String headerErrorMsg){
        this.headerErrorMsg = headerErrorMsg;
    }
}
