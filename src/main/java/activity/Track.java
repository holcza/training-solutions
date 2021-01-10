package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint (TrackPoint point){
        trackPoints.add(point);
    }

    public Coordinate findMaximumCoordinate(){
        double maxlatitude =-90;
        double maxlongitude = -180;
        for (TrackPoint tp:trackPoints){
            if (tp.getCoordinate().getLatitude()>maxlatitude){
                maxlatitude = tp.getCoordinate().getLatitude();
            }

            if (tp.getCoordinate().getLongitude()>maxlongitude){
                maxlongitude = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxlatitude,maxlongitude);
    }

    public Coordinate findMinimumCoordinate(){
        double minlatitude =90;
        double minlongitude = 180;
        for (TrackPoint tp:trackPoints){
            if (tp.getCoordinate().getLatitude()<minlatitude){
                minlatitude = tp.getCoordinate().getLatitude();
            }

            if (tp.getCoordinate().getLongitude()<minlongitude){
                minlongitude = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minlatitude,minlongitude);
    }

    public double getDistance(){
        double sum = 0;
        for (int i = 1; i<trackPoints.size();i++){
            sum += Math.abs(trackPoints.get(i).getDistanceFrom(trackPoints.get(i-1)));
        }
        return sum;
    }

    public double getFullDecrease(){
        double sum =0;
        for (int i = 1; i<trackPoints.size();i++){
            if (trackPoints.get(i).getElevation()<trackPoints.get(i-1).getElevation()){

                sum += trackPoints.get(i-1).getElevation()-trackPoints.get(i).getElevation();
            }
        }
        return sum;

    }

    public double getFullElevation(){

        double sum =0;
        for (int i = 1; i<trackPoints.size();i++){
            if (trackPoints.get(i).getElevation()>trackPoints.get(i-1).getElevation()){

                sum += trackPoints.get(i).getElevation()-trackPoints.get(i-1).getElevation();
            }
        }
        return sum;

    }

    public double getRectangleArea(){
        Coordinate coordinate1 = findMaximumCoordinate();
        Coordinate coordinate2 = findMinimumCoordinate();


        double distance1 = coordinate1.getLatitude()-coordinate2.getLatitude();
        double distance2 = coordinate1.getLongitude()-coordinate2.getLongitude();
        return distance1*distance2;
    }

    public void loadFromGpx(InputStream inputStream){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){

            String line;
            double latitude;
            double longitude;
            double elevation;
            while ((line = br.readLine())!=null){
                if (line.length()>10 && line.substring(3,9).equals("<trkpt")){
                    latitude = Double.parseDouble(line.substring(15,25));
                    longitude = Double.parseDouble(line.substring(32,42));
                    line = br.readLine();
                    elevation = Double.parseDouble(line.substring(9,14));
                    trackPoints.add(new TrackPoint(new Coordinate(latitude,longitude),elevation));
                }
            }
        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
    }
}
