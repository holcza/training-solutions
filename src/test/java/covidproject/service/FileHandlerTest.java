package covidproject.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @TempDir
    Path tempDir;


    @Test
    void readLines() throws IOException, SQLException {
        MariaDbDataSource dataSource;

        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("covid");
        dataSource.setPassword("covid");

        BufferedReader reader = new BufferedReader(new InputStreamReader(FileHandlerTest.class.getResourceAsStream("citizens.csv")));
        List<Person> citizens = FileHandler.readLines(reader, dataSource);
        assertEquals(citizens.get(0).toString(), "John Doe;2000;60;john.doe@example.com;123456788");
    }

    @Test
    void writeLines() throws IOException, SQLException {
        MariaDbDataSource dataSource;

        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("covid");
        dataSource.setPassword("covid");

        try (BufferedWriter writer = Files.newBufferedWriter(tempDir.resolve("output.txt"))) {
            FileHandler.writeLines("2000", writer, dataSource);
        }
        List<String> content = Files.readAllLines(tempDir.resolve("output.txt"));
        assertEquals(content.get(1).toString(), "08:00;Jane Doe;2000;41;f@g;122456785");
    }
}