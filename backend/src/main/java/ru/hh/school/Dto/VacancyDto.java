package ru.hh.school.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyDto {

    int id;

    String name;

    AreaDto area;

    SalaryDto salary;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("created_at")
    Date createdAt;

    EmployerDto employer;

    public VacancyDto() {
    }

    public VacancyDto(int id, String name, AreaDto area, SalaryDto salary, Date created_at, EmployerDto employer) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.salary = salary;
        this.createdAt = created_at;
        this.employer = employer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public SalaryDto getSalary() {
        return salary;
    }

    public void setSalary(SalaryDto salary) {
        this.salary = salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public EmployerDto getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDto employer) {
        this.employer = employer;
    }
}