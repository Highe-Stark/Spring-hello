package com.stark.dao;

import java.util.Date;

public class Person {
    private Integer id;
    private String name;
    private String sex;
    private int age;
    private Date birthday;

    public void setId(Integer _id){
        this.id = _id;
    }

    public Integer getId () {
        return this.id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public void setSex( String _sex) {
        this.sex = _sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setAge(Integer _age) {
        this.age = _age;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setBirthday(Date _birthday) {
        this.birthday = (Date) _birthday.clone();
    }

    public Date getBirthday() {
       return (Date) this.birthday.clone();
    }
}
