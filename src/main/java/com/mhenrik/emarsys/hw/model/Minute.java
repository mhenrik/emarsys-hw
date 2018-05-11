package com.mhenrik.emarsys.hw.model;

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
        return "Minute{" +
                "minute=" + minute +
                '}';
    }
}
