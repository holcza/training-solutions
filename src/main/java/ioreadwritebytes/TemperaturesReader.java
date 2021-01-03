package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {
    public Temperatures readTemperatures ( String pathString){
        Path path = Path.of(pathString);
        byte[] temps;
        try{
             temps= Files.readAllBytes(path);
        } catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
        return new Temperatures(temps);
    }
}
