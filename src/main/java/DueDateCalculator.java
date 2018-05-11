import com.mhenrik.emarsys.hw.model.CustomDate;
import com.mhenrik.emarsys.hw.model.Hour;
import com.mhenrik.emarsys.hw.model.service.HourConverter;

public class DueDateCalculator {

    private HourConverter hourConverter;
    private CustomDate customDate;
    private int turnaroundTime;

    public DueDateCalculator(HourConverter hourConverter){
        this.hourConverter = hourConverter;
    }

    public void setCustomDate(CustomDate customDate) {
        this.customDate = customDate;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    /*public CustomDate convertHours(){
        this.hourConverter.convert(this.turnaroundTime);
        int hours = hourConverter.getHours();
        int days = hourConverter.getDays();
        int weeks = hourConverter.getWeeks();
    }*/
}
