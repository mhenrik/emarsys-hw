package com.mhenrik.emarsys.hw.model;

import java.util.Arrays;

public class CustomDate {

    private int year;
    private Month month;
    private int day;
    //private WorkingDay workingDay;
    private int hours;
    private int days;

    public CustomDate(int year, Month month, int day, int hours) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
    }

    public static void main(String[] args) {
        CustomDate customDate = new CustomDate(2018, Month.APRIL, 11, 1251);
        System.out.println(customDate);
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hours=" + hours +
                '}';
    }
}
