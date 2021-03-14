package covidproject.service;

import covidproject.database.CitizensDao;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static final String REPORT_HEAD = "Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n";

    public static List<Person> readLines(BufferedReader reader, MariaDbDataSource dataSource) throws IOException {
        reader.readLine();
        List<Person> citizens = new ArrayList<>();
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            count++;
            readOneLine(dataSource, citizens, line, count);
        }

        return citizens;
    }

    private static void readOneLine(MariaDbDataSource dataSource, List<Person> citizens, String line, int count) {
        String[] parts = line.split(";");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Not valid data in row: " + count);
        }
        try {
            createCitizenFromLine(dataSource, citizens, parts);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Issue in row: " + count + " - " + iae.getMessage(), iae);
        } catch (Exception e) {
            throw new IllegalArgumentException("File data can not be converted in row: " + count);
        }
    }

    private static void createCitizenFromLine(MariaDbDataSource dataSource, List<Person> citizens, String[] parts) {
        String name = parts[0];
        PersonValidator.emptyCheck(name);
        String zip = parts[1];
        PersonValidator.emptyCheck(zip);
        PersonValidator.zipCheck(zip, dataSource);
        int age = Integer.parseInt(parts[2]);
        PersonValidator.ageCheck(age);
        String email = parts[3];
        PersonValidator.emailCheck(email);
        String taj = parts[4];
        PersonValidator.tajCheck(taj);

        citizens.add(new Person(name, zip, age, email, taj));
    }

    public static void writeLines(String zip, BufferedWriter writer, MariaDbDataSource dataSource) {
        List<Person> citizens = new CitizensDao(dataSource).getCitizensByZip(zip);
        int count = 0;
        LocalTime time = LocalTime.of(8, 0);
        try {
            writer.write(REPORT_HEAD);
            System.out.println(REPORT_HEAD);
            for (Person person : citizens) {
                count++;
                writeOneLine(writer, count, time, person);
                time = setTime(time);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private static LocalTime setTime(LocalTime time) {
        time = time.plusMinutes(30);
        if (time.isAfter(LocalTime.of(16, 0))) {
            time = LocalTime.of(8, 0);
        }
        return time;
    }

    private static void writeOneLine(BufferedWriter writer, int count, LocalTime time, Person person) throws IOException {
        writer.write(
                time.toString() + ";" + person.getName() + ";" + person.getZip()
                        + ";" + person.getAge() + ";" + person.getEmail() + ";" + person.getTaj() + "\n");
        if (count <= 16) {
            System.out.println(time.toString() + ";" + person.getName() + ";" + person.getZip()
                    + ";" + person.getAge() + ";" + person.getEmail() + ";" + person.getTaj());
        }
    }
}
