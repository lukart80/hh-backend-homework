package ru.hh.school.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;

@Transactional
public abstract class GenericDao {


    private final SessionFactory sessionFactory;


    protected GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(Object object) {
        if (object == null) {
            return;
        }
        getSession().save(object);
    }

    public void update(Object object) {
        if (object == null) {
            return;
        }


        getSession().merge(object);
    }

    public void delete(Object object) {
        if (object == null) {
            return;
        }
        getSession().delete(object);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
