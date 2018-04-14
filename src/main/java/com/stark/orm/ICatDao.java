package com.stark.orm;

import java.util.List;

public interface ICatDao {                     // DAO interface
    public void createCat(Cat cat);            // save object
    public List<Cat> listCats();               // query all objects
    public int getCatsCount();                 // return number of objects
    public Cat findCatByName(String name);     // return wanted object according to name
}
