package com.mhenrik.emarsys.hw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearTest {

    private Year year;

    @Test
    public void IfInvalidYearThrowsIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> year = new Year(-1));
    }

    @Test
    public void IfCheckLeapYearWorksWhenNotLeapYear(){
        year = new Year(1997);
        assertFalse(year.isLeapYear());
    }

    @Test
    public void IfCheckLeapYearWorksWhenYearModuloBy400(){
        year = new Year(2000);
        assertTrue(year.isLeapYear());
    }

    @Test
    public void IfCheckLeapYearWorksWhenYeaarModuloBy100(){
        year = new Year(1900);
        assertFalse(year.isLeapYear());
    }

    @Test
    public void IfCheckLeapYearWorksWhenYearModuloBy4(){
        year = new Year(2016);
        assertTrue(year.isLeapYear());
    }


}