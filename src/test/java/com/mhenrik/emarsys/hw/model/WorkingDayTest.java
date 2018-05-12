package com.mhenrik.emarsys.hw.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkingDayTest {

    private static WorkingDay workingDay;

    @BeforeAll
    public static void setup(){
        workingDay = WorkingDay.MONDAY;
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay1(){
        assertEquals(WorkingDay.TUESDAY, workingDay.next(1));
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay2(){
        assertEquals(WorkingDay.WEDNESDAY, workingDay.next(2));
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay3(){
        assertEquals(WorkingDay.THURSDAY, workingDay.next(3));
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay4(){
        assertEquals(WorkingDay.FRIDAY, workingDay.next(4));
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay5(){
        assertEquals(WorkingDay.MONDAY, workingDay.next(5));
    }

    @Test
    public void IfNextWorkingDayGivesNextWorkingDay10(){
        assertEquals(WorkingDay.MONDAY, workingDay.next(10));
    }
}