package com.mhenrik.emarsys.hw.service;

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
