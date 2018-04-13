package com.stark.aop;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

// 方法后拦截器
public class MethodAfterInterceptor implements AfterReturningAdvice {

    // method implementation
    public void afterReturning(Object value, Method method, Object [] args, Object instance) throws Throwable {
        System.out.println("Method: " + method.getName() + " completed, return value: " + value);
    }
}
