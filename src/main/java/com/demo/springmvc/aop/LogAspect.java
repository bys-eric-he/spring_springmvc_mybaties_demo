package com.demo.springmvc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger log = Logger.getLogger("info");

    /**
     * @Fields methodName : 请求方法
     */
    private String methodName = null;

    /**
     * @Fields inputParam : 方法入参数
     */
    private Object[] inputParam = null;

    /**
     * @Fields outputParam : 方法出参
     */
    private Object outputParam = null;


    /**
     * doAround 拦截API请求 环绕触发
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        methodName = joinPoint.getSignature().toLongString();
        inputParam = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            outputParam = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("API服务Action方法执行异常！方法名称->".concat(methodName), e);
        }

        long endTime = System.currentTimeMillis();
        log.info("AOP End->".concat("方法执行耗时->" + (endTime - startTime) + " ms"));
        return outputParam;
    }
}
