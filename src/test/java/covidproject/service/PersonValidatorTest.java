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
    void emptyCheck() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emptyCheck(""));
        assertEquals(thrown.getMessage(), "No data was given");
    }

    @Test
    void zipCheckUnvalid() {
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
    void zipCheckValid() {
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
    void ageCheckJought() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.ageCheck(9));
        assertEquals(thrown.getMessage(), "Not valid age");
    }

    @Test
    void ageCheckOld() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.ageCheck(151));
        assertEquals(thrown.getMessage(), "Not valid age");
    }

    @Test
    void emailCheckMissingLetter() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emailCheck("fgkdlsefs.hu"));
        assertEquals(thrown.getMessage(), "Not valid email");
    }

    @Test
    void emailCheckShort() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.emailCheck("f@"));
        assertEquals(thrown.getMessage(), "Not valid email");
    }

    @Test
    void sameEmailCheck() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.sameEmailCheck("f@f", "g@f"));
        assertEquals(thrown.getMessage(), "Not the same email");
    }

    @Test
    void tajCheckLong() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.tajCheck("1234567899"));
        assertEquals(thrown.getMessage(), "Not correct length of taj number");
    }

    @Test
    void tajCheckNotValid() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> PersonValidator.tajCheck("123456789"));
        assertEquals(thrown.getMessage(), "Not valid taj number");
    }

}