package ru.hh.school.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryDto {

    Integer from;

    Integer to;

    String currency;

    boolean gross;

    public SalaryDto() {}

    public SalaryDto(Integer from, Integer to, String currency, boolean gross) {
        this.from = from;
        this.to = to;
        this.currency = currency;
        this.gross = gross;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isGross() {
        return gross;
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }
}
