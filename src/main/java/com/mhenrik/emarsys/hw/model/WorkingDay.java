package com.mhenrik.emarsys.hw.model;

public enum WorkingDay {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    private static WorkingDay[] values = values();

    public WorkingDay next(int number) {
        return values[(this.ordinal()+number) % values.length];
    }

}
