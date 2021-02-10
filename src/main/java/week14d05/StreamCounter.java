package week14d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCounter {

    public static final String NAME_OF_DOG = "Hach";

    public long countName(String file){
        Path path = Path.of(file);
        try(Stream<String> lines = Files.lines(path)){
            return lines
                    .filter(StreamCounter::containsName)
                    .peek(System.out::println)
                    .flatMap(StreamCounter :: lineToWords)
                    .filter(StreamCounter::containsName)
                    .count();

        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file");
        }
    }

    private static <R> Stream<? extends String> lineToWords(String s) {
        return Arrays.stream(s.split(" "));
    }

    private static boolean containsName(String s) {
        return s.contains(NAME_OF_DOG);
    }

    public static void main(String[] args) {
        System.out.println(new StreamCounter().countName("hachiko.srt"));
    }
}
