package com.stark.aop;

import com.stark.aop.AopServiceImpl;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class MethodBeforeInterceptor implements MethodBeforeAdvice {
    public void before(Method method, Object [] args, Object instance) throws Throwable {
        System.out.println("The method going to invoke: " + method.getName());

        if (instance instanceof AopServiceImpl) {   // if service
            String name = ((AopServiceImpl) instance).getName();   // get name

            if (name == null)
                throw new NullPointerException("name attribute is not allowed to be null");
        }
    }
}
