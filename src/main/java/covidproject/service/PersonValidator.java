package covidproject.service;

import covidproject.database.CitiesDao;
import org.mariadb.jdbc.MariaDbDataSource;

import java.util.List;

public class PersonValidator {

    public static void emptyCheck(String s) {
        if (s.isBlank() || s == null) {
            throw new IllegalArgumentException("No data was given");
        }
    }

    public static String zipCheck(String zip, MariaDbDataSource dataSource) {
        CitiesDao citiesDao = new CitiesDao(dataSource);
        List<String> cities = citiesDao.listCityNames(zip);
        if (cities == null || cities.size() == 0) {
            throw new IllegalArgumentException("Not valid zip");
        }
        return cities.toString();
    }

    public static void ageCheck(int age) {
        if (age < 10 || age > 150) {
            throw new IllegalArgumentException("Not valid age");
        }
    }

    public static void emailCheck(String email) {
        if (email == null || !email.contains("@") || email.length() < 3) {
            throw new IllegalArgumentException("Not valid email");
        }
    }

    public static void sameEmailCheck(String email1, String email2) {
        if (!email1.equals(email2)) {
            throw new IllegalArgumentException("Not the same email");
        }
    }

    public static void tajCheck(String taj) {
        if (taj.length() == 9) {
            checkTajCalculation(taj);
        } else {
            throw new IllegalArgumentException("Not correct length of taj number");
        }
    }

    private static void checkTajCalculation(String taj) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                sum += Integer.parseInt(String.valueOf(taj.charAt(i))) * 3;
            } else {
                sum += Integer.parseInt(String.valueOf(taj.charAt(i))) * 7;
            }
        }
        if (sum % 10 != Integer.parseInt(String.valueOf(taj.charAt(8)))) {
            throw new IllegalArgumentException("Not valid taj number");
        }
    }


}
