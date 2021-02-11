package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos =new ArrayList<>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... name){
        for (String n: name){
            photos.add(new Photo(n));
        }
    }

    public void starPhoto(String name, Quality quality){
        for (Photo p: photos){
            if (p.getName().equals(name)){
                p.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("Photo does not exist");
    }

    public int numberOfStars(){
        int sum = 0;

        for (Photo p: photos){
            sum += p.getQuality().value;
        }

        return sum;
    }

}
