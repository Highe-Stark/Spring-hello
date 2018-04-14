package com.stark.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class DaoRun {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Person.xml");
        IPersonDao personDao = (IPersonDao) context.getBean("personDao");

        Person person = new Person();
        person.setName("Pepper Potts");
        person.setAge(26);
        person.setSex("Female");
        person.setBirthday(new Date(10000));

        String[] names = new String[]{"Happy Hogan", "Tony Stark", "Steven Rogers"};
        int[] ages = new int[]{32, 35, 89};
        Date[] dates = new Date[]{new Date(12345), new Date(12588), new Date(30065)};

        personDao.addPerson(person);

        for (int i = 0; i != 3; i++) {
            person.setName(names[i]);
            person.setAge(ages[i]);
            person.setSex("Male");
            person.setBirthday(dates[i]);
            personDao.addPerson(person);
        }

        System.out.println("Count: " + personDao.getPersonsCount());
        System.out.println(personDao.getPersonName(1));
        List<Person> personList = personDao.listPersons();

        for (Person p : personList) {
            System.out.println("Name: " + p.getName());
        }
    }
}
