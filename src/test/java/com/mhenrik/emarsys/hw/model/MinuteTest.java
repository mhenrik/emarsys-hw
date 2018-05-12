package com.mhenrik.emarsys.hw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinuteTest {

    private Minute minute;

    @Test
    public void IfCheckMinuteThrowsIllegalArgumentException1() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> minute = new Minute(-1));
    }

    @Test
    public void IfCheckMinuteThrowsIllegalArgumentException2() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> minute = new Minute(60));
    }

    @Test
    public void IfValidMinuteIsCheckedCorrectly(){
        assertEquals(new Minute(0), minute = new Minute(0));
    }
}