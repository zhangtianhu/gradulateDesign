package com.travel.api.exception;

public class BaseException extends Exception {

    private static final long serialVersionUID = 3L;

    private Integer code;

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(String message,Integer code){
        super(message);
        this.code = code;
    }

    public BaseException(Throwable cause){
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
