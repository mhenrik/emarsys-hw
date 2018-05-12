package com.mhenrik.emarsys.hw.model;


import com.mhenrik.emarsys.hw.model.Hour;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourTest {

    private static Hour hour;

    @BeforeAll
    public static void setup(){
        hour = new Hour(9);
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours1(){
        assertEquals(new Hour(10), hour.next(1));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours2(){
        assertEquals(new Hour(11), hour.next(2));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours3(){
        assertEquals(new Hour(12), hour.next(3));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours4(){
        assertEquals(new Hour(13), hour.next(4));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours5(){
        assertEquals(new Hour(14), hour.next(5));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours6(){
        assertEquals(new Hour(15), hour.next(6));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours7(){
        assertEquals(new Hour(16), hour.next(7));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours8(){
        assertEquals(new Hour(9), hour.next(8));
    }

    @Test
    public void IfNextReturnNextHourInWorkingHours16(){
        assertEquals(new Hour(9), hour.next(16));
    }

    @Test
    public void IfCheckHourThrowsIllegalArgumentException1() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> hour = new Hour(8));
    }

    @Test
    public void IfCheckHourThrowsIllegalArgumentException2() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> hour = new Hour(18));
    }

    @Test
    public void IfCheckHourThrowsIllegalArgumentException3() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> hour = new Hour(-1));
    }

    @Test
    public void IfCheckHourThrowsIllegalArgumentException4() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> hour = new Hour(0));
    }



}