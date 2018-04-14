package com.stark.dao;

import org.springframework.jdbc.object.MappingSqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMappingQuery extends MappingSqlQuery {
    @Override
    protected Object mapRow (ResultSet rs, int columnIndex) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setAge(rs.getInt("age"));
        person.setSex(rs.getString("sex"));
        person.setBirthday(rs.getTimestamp("birthday"));
        return person;
    }
}
