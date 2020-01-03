package com.travel.api.aspect;

import com.travel.api.exception.FallBackException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName 降级服务消息切面处理
 * @Author liguangyao
 * @Date 20/8/18 上午1:11
 * @Version 1.0
 **/
@Aspect
@Component
public class FallBackAspect {

    private Logger logger = LoggerFactory.getLogger(FallBackAspect.class);

    @Pointcut("execution(* com.travel.api.service.fallBack.*.*(..))")
    public void annotationPointCut() {}

    @After(value = "annotationPointCut()")
    public void after(JoinPoint joinPoint) throws FallBackException {
        logger.error("方法名[{}]调用失败,服务已降级处理...",joinPoint.getSignature().getName());
        throw new FallBackException("方法名[" + joinPoint.getSignature().getName() +"]调用失败,服务已降级处理...");
    }

}
