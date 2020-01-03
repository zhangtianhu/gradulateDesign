package com.travel.api.handler;

import com.travel.api.exception.FallBackException;
import com.travel.api.util.CommonUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @ClassName 全局异常处理请求头
 * @Author liguangyao
 * @Date 20/8/18 上午11:56
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exception(Exception e) {
        return CommonUtil.getFailResult(e.getMessage());
    }


    // TODO 无法捕获到自定义FallBackException, 有空再研究一波
    @ExceptionHandler(value = FallBackException.class)
    public Map<String, Object> fallBackException(FallBackException e) {
        return CommonUtil.getFailResult(e.getMessage());
    }
}
