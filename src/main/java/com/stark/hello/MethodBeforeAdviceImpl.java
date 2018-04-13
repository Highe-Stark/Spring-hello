package com.stark.hello;

import java.util.Arrays;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {
    // Implementation of Interceptor interface
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        System.out.println("Check before running ...");
        System.out.println("Method: " + method.getName()); // Output method name
        System.out.println("Args: " + Arrays.asList(args)); // Output method arguments
        System.out.println("Object: " + obj);
    }
}
