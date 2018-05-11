package com.mhenrik.emarsys.hw.model;

import com.mhenrik.emarsys.hw.model.service.HourConverter;

import java.util.Arrays;

public class CustomDate {

    private Year year;
    private Month month;
    private int day;
    private WorkingDay workingDay;
    private Hour hour;
    private Minute minute;

    public CustomDate(int year, int month, int day, WorkingDay workingDay,  int hour, int minute) {
        this.year = new Year(year);
        this.month = Month.values()[month-1];
        this.day = day;
        this.workingDay = workingDay;
        this.hour = new Hour(hour);
        this.minute = new Minute(minute);
    }

    public CustomDate(Year year, Month month, int day, WorkingDay workingDay, Hour hour, Minute minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.workingDay = workingDay;
        this.hour = hour;
        this.minute = minute;
    }

    public Year getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Hour getHour() {
        return hour;
    }

    public Minute getMinute() {
        return minute;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", workday=" + workingDay +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
