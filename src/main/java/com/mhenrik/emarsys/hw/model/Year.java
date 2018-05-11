package com.mhenrik.emarsys.hw.model;

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
            throw new IllegalArgumentException("Invalid year format!");
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

    public boolean isLeapYear() {
        return isLeapYear;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }
}
