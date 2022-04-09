package ru.hh.school.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaDto {
    @JsonProperty
    int id;
    @JsonProperty
    String name;

    public AreaDto() {

    }

    public AreaDto(int id, String name) {
        this.id = id;
        this.name = name;
    }



}
