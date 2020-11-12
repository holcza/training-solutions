package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);
    }

    public void printNames(){

        for (int i= 0;i<meetingRooms.size();i++) System.out.println(meetingRooms.get(i).getName());
    }

    public void printNamesReverse(){

        for (int i= 0;i<meetingRooms.size();i++) System.out.println(meetingRooms.get(meetingRooms.size()-i-1).getName());
    }

    public void printEvenNames() {

        for (int i = 0; i < meetingRooms.size(); i++) {
            if (i % 2 == 1) {

                System.out.println(meetingRooms.get(i).getName());
            }
        }
    }

    public void printAreas(){
        for (int i= 0;i<meetingRooms.size();i++) {
            System.out.println(meetingRooms.get(i).getName()+": "+meetingRooms.get(i).getLenght()+"m szélesség ,"+meetingRooms.get(i).getWidth()+"m hossz" +
                    "ság ,"+meetingRooms.get(i).getArea()+"m terület");
        }
    }

    public void printMeetingRoomsWithName(String name){
        for (int i= 0;i<meetingRooms.size();i++) {
            if (meetingRooms.get(i).getName().equals(name)){
            System.out.println(meetingRooms.get(i).getName()+": "+meetingRooms.get(i).getLenght()+"m szélesség ,"+meetingRooms.get(i).getWidth()+"m hossz" +
                    "ság ,"+meetingRooms.get(i).getArea()+"m terület");
            }
        }
    }

    public void printMeetingRoomsContains(String part){
        for (int i= 0;i<meetingRooms.size();i++) {
            if (meetingRooms.get(i).getName().toLowerCase().contains(part.toLowerCase())){
                System.out.println(meetingRooms.get(i).getName()+": "+meetingRooms.get(i).getLenght()+"m szélesség ,"+meetingRooms.get(i).getWidth()+"m hossz" +
                        "ság ,"+meetingRooms.get(i).getArea()+"m terület");
            }
        }
    }

    public void printAreasLargerThan(int area){
        for (int i= 0;i<meetingRooms.size();i++) {
            if (meetingRooms.get(i).getArea()>area){
                System.out.println(meetingRooms.get(i).getName()+": "+meetingRooms.get(i).getLenght()+"m szélesség ,"+meetingRooms.get(i).getWidth()+"m hossz" +
                        "ság ,"+meetingRooms.get(i).getArea()+"m terület");
            }
        }

    }
}
