package com.mhenrik.emarsys.hw.model.service;

public class HourConverter {

    private int calendarDays;
    private int hours;
    private int workDays;

    public void convert(int hours){
        int calendarDays = hours / 8;
        int remainingHours = hours % 8;
        int remainingDays = calendarDays % 5;

        this.hours = remainingHours;
        this.workDays = remainingDays;
        this.calendarDays = calendarDays;

        System.out.printf("Hours are %d and calendardays are %d and remaining workDays are %d \n", remainingHours, calendarDays, remainingDays);
    }

    public int getHours() {
        return hours;
    }

    public int getWorkDays() {
        return workDays;
    }

    public int getCalendarDays() {
        return calendarDays;
    }
}
