package com.mhenrik.emarsys.hw.model.service;

public class HourConverter {

    private int nrOfWeeks;
    private int nrOfcalendarDays;
    private int nrOfhours;
    private int nrOfworkDays;

    public void convert(int hours){
        int calendarDays = hours / 8;
        int remainingHours = hours % 8;
        int weeks = calendarDays / 5;
        int remainingDays = calendarDays % 5;

        this.nrOfhours = remainingHours;
        this.nrOfworkDays = remainingDays;
        this.nrOfcalendarDays = calendarDays;
        this.nrOfWeeks = weeks;

        System.out.printf("Hours are %d and calendardays are %d and remaining workDays are %d \n", remainingHours, calendarDays, remainingDays);
        System.out.printf("Weeks are %d \n", this.nrOfWeeks);
    }

    public int getNrOfWeeks() {
        return nrOfWeeks;
    }

    public int getNrOfcalendarDays() {
        return nrOfcalendarDays;
    }

    public int getNrOfhours() {
        return nrOfhours;
    }

    public int getNrOfworkDays() {
        return nrOfworkDays;
    }

}
