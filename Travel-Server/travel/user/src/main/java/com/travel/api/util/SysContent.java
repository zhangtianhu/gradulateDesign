package com.travel.api.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SysContent
 * @Author liguangyao
 * @Date 30/5/18 下午3:26
 * @Version 1.0
 **/
public final class SysContent {

    //该类通过拦截器将每个请求的request和response对象放入ThreadLocal中方便其他的类中调用

    private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<>();

    public static HttpServletRequest getRequest() {
        return requestLocal.get();
    }

    public static void setRequest(HttpServletRequest request) {
        requestLocal.set(request);
    }

    public static HttpServletResponse getResponse() {
        return responseLocal.get();
    }

    public static void setResponse(HttpServletResponse response) {
        responseLocal.set(response);
    }
}
