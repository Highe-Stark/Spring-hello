package com.stark.orm;

//import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
// import net.sf.hibernate.Session;
import java.util.List;

public class CatDaoImpl extends HibernateDaoSupport implements ICatDao
{
    // inherit Support

    public void createCat(Cat  cat) {                     // save the object
        this.getHibernateTemplate().persist(cat);         // save with Template
    }

    public int getCatsCount() {
        // ????????????????????????????????????????
        Number n = (Number) this.getSession(true).createQuery(

                " select count(c) from Cat c "
        ).uniqueResult();
        return n.intValue();
    }

    public List<Cat> listCats() {
        return this.getHibernateTemplate().find(" select c from Cat c ");   // query with Template
    }

    public Cat findCatByName (String name) {
        List<Cat> catList = this.getHibernateTemplate().find(
                " select c from Cat c where c.name = ? ", name
        );
        if (catList.size() > 0)
            return catList.get(0);
        return null;
    }
}
