package week07d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveInputTest {

    @TempDir
    Path tempDir;

    @Test
    void readTest() {
        Scanner scanner = new Scanner("aa\nbb\ncc");
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.read();
        assertEquals(List.of("aa", "bb", "cc"), lines);
    }

    @Test
    void readFileNameTest() {
        Scanner scanner = new Scanner("abc.txt");
        SaveInput saveInput = new SaveInput(scanner);
        Path file = saveInput.readFileName();
        assertEquals(Path.of("abc.txt"), file);

    }

    @Test
    void writeTest() throws IOException {
        //Given
        SaveInput saveInput = new SaveInput(new Scanner(System.in));
        List<String> lines = List.of("aa\nbb\ncc");
        Path file = tempDir.resolve("test.txt");
        //When
        saveInput.write(file,lines);
        //Than
        String result = Files.readString(file);


    }
}
