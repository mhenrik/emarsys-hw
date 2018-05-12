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
    private int turnaroundTime;

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
        dueDateCalculator.setTurnaroundTime(8);
        assertEquals(new CustomDate(2018, 5, 14, WorkingDay.TUESDAY, 9, 30),
                dueDateCalculator.calculateDueDate());
    }

}