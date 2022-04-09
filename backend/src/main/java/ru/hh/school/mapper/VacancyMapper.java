package ru.hh.school.mapper;

import ru.hh.school.Dto.VacancyDto;
import ru.hh.school.Dto.VacancyFavoriteDto;
import ru.hh.school.entity.Vacancy;

public class VacancyMapper extends AbstractMapper{
    public VacancyFavoriteDto mapVacancyEntityToDto(Vacancy vacancy) {
        return mapper.convertValue(vacancy, VacancyFavoriteDto.class);
    }
    public Vacancy mapJsonToEntity(String apiData) {
        return super.mapItem(apiData, Vacancy.class);
    }

}
