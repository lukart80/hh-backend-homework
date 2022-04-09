package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;


public abstract class GenericDao {


    private final SessionFactory sessionFactory;


    protected GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Object object) {
        if (object == null) {
            return;
        }
        getSession().save(object);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
