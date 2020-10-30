package solutions.statements;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getInMinutes (){
        return this.hour*60+this.minute;
    }

    public int getInSeconds (){
        return this.hour*60*60+this.minute*60+this.second;
    }

    public boolean earlierThan(Time time){
        return time.getInSeconds()> this.hour*60*60+this.minute*60+this.second ? true : false;
    }

    public String toString (){
        return this.hour+":"+this.minute+":"+this.second;
    }
}
