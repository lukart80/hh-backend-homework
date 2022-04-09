package ru.hh.school.mapper;

import ru.hh.school.Dto.EmployerDto;
import ru.hh.school.Dto.EmployerFavoriteDto;
import ru.hh.school.Dto.EmployerIdDto;
import ru.hh.school.entity.Employer;

import java.util.List;

public class EmployerMapper extends AbstractMapper{

    public List<EmployerDto> mapEmployerList(String apiResponse) {

        return super.mapItemList(apiResponse, EmployerDto.class);
    }

    public EmployerIdDto mapEmployer(String apiResponse) {

        return super.mapItem(apiResponse, EmployerIdDto.class);
    }

    public EmployerFavoriteDto mapEmployerEntityToDto(Employer employer) {
        return mapper.convertValue(employer, EmployerFavoriteDto.class);
    }

    public Employer mapJsonToEntity(String apiData) {
        return super.mapItem(apiData, Employer.class);
    }

}
