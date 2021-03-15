package covidproject.database;

import activityTracker.ActivityDao;
import covidproject.service.Person;
import covidproject.service.PersonValidator;
import covidproject.service.VaccinationStatus;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensDaoTest {
    CitizensDao citizensDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        Flyway flyway = Flyway.configure().locations("classpath:covid/db/migration").dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        citizensDao = new CitizensDao(dataSource);
    }

    @Test
    void insertCitizensInvalid() throws SQLException {
        List<Person> citizens = List.of(new Person("John Doe", "2000", 40, "f@g", "123456788")
                , new Person("Jane Doe", "2000", 41, "f@h", "123456795"));

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> citizensDao.insertCitizens(citizens));
        assertEquals(thrown.getMessage(), "Taj is already registered in row: 1");


        IllegalArgumentException thrown3 = assertThrows(
                IllegalArgumentException.class,
                () -> citizensDao.getVaccinationStatusByTaj("123456795"));
        assertEquals(thrown3.getMessage(), "Taj is not registered");

    }

    @Test
    void insertCitizensValid() throws SQLException {
        List<Person> citizens = List.of(new Person("John Doe", "2000", 40, "f@g", "123456771")
                , new Person("Jane Doe", "2000", 41, "f@h", "123456795"));
        citizensDao.insertCitizens(citizens);
        VaccinationStatus vaccinationStatus = citizensDao.getVaccinationStatusByTaj("123456795");
        assertEquals(vaccinationStatus.getNumberOfVaccination(), 0);
    }

    @Test
    void getCitizensToVaccinateByZip() {
        List<Person> citizens = citizensDao.getCitizensToVaccinateByZip("2000");

        assertEquals(citizens.get(0).getName(), "Jane Doe");
    }


    @Test
    void updateVaccinationStatus() throws SQLException {
        VaccinationStatus vaccinationStatus = new VaccinationStatus(1, 2, LocalDate.of(2021, 3, 4));
        citizensDao.updateVaccinationStatus(vaccinationStatus);
        VaccinationStatus vaccinationStatusUpdated = citizensDao.getVaccinationStatusByTaj("123456788");
        assertEquals(vaccinationStatusUpdated.getNumberOfVaccination(), 2);
    }
}