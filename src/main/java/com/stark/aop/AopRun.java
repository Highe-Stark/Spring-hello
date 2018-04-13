package com.stark.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopRun {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*
         * class name must match what it is in .xml
         * ProxyFactoryBean
         *  |- property
         *     |- target
         *         |- class name
         */
        IAopService hello = (IAopService) context.getBean("aopService");

        hello.withAop();
        hello.withoutAop();
    }
}
