package com.stark.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TransactionRun {
    private IPersonDao personDao;

    public IPersonDao getPersonDao() {
        return this.personDao;
    }

    public void setPersonDao(IPersonDao personDao) {
        this.personDao = personDao;
    }

    public void run () {
        Person person = new Person();
        person.setName("Transaction Roll back");
        person.setAge(30);
        person.setSex("male");
        person.setBirthday(new Date(12345678));

        personDao.addPerson(person);
        System.out.println("Count: " + personDao.getPersonsCount());

        System.out.println(personDao.getPersonName(Integer.MAX_VALUE));   // Exception will throw here
        // exception occurred in the transaction, roll back
        List<Person> personList = personDao.findAllPersons(); // query for all persons
        for (Person p : personList) {
            System.out.println("Name: " + p.getName());
        }
    }

    public static void main(String[] args) {
        /*
         * XmlBeanFactory is deprecated
         * Using ClassPathXmlApplicationContext instead
         */
        // ApplicationContext context = new XmlBeanFactory(new ClassPathResource("applicationContext-Person.xml"));
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Person.xml");
        TransactionRun transactionRun = (TransactionRun) context.getBean("transactionRun");
        transactionRun.run();
    }
}
