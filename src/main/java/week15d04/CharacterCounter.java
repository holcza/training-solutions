package week15d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCounter {

    private static boolean bySpace(int x) {
        return x != (char) ' ';
    }

    public Map<CharType,Long> count (Path path){
        try(Stream<String > s = Files.lines(path)){
            return s.map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(CharacterCounter::bySpace)
                    .mapToObj(CharType::getType)
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CharacterCounter().count(Path.of("test.txt")));
    }
}
