package ru.hh.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.Dao.EmployerDao;
import ru.hh.school.Dao.VacancyDao;

@Configuration
@Import({EmployerDao.class, VacancyDao.class})

public class DaoConfig {
}
