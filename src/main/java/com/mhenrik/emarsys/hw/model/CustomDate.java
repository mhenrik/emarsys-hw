package com.mhenrik.emarsys.hw.model;

import com.mhenrik.emarsys.hw.model.service.HourConverter;

import java.util.Arrays;

public class CustomDate {

    private Year year;
    private Month month;
    private int day;
    //private WorkingDay workingDay;
    private Hour hour;
    private Minute minute;
    private int days;

    public CustomDate(int year, int month, int day, int hour, int minute) {
        this.year = new Year(year);
        this.month = Month.values()[month+1];
        this.day = day;
        this.hour = new Hour(hour);
        this.minute = new Minute(minute);
    }

    public static void main(String[] args) {
        CustomDate customDate = new CustomDate(2018, 4, 11, 12, 51);
        System.out.println(customDate);
        HourConverter hourConverter = new HourConverter();
        hourConverter.convert(650);
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
