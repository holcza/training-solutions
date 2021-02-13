package week08d05;


import java.io.FileInputStream;
import java.io.IOException;

public class Plane {

    public int maxOceanLength (String path){

        int max =0;
        try(FileInputStream reader = new FileInputStream(path)) {
            int input;
            int counter=0;

            while ((input = reader.read())!=-1){
                if (input == '0'){
                    counter++;
                } else {
                    if(counter>max){
                        max = counter;
                    }
                    counter = 0;
                }
            }


        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }

        return max;
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.maxOceanLength("map.txt"));
    }
}
