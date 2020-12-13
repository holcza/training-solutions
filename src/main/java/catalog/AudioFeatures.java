package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{


    private String title;
    private int lenght;
    private List<String> performers;
    private List<String> composer;

    public AudioFeatures(String title, int lenght, List<String> performers, List<String> composer) {
        if (lenght<0){
            throw new IllegalArgumentException("Not valid length");
        }
        if (Validators.isBlank(title)){
            throw new IllegalArgumentException("not valid title");
        }
        this.title = title;
        this.lenght = lenght;
        this.performers = performers;
        this.composer = composer;
    }

    public AudioFeatures(String title, int lenght, List<String> performers) {
        if (lenght<0){
            throw new IllegalArgumentException("Not valid length");
        }
        if (Validators.isBlank(title)){
            throw new IllegalArgumentException("not valid title");
        }
        this.title = title;
        this.lenght = lenght;
        this.performers = performers;
    }

    public int getLength() {
        return lenght;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!Validators.isEmpty(composer)) {
            contributors.addAll(composer);
        }
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
