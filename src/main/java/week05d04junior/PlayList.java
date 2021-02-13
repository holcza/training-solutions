package week05d04junior;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song>songs=new ArrayList<>();

    public List<Song> findByLengthGreaterThan (int inMin){
        List<Song> finalList = new ArrayList<>();
        for (Song s:songs){
            if (s.inMinute()>inMin){
                finalList.add(s);
            }
        }
        return finalList;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "songs=" + songs +
                '}';
    }
}
