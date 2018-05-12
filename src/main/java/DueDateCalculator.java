import com.mhenrik.emarsys.hw.model.*;
import com.mhenrik.emarsys.hw.service.HourConverter;

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
        Hour hour = this.startDate.getHour().next(hours);
        Minute minute = this.startDate.getMinute();

        int daysInCurrentMonth = startDate.getMonth().getDaysInMonth();
        int remainingDaysInCurrentMonth = daysInCurrentMonth - this.startDate.getDay();
        endDay += weeks*2;

        while (endDay > remainingDaysInCurrentMonth){
            if (year.isLeapYear()) {
                endDay++;
            }
            if (month == Month.DECEMBER){
                year.setYear(year.getYear() + 1);
            }
            month = month.next(1);
            endDay -= remainingDaysInCurrentMonth;
            remainingDaysInCurrentMonth = month.getDaysInMonth();
        }

        return new CustomDate(year, month, endDay, workingDay, hour, minute);

    }

    public static void main(String[] args) {

        HourConverter hourConverter = new HourConverter();

        CustomDate startDate = new CustomDate(2020, 12, 7, WorkingDay.MONDAY, 12, 30);
        System.out.println("The start date is: " + startDate);

        DueDateCalculator dueDateCalculator = new DueDateCalculator(hourConverter);
        dueDateCalculator.setStartDate(startDate);

        dueDateCalculator.setTurnaroundTime(357);

        System.out.println("The due date is: " + dueDateCalculator.calculateDueDate());
    }
}
