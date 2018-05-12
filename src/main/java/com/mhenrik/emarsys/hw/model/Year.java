package com.mhenrik.emarsys.hw.model;

import java.util.Objects;

public final class Year {

    private boolean isLeapYear;
    private int year;

    public Year(int year) {
        this.year = checkYear(year);

    }

    private int checkYear(int year) {
        if (year > 0) {
            if (checkLeapYear(year)){
                isLeapYear = true;
            }
            return year;
        } else {
            throw new IllegalArgumentException("Year can not be negative!");
        }
    }

    private boolean checkLeapYear(int year){
        if (year % 4 != 0) {
            return false;
        }  else if ( year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year1 = (Year) o;
        return isLeapYear == year1.isLeapYear &&
                year == year1.year;
    }

    @Override
    public int hashCode() {

        return Objects.hash(isLeapYear, year);
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }
}
