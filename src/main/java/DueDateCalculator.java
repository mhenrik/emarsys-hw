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
        int hours = hourConverter.getHours();
        int days = hourConverter.getDays();
        int weeks = hourConverter.getWeeks();

        Year year = this.startDate.getYear();
        Month month = this.startDate.getMonth();
        int day = this.startDate.getDay();
        WorkingDay workingDay = this.startDate.getWorkingDay();
        Hour hour = this.startDate.getHour().next(hours);
        Minute minute = this.startDate.getMinute();

        CustomDate customDate = new CustomDate(year, month, day, workingDay, hour, minute);
        int daysInCurrentMonth = customDate.getMonth().getDaysInMonth();
        return customDate;

    }

    public static void main(String[] args) {

        CustomDate startDate = new CustomDate(2018, 5, 11, WorkingDay.MONDAY, 12, 0);
        System.out.println(startDate);
        DueDateCalculator dueDateCalculator = new DueDateCalculator();
        dueDateCalculator.setStartDate(startDate);
        dueDateCalculator.setTurnaroundTime(2);
        System.out.println(dueDateCalculator.convertHours());
    }
}
