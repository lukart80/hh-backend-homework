package ru.hh.school.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.school.Dto.*;

@Configuration
@Import({AreaDto.class, EmployerDto.class, EmployerIdDto.class, EmployerFavoriteDto.class, AddEmployerDto.class, VacancyDto.class, VacancyFavoriteDto.class, AddVacancyDto.class})
public class DtoConfig {
}
