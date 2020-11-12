package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    LocalDate date;
    String artist;
    LocalTime startTime;
    LocalTime endTime;

    public Performance(LocalDate date, String artist, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.artist = artist;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void getInfo(){
        System.out.println('"'+artist+": "+date+" "+startTime+" - "+endTime+'"');
    }
}
