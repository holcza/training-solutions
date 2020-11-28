package week05.week05d05;

public class Song {
    private String name;
    private long lengthInSeconds;
    private String artist;

    private void isValid() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Not valid name");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Not valid artist");
        }
        if (lengthInSeconds < 0) {
            throw new IllegalArgumentException("Not valid length in Seconds");
        }

    }

    public Song(String name, long lengthInSeconds, String artist) {
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;

        isValid();
    }

    public int inMinute(){
        int inMinute=(int)lengthInSeconds/60;
        return inMinute;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", lengthInSeconds=" + lengthInSeconds +
                ", artist='" + artist + '\'' +
                '}';
    }
}
