package com.mhenrik.emarsys.hw.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourConverterTest {

    private static HourConverter hourConverter;

    @BeforeAll
    public static void setup(){
        hourConverter = new HourConverter();
    }

    @Test
    public void IfConverterConvertsHoursToCalendarDays1(){
        hourConverter.convert(8);
        assertEquals(1, hourConverter.getNrOfcalendarDays());
    }

    @Test
    public void IfConverterConvertsHoursToCalendarDays2(){
        hourConverter.convert(16);
        assertEquals(2, hourConverter.getNrOfcalendarDays());
    }

    @Test
    public void IfConverterCountsRemainingHours1(){
        hourConverter.convert(4);
        assertEquals(4, hourConverter.getNrOfhours());
    }

    @Test
    public void IfConverterCountsRemainingHours2(){
        hourConverter.convert(13);
        assertEquals(5, hourConverter.getNrOfhours());
    }

    @Test
    public void IfConverterCountsWeeks1(){
        hourConverter.convert(40);
        assertEquals(1, hourConverter.getNrOfWeeks());
    }

    @Test
    public void IfConverterCountsWeeks2(){
        hourConverter.convert(80);
        assertEquals(2, hourConverter.getNrOfWeeks());
    }

    @Test
    public void IfConverterCountRemainingDays1(){
        hourConverter.convert(12);
        assertEquals(1, hourConverter.getNrOfworkDays());
    }

    @Test
    public void IfConverterCountRemainingDays2(){
        hourConverter.convert(16);
        assertEquals(2, hourConverter.getNrOfworkDays());
    }

}