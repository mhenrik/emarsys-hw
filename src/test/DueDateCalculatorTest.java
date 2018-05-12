import com.mhenrik.emarsys.hw.model.CustomDate;
import com.mhenrik.emarsys.hw.model.WorkingDay;
import com.mhenrik.emarsys.hw.service.HourConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DueDateCalculatorTest {

    private DueDateCalculator dueDateCalculator;
    private CustomDate startDate;

    @Mock
    private HourConverter hourConverter;

    @BeforeEach
    public void setup(){
        hourConverter = mock(HourConverter.class);
        startDate = new CustomDate(2018, 5, 14, WorkingDay.MONDAY, 9, 30);
        dueDateCalculator = new DueDateCalculator(hourConverter);
        dueDateCalculator.setStartDate(startDate);
    }

    @Test
    public void IfDueDateIs2HoursAwayCalculate(){
        when(hourConverter.getNrOfhours()).thenReturn(2);
        dueDateCalculator.setTurnaroundTime(2);
        assertEquals(new CustomDate(2018, 5, 14, WorkingDay.MONDAY, 11, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateIs8HoursAwayCalculate(){
        when(hourConverter.getNrOfworkDays()).thenReturn(1);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(1);
        dueDateCalculator.setTurnaroundTime(8);
        assertEquals(new CustomDate(2018, 5, 15, WorkingDay.TUESDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateIs16HoursAwayCalculate(){
        when(hourConverter.getNrOfworkDays()).thenReturn(2);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(2);
        dueDateCalculator.setTurnaroundTime(16);
        assertEquals(new CustomDate(2018, 5, 16, WorkingDay.WEDNESDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateIsNextWeekAwayCalculate(){
        when(hourConverter.getNrOfworkDays()).thenReturn(0);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(5);
        when(hourConverter.getNrOfWeeks()).thenReturn(1);
        dueDateCalculator.setTurnaroundTime(40);
        assertEquals(new CustomDate(2018, 5, 21, WorkingDay.MONDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateIsNextMonthAwayCalculate(){
        when(hourConverter.getNrOfworkDays()).thenReturn(0);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(20);
        when(hourConverter.getNrOfWeeks()).thenReturn(4);
        dueDateCalculator.setTurnaroundTime(160);
        assertEquals(new CustomDate(2018, 6, 11, WorkingDay.MONDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateIsNextYearAwayCalculate(){
        when(hourConverter.getNrOfworkDays()).thenReturn(0);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(200);
        when(hourConverter.getNrOfWeeks()).thenReturn(40);
        dueDateCalculator.setTurnaroundTime(1600);
        assertEquals(new CustomDate(2019, 2, 18, WorkingDay.MONDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

    @Test
    public void IfDueDateDuringLeapYearFebruary(){
        startDate = new CustomDate(2020, 1, 1, WorkingDay.WEDNESDAY, 16, 45);
        dueDateCalculator.setStartDate(startDate);
        when(hourConverter.getNrOfworkDays()).thenReturn(0);
        when(hourConverter.getNrOfcalendarDays()).thenReturn(45);
        when(hourConverter.getNrOfWeeks()).thenReturn(9);
        dueDateCalculator.setTurnaroundTime(360);
        assertEquals(new CustomDate(2020, 3, 4, WorkingDay.WEDNESDAY, 16, 45),
                dueDateCalculator.calculateDueDate());
    }




}