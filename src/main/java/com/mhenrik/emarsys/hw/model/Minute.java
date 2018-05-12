package com.mhenrik.emarsys.hw.model;

import java.util.Objects;

public final class Minute {

    int minute;

    public Minute(int minute) {
        this.minute = checkMinute(minute);
    }

    private int checkMinute(int minute) throws IllegalArgumentException{
        if (minute >= 0 && minute <= 59){
            return minute;
        } else {
            throw new IllegalArgumentException("Invalid minute!");
        }
    }

    @Override
    public String toString() {
        return "" + minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minute minute1 = (Minute) o;
        return minute == minute1.minute;
    }

    @Override
    public int hashCode() {

        return Objects.hash(minute);
    }
}
