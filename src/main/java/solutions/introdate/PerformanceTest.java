package solutions.introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {
        LocalDate localDate =LocalDate.of(2000,11,20);
        LocalTime localTime1 = LocalTime.of (12,0);
        LocalTime localTime2 = LocalTime.of (13,0);
        Performance performance = new Performance(localDate,"New artist",localTime1,localTime2);
        performance.getInfo();
    }







}
