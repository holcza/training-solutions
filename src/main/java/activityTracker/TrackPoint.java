package activityTracker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrackPoint {
    private long id;

    private LocalDateTime time;

    private double lat;

    private double lon;

    public TrackPoint(LocalDateTime time, double lat, double lon) {
        this.time = time;
        if (lat>90||lat<-90){
            throw new IllegalArgumentException("Invalid latitude");
        }
        if (lon>180||lon<-180){
            throw new IllegalArgumentException(("Invalid longitude"));
        }
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, LocalDateTime time, double lat, double lon) {
        this(time,lat,lon);
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "TrackPoint{" +
                "id=" + id +
                ", time=" + time +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
