package covidproject.database;

import covidproject.service.Brand;
import covidproject.service.Status;
import covidproject.service.Vaccination;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationsDaoTest {
    VaccinationsDao vaccinationsDao;

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

        vaccinationsDao = new VaccinationsDao(dataSource);
    }

    @Test
    void insertVaccinationTest() {
        Vaccination vaccination = new Vaccination(1, LocalDate.of(2021, 3, 4), Status.FIRST, Brand.SZPUTNYIK);
        vaccinationsDao.insertVaccination(vaccination);

        assertEquals(vaccinationsDao.getBrandOfPreviousVaccination(1), Brand.SZPUTNYIK);
    }

}