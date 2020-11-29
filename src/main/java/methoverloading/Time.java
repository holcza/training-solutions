package methoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;

    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        hours = time.hours;
        minutes = time.minutes;
        seconds = time.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        boolean isEqual = false;
        if (time.hours == hours && time.minutes == minutes && time.seconds == seconds) {
            isEqual = true;
        }
        return isEqual;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        boolean isEqual = false;
        if (this.hours == hours && this.minutes == minutes && this.seconds == seconds) {
            isEqual = true;
        }
        return isEqual;
    }

    public boolean isEarlier(Time time) {
        boolean isEarlier = false;
        if (time.hours * 60 * 60 + time.minutes * 60 + time.seconds > hours * 60 * 60 + minutes * 60 + seconds) {
            isEarlier = true;
        }
        return isEarlier;
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        boolean isEarlier = false;
        if (hours * 60 * 60 + minutes * 60 + seconds > this.hours * 60 * 60 + this.minutes * 60 + this.seconds) {
            isEarlier = true;
        }
        return isEarlier;
    }
}
