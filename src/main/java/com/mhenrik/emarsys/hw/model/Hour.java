package com.mhenrik.emarsys.hw.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Hour {

    private int hour;
    public static final List<Integer> WORKING_HOURS = Arrays.asList(
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

    public Hour next(int hour){
        int index = WORKING_HOURS.indexOf(this.hour);
        int newIndex = (index + hour) % (WORKING_HOURS.size() - 1);
        return new Hour(WORKING_HOURS.get(newIndex));
    }


    private int checkHour(int hour) throws IllegalArgumentException{
        if (WORKING_HOURS.contains(hour)){
            return hour;
        } else {
            throw new IllegalArgumentException("Invalid working hour!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hour hour1 = (Hour) o;
        return hour == hour1.hour;
    }

    @Override
    public int hashCode() {

        return Objects.hash(hour);
    }

    @Override
    public String toString() {
        return "" + hour;
    }
}
