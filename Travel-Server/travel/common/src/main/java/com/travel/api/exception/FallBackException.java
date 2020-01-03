package com.travel.api.exception;

/**
 * @ClassName FallBackException
 * @Author liguangyao
 * @Date 20/8/18 下午12:00
 * @Version 1.0
 **/
public class FallBackException extends Exception {
    private static final long serialVersionUID = 3L;

    private Integer code;
    private String msg;

    public FallBackException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public FallBackException(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
