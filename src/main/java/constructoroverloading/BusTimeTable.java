package constructoroverloading;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {

        for (int i = firstHour; i < lastHour + 1; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }

    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        int difference = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < timeTable.size(); i++) {
            int toCompare = timeTable.get(i).difference(actual);
            if (toCompare < difference && toCompare > 0) {
                index = i;
                difference = toCompare;
            }
        }
        if (difference == Integer.MAX_VALUE) {
            throw new IllegalStateException("No more buses today!");
        }
        return timeTable.get(index);
    }

    public SimpleTime firstBus() {
        SimpleTime startOfDay = new SimpleTime(0, 0);
        return nextBus(startOfDay);
    }

}
