package com.applications.own.dataservices.exception;

public class TKORDSException extends Exception{
    private static final long serialVersionUID = 1L;
    private ErrorList errorList = new ErrorList();
    public TKORDSException(){
        super();
    }
    public TKORDSException(String message){
        super(message);
    }
    public TKORDSException(String message, Throwable e){
        super(message, e);
    }
    public TKORDSException(Throwable e){
        super(e);
    }

    public ErrorList getErrorList(){
        return errorList;
    }
    public void setErrorList(ErrorList errorList){
        this.errorList = errorList;
    }
}
