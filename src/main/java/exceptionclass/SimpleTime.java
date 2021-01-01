package exceptionclass;

import java.time.format.DateTimeFormatter;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        timeCheck(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    private void timeCheck(int hour, int minute) {
        if (hour <0 || hour >23){
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }

        if(minute <0|| minute >59){
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }

    public SimpleTime(String s) {
        if (s==null||s.isBlank()){
            throw new InvalidTimeException("Time is null");
        }

        int hourtoCheck;
        int minutetoCheck;
        try{

            String[] time = s.split(":");

            hourtoCheck = Integer.parseInt(time[0]);
            minutetoCheck = Integer.parseInt(time[1]);

        } catch (RuntimeException rte){
            throw  new InvalidTimeException("Time is not hh:mm");
        }

        timeCheck(hourtoCheck, minutetoCheck);
        this.hour = hourtoCheck;
        this.minute = minutetoCheck;


    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d",hour,minute);
    }
}
