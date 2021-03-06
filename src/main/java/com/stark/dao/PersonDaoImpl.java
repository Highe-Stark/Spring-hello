package com.stark.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {
    // inherit Support

    public void initDatabase() {
        String sql = " create table if not exists tb_person "   // SQL statement
            + " (id int auto_increment, " + " name varchar(255), " + " sex varchar(10), age int, "
            + " birthday timestamp, primary key (id) );";
        getJdbcTemplate().execute(sql);
    }

    @SuppressWarnings("all")
    public List<Person> listPersons() {
        String sql = " select id, name, sex, age, birthday from tb_person";
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        List<Person> personList = new ArrayList<Person>();

        for (Map<String, Object> row: list) {
            Person person = new Person();
            person.setId((Integer) row.get("id"));
            person.setName((String) row.get("name"));
            person.setSex((String) row.get("sex"));
            person.setBirthday((Date) row.get("birthday"));
            person.setAge((Integer) row.get("age"));

            personList.add(person);
        }
        return personList;
    }

    public void addPerson(Person person) {
        String sql = " insert into tb_person ( name, sex, age, birthday ) "
                + " values ( ? , ?, ?, ? ) ;";
        getJdbcTemplate().update (sql, new Object[] {
                person.getName(), person.getSex(), person.getAge(), person.getBirthday(),
        });
    }

    public String getPersonName(Integer id) {
        String sql = " select name from tb_person where id = " + id;

        return (String) getJdbcTemplate().queryForObject(sql, String.class);
    }

    public int getPersonsCount() {
        String sql = " select count(*) from tb_person ";
        return (int) getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    // rewrite List method
    public List findAllPersons() {
        PersonMappingQuery personQuery = new PersonMappingQuery();   // encapsulate the query
        personQuery.setDataSource(getDataSource());
        personQuery.setSql(" select * from tb_person ");   // set SQL
        /*
         * set parameters via declareParameter(...) function
         * * example
         * * private class CustomerMappingQuery extends MappingSqlQuery {
         * *
         * * public CustomerMappingQuery(DataSource ds) {
         * *             super(ds, "SELECT id, name FROM customer WHERE id = ?");
         * *         super.declareParameter(new SqlParameter("id", Types.INTEGER));
         * *         compile();
         * *     }
         * *
         * *     public Object mapRow(ResultSet rs, int rowNumber) throws SQLException {
         * *         Customer cust = new Customer();
         * *         cust.setId((Integer) rs.getObject("id"));
         * *         cust.setName(rs.getString("name"));
         * *         return cust;
         * *     }
         * * }
         */
        // personQuery.declareParameter(new SqlParameter (java.sql.Types.NUMERIC));
        personQuery.compile();

        return personQuery.execute(new Object[] {});
    }
}
