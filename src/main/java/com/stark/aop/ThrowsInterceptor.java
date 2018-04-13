package com.stark.aop;

import org.springframework.aop.ThrowsAdvice;

import javax.security.auth.login.AccountException;
import java.lang.reflect.Method;

// 异常拦截器
public class ThrowsInterceptor implements ThrowsAdvice {

    // method 1
    public void afterThrowing(Method method, Object[] args, Object instance, AccountException ex) throws Throwable {
        System.out.println("Method: " + method.getName() + " throws exception: " + ex);
    }

    // method 2
    public void afterThrowing(NullPointerException ex) throws Throwable {
        System.out.println("Exception thrown: " + ex);
    }
}
