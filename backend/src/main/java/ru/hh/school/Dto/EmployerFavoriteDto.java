package ru.hh.school.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.EnumPopularity.Popularity;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerFavoriteDto extends EmployerIdDto {
    String comment;
    Popularity popularity;

    @JsonProperty("views_count")
    int viewsCount;

    @JsonProperty("date_create")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Date dateCreate;

    public EmployerFavoriteDto() {
    }

    public EmployerFavoriteDto(int id, String name, String description, AreaDto area, String comment, Popularity popularity, int viewsCount, Date dateCreate) {
        super(id, name, description, area);
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
        if (getViewsCount() > 20) {
            return Popularity.POPULAR;
        }
        return Popularity.REGULAR;
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
