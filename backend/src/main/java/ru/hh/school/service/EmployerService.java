package ru.hh.school.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.hh.school.Dao.EmployerDao;
import ru.hh.school.Dto.EmployerDto;
import ru.hh.school.Dto.EmployerFavoriteDto;
import ru.hh.school.Dto.EmployerIdDto;
import ru.hh.school.HhApiClient.HhApiClient;
import ru.hh.school.entity.Employer;
import ru.hh.school.mapper.EmployerMapper;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class EmployerService {
    EmployerDao employerDao;
    EmployerMapper employerMapper;
    HhApiClient apiClient;



    public EmployerService(EmployerDao employerDao, EmployerMapper employerMapper, HhApiClient apiClient) {
        this.employerDao = employerDao;
        this.employerMapper = employerMapper;
        this.apiClient = apiClient;
    }

    public EmployerFavoriteDto getFavoriteEmployerEagerById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        try {
            Employer employer = employerDao.getEmployerEagerById(id);


            employerDao.incrementEmployerCounter(employer);
            return employerMapper.mapEmployerEntityToDto(employer);
        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    public List<EmployerFavoriteDto> getFavoriteEmployers() {
        List<Employer> employers = employerDao.getAllEmployersEager();
        return employers.stream()
                .map(employer -> employerDao.incrementEmployerCounter(employer))
                .map(employer -> employerMapper.mapEmployerEntityToDto(employer))
                .collect(Collectors.toList());
    }

    public void deleteFavoriteEmployerById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        try {
            employerDao.deleteEmployerById(id);
        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id=" + id + "not found");
        }
    }

    @Transactional
    public void updateEmployerComment(Integer id, String comment) {
        if (id == null || comment == null) {
            throw  new IllegalArgumentException();
        }
        try {
            Employer employer = employerDao.getEmployerById(id);
            employer.setComment(comment);


        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id=" + id + "not found");
        }
    }

    private String fetchEmployerFromApi(int id) {
        String uri = "/employers/" + id;
        return apiClient.executeRequest(uri);


    }


    public void addOrUpdateEmployerInFavorite(Integer id, String comment) {
        String apiData = fetchEmployerFromApi(id);
        Employer employer= employerMapper.mapJsonToEntity(apiData);
        try {
            employerDao.getEmployerById(id);
            employerDao.update(employer);


        } catch (NoResultException e) {


            employer.setComment(comment);
            employerDao.save(employer);
        }
    }

    public List<EmployerDto> getEmployersFromApi (String query, Integer page, Integer perPage){
        String uri = "/employers" + "?text=" + query + "&page=" + page + "&per_page=" + perPage;
        String apiData = apiClient.executeRequest(uri);
        System.out.println(apiData);


        return employerMapper.mapEmployerList(apiData);
    }

    public EmployerIdDto getEmployerByIdFromApi(Integer id) {
        String apiData = fetchEmployerFromApi(id);


        return employerMapper.mapEmployer(apiData);
    }


}
