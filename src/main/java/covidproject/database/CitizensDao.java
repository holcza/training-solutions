package covidproject.database;

import covidproject.service.Person;
import covidproject.service.PersonValidator;
import covidproject.service.VaccinationStatus;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CitizensDao {

    private MariaDbDataSource dataSource;

    public CitizensDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertCitizen(List<Person> persons) {
        try (
                Connection conn = dataSource.getConnection();
        ) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt =
                         conn.prepareStatement(
                                 "insert into citizens(citizen_name,zip,age,email,taj,number_of_vaccination) values (?,?,?,?,?,?)")) {
                int count = 0;
                for (Person person : persons) {
                    count++;
                    try (ResultSet rs = isTaj(person.getTaj())) {
                        if (rs.next()) {
                            throw new IllegalArgumentException("Taj is already registered in row: " + count);
                        } else {
                            stmt.setString(1, person.getName());
                            stmt.setString(2, person.getZip());
                            stmt.setInt(3, person.getAge());
                            stmt.setString(4, person.getEmail());
                            stmt.setString(5, person.getTaj());
                            stmt.setInt(6, 0);
                            stmt.executeUpdate();
                        }
                    }
                }
                conn.commit();
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public List<Person> getCitizensByZip(String zip) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from citizens where zip = ? order by age desc, citizen_name");
        ) {
            stmt.setString(1, zip);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                List<Person> citizens = new ArrayList<>();
                while (rs.next()) {
                    String name = rs.getString("citizen_name");
                    int age = rs.getInt("age");
                    String email = rs.getString("email");
                    String taj = rs.getString("taj");
                    int numberOfVaccination = rs.getInt("number_of_vaccination");
                    Date lastVaccinationDate = rs.getDate("last_vaccination");
                    LocalDate lastVaccination = null;
                    if (lastVaccinationDate != null) {
                        lastVaccination = rs.getDate("last_vaccination").toLocalDate();
                    }
                    if (numberOfVaccination == 0 || (numberOfVaccination == 1 && Period.between(lastVaccination, LocalDate.now()).getDays() >= 15)) {
                        Person person = new Person(name, zip, age, email, taj);
                        citizens.add(person);
                    }
                }
                return citizens;
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }


    }

    public VaccinationStatus getVaccinationStatusByTaj(String taj) {
        PersonValidator.tajCheck(taj);
        try (ResultSet rs = isTaj(taj)) {
            ;
            if (rs.next()) {
                int id = rs.getInt("citizen_id");
                int numberOfVaccination = rs.getInt("number_of_vaccination");
                Date date = rs.getDate("last_vaccination");
                LocalDate localDate = null;
                if (date != null) {

                    localDate = rs.getDate("last_vaccination").toLocalDate();
                }
                return new VaccinationStatus(id, numberOfVaccination, localDate);

            } else {
                throw new IllegalArgumentException("Taj is not registered");
            }

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot select", sqle);
        }
    }

    private ResultSet isTaj(String taj) throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt =
                conn.prepareStatement("select citizen_id,number_of_vaccination,last_vaccination from citizens where taj = ?");

        stmt.setString(1, taj);

        ResultSet rs = stmt.executeQuery();

        return rs;
    }

    public void updateVaccinationStatus(VaccinationStatus vaccinationStatus) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("update citizens set number_of_vaccination=?,last_vaccination=? where citizen_id = ?")) {
            stmt.setInt(1, vaccinationStatus.getNumberOfVaccination());
            stmt.setDate(2, Date.valueOf(vaccinationStatus.getLastDate()));
            stmt.setInt(3, vaccinationStatus.getCitizen_id());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }
}


