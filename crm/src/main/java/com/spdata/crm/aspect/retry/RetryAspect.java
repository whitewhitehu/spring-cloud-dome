package com.spdata.crm.aspect.retry;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @auther yangqifang
 * @data 2018/12/2720:54
 **/
@Aspect
@Component
@Log
public class RetryAspect {
    @Pointcut("@annotation(Retry))")
    public void Pointcut() {
    }

    @Around("Pointcut()")
    public Object retry(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Retry retry = methodSignature.getMethod().getAnnotation(Retry.class);
        Object resl = false;

        try {
            resl = methodSignature.getReturnType().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int number = 1;
        for (int falg = retry.number(); falg > 0; falg--) {
            try {
                resl = joinPoint.proceed();
                break;
            } catch (Throwable throwable) {
                log.warning(throwable.getMessage());
                log.warning("重试方法:" + methodSignature.getName());
                log.warning("第" + (number++) + "次");
            }
        }
        return resl;
    }
}
