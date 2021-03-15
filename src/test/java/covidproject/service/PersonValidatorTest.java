package covidproject.service;

import covidproject.database.CitiesDao;
import covidproject.database.CitizensDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonValidatorTest {

    @Test
    void emptyCheckTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emptyCheck(""));
        assertEquals(thrown.getMessage(), "No data was given");
    }

    @Test
    void zipCheckUnvalidTest() {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.zipCheck("1000", dataSource));
        assertEquals(thrown.getMessage(), "Not valid zip");
    }

    @Test
    void zipCheckValidTest() {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        assertEquals(PersonValidator.zipCheck("2000", dataSource), List.of("Szentendre").toString());
    }

    @Test
    void ageCheckJoughtTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.ageCheck(9));
        assertEquals(thrown.getMessage(), "Not valid age");
    }

    @Test
    void ageCheckOldTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.ageCheck(151));
        assertEquals(thrown.getMessage(), "Not valid age");
    }

    @Test
    void emailCheckMissingLetterTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emailCheck("fgkdlsefs.hu"));
        assertEquals(thrown.getMessage(), "Not valid email");
    }

    @Test
    void emailCheckShortTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emailCheck("f@"));
        assertEquals(thrown.getMessage(), "Not valid email");
    }

    @Test
    void sameEmailCheckTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.sameEmailCheck("f@f", "g@f"));
        assertEquals(thrown.getMessage(), "Not the same email");
    }

    @Test
    void tajCheckLongTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.tajCheck("1234567899"));
        assertEquals(thrown.getMessage(), "Not correct length of taj number");
    }

    @Test
    void tajCheckNotValidTest() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.tajCheck("123456789"));
        assertEquals(thrown.getMessage(), "Not valid taj number");
    }

}