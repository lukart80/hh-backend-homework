package ru.hh.school.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.hh.school.Dao.VacancyDao;
import ru.hh.school.Dto.VacancyFavoriteDto;
import ru.hh.school.HhApiClient.HhApiClient;

import ru.hh.school.entity.Employer;
import ru.hh.school.entity.Vacancy;
import ru.hh.school.mapper.VacancyMapper;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class VacancyService {
    VacancyDao vacancyDao;
    VacancyMapper vacancyMapper;
    HhApiClient client;

    public VacancyService(VacancyDao vacancyDao, VacancyMapper vacancyMapper, HhApiClient client) {
        this.vacancyDao = vacancyDao;
        this.vacancyMapper = vacancyMapper;
        this.client = client;
    }

    public List<VacancyFavoriteDto> getFavoriteVacancies() {
        List<Vacancy> vacancies = vacancyDao.getAllVacancies();
        return vacancies.stream()
                .map(v -> vacancyDao.incrementVacancyCounter(v))
                .map(v -> vacancyMapper.mapVacancyEntityToDto(v))
                .collect(Collectors.toList());
    }

    public VacancyFavoriteDto getVacancyById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();

        }
        try {
            Vacancy vacancy = vacancyDao.getVacancyById(id);
            vacancyDao.incrementVacancyCounter(vacancy);
            return vacancyMapper.mapVacancyEntityToDto(vacancy);
        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id=" + id + "not found");
        }
    }

    public void deleteVacancyById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        try {
            vacancyDao.deleteVacancyById(id);
        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id=" + id + "not found");
        }
    }

    private String fetchVacancyFromApi(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        String uri = "/vacancies/" + id;
        return client.executeRequest(uri);
    }

    public void addOrUpdateVacancyInFavorite(Integer id, String comment) {
        String apiData = fetchVacancyFromApi(id);
        Vacancy vacancy= vacancyMapper.mapJsonToEntity(apiData);
        try {
            vacancyDao.getVacancyById(id);
            vacancyDao.update(vacancy);


        } catch (NoResultException e) {


            vacancy.setComment(comment);
            vacancyDao.save(vacancy);
        }
    }

    @Transactional
    public void updateVacancyComment(Integer id, String comment) {
        if (id == null || comment == null) {
            throw  new IllegalArgumentException();
        }
        try {
            Vacancy vacancy = vacancyDao.getVacancyById(id);
            vacancy.setComment(comment);


        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id=" + id + "not found");
        }
    }


}
