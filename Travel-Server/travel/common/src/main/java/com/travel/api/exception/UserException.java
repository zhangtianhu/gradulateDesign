package com.travel.api.exception;

public class UserException extends Exception {
    private static final long serialVersionUID = 3L;

    private Integer code;

    public UserException(){
        super();
    }

    public UserException(String message){
        super(message);
    }

    public UserException(String message,Integer code){
        super(message);
        this.code = code;
    }

    public UserException(Throwable cause){
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
