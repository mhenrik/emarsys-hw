import com.mhenrik.emarsys.hw.model.*;
import com.mhenrik.emarsys.hw.service.HourConverter;

import java.util.Objects;

public class DueDateCalculator {

    private HourConverter hourConverter;
    private CustomDate startDate;
    private int turnaroundTime;

    public DueDateCalculator(HourConverter hourConverter){
        this.hourConverter = hourConverter;
    }

    public void setStartDate(CustomDate startDate) {
        this.startDate = startDate;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public CustomDate calculateDueDate(){

        this.hourConverter.convert(this.turnaroundTime);
        int hours = hourConverter.getNrOfhours();
        int days = hourConverter.getNrOfworkDays();
        int calendarDays = hourConverter.getNrOfcalendarDays();
        int weeks = hourConverter.getNrOfWeeks();

        Year year = this.startDate.getYear();
        Month month = this.startDate.getMonth();
        int endDay = this.startDate.getDay() + calendarDays;
        WorkingDay workingDay = this.startDate.getWorkingDay().next(days);
        weeks += (this.startDate.getWorkingDay().ordinal() + days) / 5;
        Hour hour = this.startDate.getHour().next(hours);
        Minute minute = this.startDate.getMinute();
        int daysInCurrentMonth;

        if (year.isLeapYear() && month == Month.FEBRUARY){
            daysInCurrentMonth = startDate.getMonth().getDaysInMonth() + 1;
        } else {
            daysInCurrentMonth = startDate.getMonth().getDaysInMonth();
        }
        endDay += weeks*2;

        while (endDay > daysInCurrentMonth){
            if (month == Month.DECEMBER){
                year.setYear(year.getYear() + 1);
            }
            month = month.next(1);
            endDay = endDay - daysInCurrentMonth;
            if (year.isLeapYear() && month == Month.FEBRUARY){
                daysInCurrentMonth = month.getDaysInMonth() + 1;
            } else {
                daysInCurrentMonth = month.getDaysInMonth();
            }
        }

        return new CustomDate(year, month, endDay, workingDay, hour, minute);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DueDateCalculator that = (DueDateCalculator) o;
        return turnaroundTime == that.turnaroundTime &&
                Objects.equals(hourConverter, that.hourConverter) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hourConverter, startDate, turnaroundTime);
    }

    public static void main(String[] args) {

        HourConverter hourConverter = new HourConverter();

        CustomDate startDate = new CustomDate(2020, 2, 27, WorkingDay.THURSDAY, 12, 30);
        System.out.println("The start date is: " + startDate);

        DueDateCalculator dueDateCalculator = new DueDateCalculator(hourConverter);
        dueDateCalculator.setStartDate(startDate);

        dueDateCalculator.setTurnaroundTime(17);

        System.out.println("The due date is: " + dueDateCalculator.calculateDueDate());


    }
}
