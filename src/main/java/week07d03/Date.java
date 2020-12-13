package week07d03;

import typeconversion.dataloss.DataLoss;

public class Date {

    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static Date of (int year, int month, int day){
        return new Date(year, month, day);
    }

    public Date withYear (int year){
        return new Date(year,month,day);
    }

    public Date withMonth (int month){
        return new Date(year,month,day);
    }

    public Date withDay (int day){
        return new Date(year,month,day);
    }

    public static void main(String[] args) {
        Date date = new Date(2020,12,13);

        Date date1 = date.withYear(2019).withMonth(11).withDay(11);
        System.out.println(date1.getYear()+" "+date1.getMonth()+" "+date1.getDay());
    }
}
