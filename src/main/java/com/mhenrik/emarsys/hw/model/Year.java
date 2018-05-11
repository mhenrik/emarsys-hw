package com.mhenrik.emarsys.hw.model;

public final class Year {

    int year;

    public Year(int year) {
        this.year = checkYear(year);

    }

    private int checkYear(int year) {
        if (year > 0) {
            return year;
        } else {
            throw new IllegalArgumentException("Invalid year format!");
        }
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }
}
