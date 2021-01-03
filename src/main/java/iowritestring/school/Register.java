package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {
    public void newMark(Path path, int mark) {
        try {
            if (Files.exists(path)){
                Files.writeString(path,mark+"\n",StandardOpenOption.APPEND);
            } else {
                Files.writeString(path,mark+"\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public void average (Path path){

        double sum = 0;
        int count = 0;
        try {
            List<String> marks = Files.readAllLines(path);
            count = marks.size();
            for (String m: marks){
                sum += Integer. parseInt(m);
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
        double average = count == 0 ? 0 : sum/count;

        try{
            Files.writeString(path, "average: "+ average, StandardOpenOption.APPEND);
        } catch (IOException ioe){
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        Register diary = new Register();
        Path path = Path.of("src/main/resources/tanulo_neve.txt");
        diary.newMark(path,5);
        diary.newMark(path,4);
        diary.average(path);
    }
}


