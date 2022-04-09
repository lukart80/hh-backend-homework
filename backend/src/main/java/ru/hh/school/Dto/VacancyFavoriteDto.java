package ru.hh.school.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.EnumPopularity.Popularity;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyFavoriteDto extends VacancyDto {
    String comment;
    Popularity popularity;

    @JsonProperty("views_count")
    int viewsCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("date_create")
    Date dateCreate;

    public VacancyFavoriteDto() {

    }

    public VacancyFavoriteDto(int id, String name, AreaDto area, SalaryDto salary, Date created_at, EmployerDto employer, String comment, Popularity popularity, int viewsCount, Date dateCreate) {
        super(id, name, area, salary, created_at, employer);
        this.comment = comment;
        this.popularity = popularity;
        this.viewsCount = viewsCount;
        this.dateCreate = dateCreate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Popularity getPopularity() {
        if (this.viewsCount > 20) {
            return Popularity.POPULAR;
        } return Popularity.REGULAR;

    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
