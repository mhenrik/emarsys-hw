package com.mhenrik.emarsys.hw.model;

public enum Month {

    JANUARY (1, 31),
    FEBRUARY (2, 28),
    MARCH (3, 31),
    APRIL (4, 30),
    MAY (5, 31),
    JUNE (6, 30),
    JULY (7, 31),
    AUGUST (8, 31),
    SEPTEMBER (9, 30),
    OCTOBER (10, 31),
    NOVEMBER (11, 30),
    DECEMBER (12, 31);

    private final int monthCode;
    private final int daysInMonth;
    private static Month[] values = values();

    Month(int monthCode, int daysInMonth) {
        this.monthCode = monthCode;
        this.daysInMonth = daysInMonth;
    }

    public Month next(int number){
        return values[(this.ordinal() + number) % values.length];
    }

    public Month getMonth(int monthCode){
        return Month.values()[monthCode-1];
    }

    public int getDaysInMonth(){
        return daysInMonth;
    }

    public int getMonthCode() {
        return monthCode;
    }
}
