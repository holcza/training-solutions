package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public Day nextDay(Day day) {
        Day[] days = Day.values();
        for (int i = 0; i < days.length; i++) {
            if (days[i] == day) {
                if (i == days.length - 1) {
                    return days[0];
                } else {

                    return days[i + 1];
                }
            }
        }
        return null;
    }

    public List<DayType> dayTypes (Day firstDay, int numberOfDays){
        List<DayType> dayTypes=new ArrayList<>();

        for (int i=0;i<numberOfDays;i++){
            dayTypes.add(firstDay.getDayType());
            firstDay = nextDay(firstDay);
        }

        return dayTypes;
    }

    public static void main(String[] args) {
        WorkdayCalculator workdayCalculator = new WorkdayCalculator();

        System.out.println(workdayCalculator.dayTypes(Day.FRIDAY,12));
    }



}
