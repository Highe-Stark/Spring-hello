package com.stark.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class OrmRun {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-hibernate.xml");
        ICatDao catDao = (ICatDao) context.getBean("applicationContext-hibernate.xml");

        Cat cat = new Cat();
        cat.setName("Hello Kitty");
        cat.setCreateDate(new Date());

        catDao.createCat(cat);

        List<Cat> catList = catDao.listCats();
        for (Cat c : catList) {
            System.out.println("Name: " + c.getName());
        }
    }
}
