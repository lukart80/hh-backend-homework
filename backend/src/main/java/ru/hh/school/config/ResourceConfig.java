package ru.hh.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.Dao.EmployerDao;
import ru.hh.school.resource.EmployerResource;
import ru.hh.school.resource.VacancyResource;

@Configuration
@Import({EmployerResource.class, VacancyResource.class})
public class ResourceConfig {
}
