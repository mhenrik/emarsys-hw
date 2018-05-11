package com.mhenrik.emarsys.hw.model;

public enum WorkingDay {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    private static WorkingDay[] vals = values();

    public WorkingDay next() {
        return vals[(this.ordinal()+1) % vals.length];
    }

}
