package com.mhenrik.emarsys.hw.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDate that = (CustomDate) o;
        return day == that.day &&
                Objects.equals(year, that.year) &&
                month == that.month &&
                workingDay == that.workingDay &&
                Objects.equals(hour, that.hour) &&
                Objects.equals(minute, that.minute);
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, month, day, workingDay, hour, minute);
    }
}
