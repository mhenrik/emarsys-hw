package com.mhenrik.emarsys.hw.model;

import java.util.Arrays;
import java.util.List;

public final class Hour {

    private int hour;
    static final List<Integer> WORKING_HOURS = Arrays.asList(
            9,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17
    );

    public Hour(int hour) {
        this.hour = checkHour(hour);
    }

    private int checkHour(int hour) throws IllegalArgumentException{
        if (WORKING_HOURS.contains(hour)){
            return hour;
        } else {
            throw new IllegalArgumentException("Invalid working hour!");
        }
    }

    @Override
    public String toString() {
        return "Hour{" +
                "hour=" + hour +
                '}';
    }
}
