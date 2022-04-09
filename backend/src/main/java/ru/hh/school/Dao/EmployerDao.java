package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.Dto.EmployerIdDto;
import ru.hh.school.entity.Employer;

public class EmployerDao extends GenericDao{
    protected EmployerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


}
