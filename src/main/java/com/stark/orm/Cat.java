package com.stark.orm;

// import com.sun.javafx.beans.IDProperty;
import java.util.Date;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table (name= "tb_cat")
public class Cat {

    @Id                                               // Primary key config
    @GeneratedValue(strategy = GenerationType.AUTO)   // Primary key rule config
    private Integer id;

    private String name;
    private Date createDate;
    @Temporal (value = TemporalType.TIMESTAMP)        // type of column is timestamp
    private Date createdDate;

    public void setId(Integer id) {
        this.id = Integer.valueOf((int) id);
    }

    public void setCreateDate(Date date) {
        this.createDate = (Date) date.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
}
