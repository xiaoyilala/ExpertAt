package com.ice.expertat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 类描述：间隔
 *
 */
@Aspect
public class ThrottleFirstAspectJ {

    private static final String POINTCUT_METHOD = "execution(@com.ice.expertat.ThrottleFirst * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void method() {
    }

    @Around("method() && @annotation(throttleFirst)")
    public Object aroundJoinPoint(final ProceedingJoinPoint joinPoint, ThrottleFirst throttleFirst) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String declaringTypeName = signature.getDeclaringTypeName();
        boolean hasReturnType = signature.getReturnType() != void.class;
        // 如果有返回值 不能拦截
        Object result = null;
        if(hasReturnType){
            result = joinPoint.proceed();
        }else if (!ExpertAt.isFastDoubleCall(declaringTypeName+method.getName(), throttleFirst.value())) {
            //不是多次调用，执行原方法
            joinPoint.proceed();
        }
        return result;

    }

}
