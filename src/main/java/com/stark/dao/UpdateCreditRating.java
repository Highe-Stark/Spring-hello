package com.stark.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateCreditRating extends SqlUpdate {
    public UpdateCreditRating(DataSource ds) {
        setDataSource(ds);
        setSql("update customer set credit_rating = ? where id = ? ");

        declareParameter(new SqlParameter(Types.NUMERIC));
        declareParameter(new SqlParameter(Types.NUMERIC));
        compile();
    }

    public int run(int id, int rating) {
        /*
         * Integer(int) is deprecated,
         * Integer.valueOf(int) is a better option.
         * Integer.valueOf(int) is a static Factory function.
         */
        // Object[] params = new Object[] { new Integer(rating), new Integer(id)};
        Object[] params = new Object[] {Integer.valueOf(rating), Integer.valueOf(id)};
        return update(params);
    }

    /*
     * SqlFunction 返回单一行的查询结果
     * public int countRows() {
     *      SqlFunction sf = new SqlFunction(dataSource, " select count(*) from mytable ");
     *      sf.compile();
     *      return sf.run;
     * }
     */
}
