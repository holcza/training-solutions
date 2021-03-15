package covidproject.database;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitiesDaoTest {
    CitiesDao citiesDao;

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

        citiesDao = new CitiesDao(dataSource);
    }

    @Test
    void listCityNames() {
        assertEquals(citiesDao.listCityNames("2000"), List.of("Szentendre"));
    }
}