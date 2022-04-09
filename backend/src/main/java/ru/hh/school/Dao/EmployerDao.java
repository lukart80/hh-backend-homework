package ru.hh.school.Dao;


import org.hibernate.SessionFactory;

import ru.hh.school.entity.Employer;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class EmployerDao extends GenericDao{
    protected EmployerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Employer getEmployerById(Integer id) {
        return getSession().createQuery("from Employer e where e.id=:id", Employer.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Employer> getAllEmployersEager() {
        return getSession().createQuery("from Employer e join fetch e.area", Employer.class).getResultList();
    }


    public Employer getEmployerEagerById(Integer id) {


        return getSession()
                .createQuery("from Employer e join fetch e.area where e.id =:id", Employer.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Employer incrementEmployerCounter(Employer employer) {
        employer.setViewsCount(employer.getViewsCount() + 1);
        update(employer);
        return employer;
    }



    public void deleteEmployerById(Integer id) {
        Employer employer = getEmployerById(id);
        delete(employer);
    }




}
