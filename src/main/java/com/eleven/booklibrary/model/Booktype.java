package com.eleven.booklibrary.model;

public class Booktype {
    private String type;

    private Integer borrowDay;

    private Long dayFine;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Integer borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Long getDayFine() {
        return dayFine;
    }

    public void setDayFine(Long dayFine) {
        this.dayFine = dayFine;
    }
}