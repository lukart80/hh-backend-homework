package ru.hh.school.Dao;

import org.hibernate.SessionFactory;
import ru.hh.school.entity.Vacancy;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VacancyDao extends GenericDao{
    protected VacancyDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Vacancy getVacancyById(Integer id) {
        return getSession().createQuery("from Vacancy v where v.id = :id", Vacancy.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Vacancy> getAllVacancies() {
        return getSession().createQuery("from Vacancy", Vacancy.class)
                .getResultList();
    }

    public Vacancy incrementVacancyCounter(Vacancy vacancy) {
        vacancy.setViewsCount(vacancy.getViewsCount() + 1);
        update(vacancy);
        return vacancy;
    }

    public void deleteVacancyById(Integer id) {
        Vacancy vacancy = getVacancyById(id);
        delete(vacancy);
    }
}
