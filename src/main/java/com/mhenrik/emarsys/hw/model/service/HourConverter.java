package com.mhenrik.emarsys.hw.model.service;

import com.mhenrik.emarsys.hw.model.CustomDate;
import com.mhenrik.emarsys.hw.model.Hour;

public class HourConverter {

    int hours;

    public void convert(int hours){
        int days = hours / 8;
        int remainingHours = hours % 8;
        int weeks = days / 5;
        int remainingDays = days % 5;

        System.out.printf("Hours are %d and weeks are %d and remaining days are %d", remainingHours, weeks, remainingDays);
    }
}
