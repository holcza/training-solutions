package solutions.week02;

public class MeetingRoom {
    private String name;
    private int lenght;
    private int width;

    public MeetingRoom(String name, int lenght, int width) {
        this.name = name;
        this.lenght = lenght;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public int getLenght() {
        return lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea(){
        return lenght*width;
    }
}
