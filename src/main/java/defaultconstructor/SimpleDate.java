package defaultconstructor;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)){
            throw new IllegalArgumentException(String.format("One or more given parameter cannot be applied! %d, %d, %d",year,month,day));
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isCorrect(int year, int month, int day) {
        boolean isCorrect = false;
        if (year >= 1900 && day == calculateMonthLength(year, month)&&calculateMonthLength(year,month)!=-1) {
            isCorrect = true;
        }
        return isCorrect;

    }

    private boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if (year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

    private int calculateMonthLength(int year, int month) {
        if (isLeapYear(year) && month == 2) {
            return 29;
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2:
                    return 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return -1;

            }

        }
    }
}
