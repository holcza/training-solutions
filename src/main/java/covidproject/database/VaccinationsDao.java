package covidproject.database;

import covidproject.service.Brand;
import covidproject.service.Vaccination;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class VaccinationsDao {

    private MariaDbDataSource dataSource;

    public VaccinationsDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVaccination(Vaccination vaccination) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(
                                "insert into vaccinations(citizen_id,vaccination_date,status_of_vaccination,note,vaccination_type) " +
                                        "values (?,?,?,?,?)")) {
            stmt.setInt(1, vaccination.getCitizenID());
            stmt.setDate(2, Date.valueOf(vaccination.getVaccinationDate()));
            stmt.setString(3, vaccination.getStatus().toString());
            stmt.setString(4, vaccination.getNote());
            stmt.setString(5, vaccination.getVaccination_type().toString());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public Brand getBrandOfPreviousVaccination(int id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select vaccination_type from vaccinations where citizen_id = ?");
        ) {
            stmt.setInt(1, id);

            return getBrand(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    private Brand getBrand(PreparedStatement stmt) throws SQLException {
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            if (rs.next()) {
                Brand brand = Brand.valueOf(rs.getString("vaccination_type"));
                return brand;
            }
            throw new IllegalArgumentException("No result");
        }
    }
}
