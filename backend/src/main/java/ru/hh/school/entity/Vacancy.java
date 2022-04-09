package ru.hh.school.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "vacancy")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancy {

    @Id
    private int id;

    @NotNull
    private String name;

    @Column(name = "date_create")
    @JsonProperty("date_create")
    private Date dateCreate = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Area area;

    @Embedded
    private Salary salary;

    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("created_at")
    private Date createdAt;


    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private Employer employer;

   @Column(name = "views_count")
   @JsonProperty("views_count")
   private int viewsCount;
   private String comment;

    public Vacancy() {
    }

    public Vacancy(int id, String name, Date dateCreate, Area area, Salary salary, Date createdAt, Employer employer, int views_count, String comment) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.area = area;
        this.salary = salary;
        this.createdAt = createdAt;
        this.employer = employer;
        this.viewsCount = views_count;
        this.comment = comment;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
