package ru.hh.school.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.school.mapper.EmployerMapper;
import ru.hh.school.mapper.VacancyMapper;

@Configuration
@Import({EmployerMapper.class, VacancyMapper.class})
public class MapperConfig {
}
