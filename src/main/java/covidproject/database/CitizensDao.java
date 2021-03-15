package covidproject.database;

import covidproject.service.Person;
import covidproject.service.PersonValidator;
import covidproject.service.VaccinationStatus;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitizensDao {

    private MariaDbDataSource dataSource;

    public CitizensDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertCitizens(List<Person> persons) {
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
                    insertOneCitizen(stmt, count, person);
                }
                conn.commit();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    private void insertOneCitizen(PreparedStatement stmt, int count, Person person) throws SQLException {
        try (ResultSet rs = getResultOfTaj(person.getTaj())) {
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

    public List<Person> getCitizensToVaccinateByZip(String zip) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from citizens where zip = ? order by age desc, citizen_name");
        ) {
            stmt.setString(1, zip);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                return listCitizensToVaccinateByZip(zip, rs);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private List<Person> listCitizensToVaccinateByZip(String zip, ResultSet rs) throws SQLException {
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
            filterCitizensToVaccinate(zip, citizens, name, age, email, taj, numberOfVaccination, lastVaccination);
        }
        return citizens;
    }

    private void filterCitizensToVaccinate(String zip, List<Person> citizens, String name, int age, String email, String taj, int numberOfVaccination, LocalDate lastVaccination) {
        if (numberOfVaccination == 0 || (numberOfVaccination == 1 && Period.between(lastVaccination, LocalDate.now()).getDays() >= 15)) {
            Person person = new Person(name, zip, age, email, taj);
            citizens.add(person);
        }
    }

    public VaccinationStatus getVaccinationStatusByTaj(String taj) {
        PersonValidator.tajCheck(taj);
        try (ResultSet rs = getResultOfTaj(taj)) {
            return processResultOfTaj(rs);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot select", sqle);
        }
    }

    private VaccinationStatus processResultOfTaj(ResultSet rs) throws SQLException {
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
    }

    private ResultSet getResultOfTaj(String taj) throws SQLException {
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

    public Map<String, Map<Integer, Integer>> mapCitizensbyZipWithNumberOfVaccination() {
        Map<String, Map<Integer, Integer>> citizensbyZip = new HashMap<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select taj,zip,number_of_vaccination from citizens")
        ) {

            while (rs.next()) {
                processOneLineOfResult(citizensbyZip, rs);
            }
            return citizensbyZip;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private void processOneLineOfResult(Map<String, Map<Integer, Integer>> citizensbyZip, ResultSet rs) throws SQLException {
        String zip = rs.getString("zip");
        int numberOfVaccination = rs.getInt("number_of_vaccination");
        if (citizensbyZip.containsKey(zip)) {
            citizensbyZip.get(zip).put(numberOfVaccination, citizensbyZip.get(zip).get(numberOfVaccination) + 1);
        } else {
            Map<Integer, Integer> numberOfVaccinations = new HashMap<>();
            numberOfVaccinations.put(0, 0);
            numberOfVaccinations.put(1, 0);
            numberOfVaccinations.put(2, 0);
            numberOfVaccinations.put(numberOfVaccination, numberOfVaccinations.get(numberOfVaccination) + 1);
            citizensbyZip.put(zip, numberOfVaccinations);
        }
    }
}


