package com.stark.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main (String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceImpl hello = (ServiceImpl) factory.getBean("service");

        hello.service("Pepper Potts");
    }
}
