package covidproject.database;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesDao {

    private MariaDbDataSource dataSource;

    public CitiesDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> listCityNames(String zip) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select city from cities where zip = ?");
        ) {
            stmt.setString(1, zip);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                List<String> cities = new ArrayList<>();
                while (rs.next()) {
                    String cityName = rs.getString("city");
                    cities.add(cityName);
                }
                return cities;
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select city", se);
        }
    }


}
