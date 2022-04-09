package ru.hh.school.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.Dao.EmployerDao;
import ru.hh.school.service.EmployerService;
import ru.hh.school.service.VacancyService;

@Configuration
@Import({EmployerService.class, VacancyService.class})
public class ServiceConfig {
}
