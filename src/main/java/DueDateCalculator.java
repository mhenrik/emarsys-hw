import com.mhenrik.emarsys.hw.model.*;
import com.mhenrik.emarsys.hw.model.service.HourConverter;

public class DueDateCalculator {

    private HourConverter hourConverter;
    private CustomDate startDate;
    private int turnaroundTime;

    public DueDateCalculator(){
        this.hourConverter = new HourConverter();
    }

    public void setStartDate(CustomDate startDate) {
        this.startDate = startDate;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public CustomDate convertHours(){
        this.hourConverter.convert(this.turnaroundTime);
        int hours = hourConverter.getNrOfhours();
        int days = hourConverter.getNrOfworkDays();
        int calendarDays = hourConverter.getNrOfcalendarDays();
        int weeks = hourConverter.getNrOfWeeks();

        Year year = this.startDate.getYear();
        Month month = this.startDate.getMonth();
        int day = this.startDate.getDay() + calendarDays;
        WorkingDay workingDay = this.startDate.getWorkingDay().next(days);
        Hour hour = this.startDate.getHour().next(hours);
        Minute minute = this.startDate.getMinute();

        int daysInCurrentMonth = startDate.getMonth().getDaysInMonth();
        int remainingDaysInCurrentMonth = daysInCurrentMonth - this.startDate.getDay();
        day += weeks*2;

        while (day > remainingDaysInCurrentMonth){
            if (year.isLeapYear()) {
                day++;
            }
            if (month == Month.DECEMBER){
                year.setYear(year.getYear() + 1);
            }
            month = month.next(1);
            day -= remainingDaysInCurrentMonth;
            remainingDaysInCurrentMonth = month.getDaysInMonth();

        }

        CustomDate customDate = new CustomDate(year, month, day, workingDay, hour, minute);
        return customDate;

    }

    public static void main(String[] args) {

        CustomDate startDate = new CustomDate(2020, 12, 7, WorkingDay.MONDAY, 12, 30);
        System.out.println(startDate);

        DueDateCalculator dueDateCalculator = new DueDateCalculator();
        dueDateCalculator.setStartDate(startDate);

        dueDateCalculator.setTurnaroundTime(356);

        System.out.println(dueDateCalculator.convertHours());
    }
}
