package com.mhenrik.emarsys.hw.model;

import com.mhenrik.emarsys.hw.model.Month;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {

    private static Month month;

    @BeforeAll
    public static void setup(){
        month = Month.JANUARY;
    }

    @Test
    public void IfNextMonthGivesNextMonth1(){
        assertEquals(Month.FEBRUARY, month.next(1));
    }

    @Test
    public void IfNextMonthGivesNextMonth2(){
        assertEquals(Month.MARCH, month.next(2));
    }

    @Test
    public void IfNextMonthGivesNextMonth3(){
        assertEquals(Month.APRIL, month.next(3));
    }

    @Test
    public void IfNextMonthGivesNextMonth4(){
        assertEquals(Month.MAY, month.next(4));
    }

    @Test
    public void IfNextMonthGivesNextMonth5(){
        assertEquals(Month.JUNE, month.next(5));
    }

    @Test
    public void IfNextMonthGivesNextMonth6(){
        assertEquals(Month.JULY, month.next(6));
    }

    @Test
    public void IfNextMonthGivesNextMonth7(){
        assertEquals(Month.AUGUST, month.next(7));
    }

    @Test
    public void IfNextMonthGivesNextMonth8(){
        assertEquals(Month.SEPTEMBER, month.next(8));
    }

    @Test
    public void IfNextMonthGivesNextMonth9(){
        assertEquals(Month.OCTOBER, month.next(9));
    }

    @Test
    public void IfNextMonthGivesNextMonth10(){
        assertEquals(Month.NOVEMBER, month.next(10));
    }

    @Test
    public void IfNextMonthGivesNextMonth11(){
        assertEquals(Month.DECEMBER, month.next(11));
    }

    @Test
    public void IfNextMonthGivesNextMonth12(){
        assertEquals(Month.JANUARY, month.next(12));
    }

    @Test
    public void IfMonthCodeReturnsMonth1(){
        assertEquals(Month.JANUARY, month.getMonth(1));

    }

    @Test
    public void IfMonthCodeReturnsMonth2(){
        assertEquals(Month.DECEMBER, month.getMonth(12));

    }

    @Test
    public void IfGetDaysInMonthWorks(){
        assertEquals(31, month.getDaysInMonth());
    }


}