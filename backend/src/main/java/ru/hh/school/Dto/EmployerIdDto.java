package ru.hh.school.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerIdDto extends EmployerDto {
    String description;

    AreaDto area;

    public EmployerIdDto() {

    }

    public EmployerIdDto(int id, String name, String description, AreaDto area) {
        super(id, name);
        this.description = description;
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }


}
