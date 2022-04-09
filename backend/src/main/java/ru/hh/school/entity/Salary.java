package ru.hh.school.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    @Column(name = "salary_from")
    int from;
    @Column(name = "salary_to")
    int to;
    @Column(name = "salary_gross")
    boolean gross;
    String currency;

    public Salary() {
    }

    public Salary(int from, int to, boolean gross, String currency) {
        this.from = from;
        this.to = to;
        this.gross = gross;
        this.currency = currency;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isGross() {
        return gross;
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
