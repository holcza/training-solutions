package covidproject.ui;

import covidproject.database.CitiesDao;
import covidproject.database.CitizensDao;
import covidproject.database.VaccinationsDao;
import covidproject.service.*;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuServiceMain {

    private MariaDbDataSource dataSource;
    private CitiesDao citiesDao;
    private CitizensDao citizensDao;
    private VaccinationsDao vaccinationsDao;
    private Scanner scanner;


    private MenuServiceMain() {
        setDatasource();

        citiesDao = new CitiesDao(dataSource);
        citizensDao = new CitizensDao(dataSource);
        vaccinationsDao = new VaccinationsDao(dataSource);
        scanner = new Scanner(System.in);
    }

    private void setDatasource() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");

        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
    }

    private void menu() {
        do {
            showMenu();

            String menuNumber = scanner.nextLine();

            try {
                switch (menuNumber) {
                    case "1":
                        registrationByPerson();
                        break;
                    case "2":
                        registrationWithFile();
                        break;
                    case "3":
                        generateListOfCitizensToVaccinate();
                        break;
                    case "4":
                        saveVaccinationGiven();
                        break;
                    case "5":
                        saveVaccinationNotGiven();
                        break;
                    case "6":
                        getReportbyZipAndNumberOfVaccination();
                        break;
                    default:
                        throw new IllegalArgumentException("Not valid seleciton");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
    }

    private void getReportbyZipAndNumberOfVaccination() {
        Map<String, Map<Integer, Integer>> reportbyZipAndNumberOfVaccination =
                citizensDao.mapCitizensbyZipWithNumberOfVaccination();
        for (String k : reportbyZipAndNumberOfVaccination.keySet()) {
            Map<Integer, Integer> reportByNumberOfVaccination =
                    reportbyZipAndNumberOfVaccination.get(k);
            System.out.println(k + " - " + reportByNumberOfVaccination.get(0) + " - " + reportByNumberOfVaccination.get(1)
                    + " - " + reportByNumberOfVaccination.get(2));
        }
    }

    private void showMenu() {
        System.out.println("1. Regisztráció\n" +
                "2. Tömeges regisztráció\n" +
                "3. Generálás\n" +
                "4. Oltás\n" +
                "5. Oltás meghiúsulás\n" +
                "6. Riport");
    }

    private void saveVaccinationNotGiven() {
        int citizenID = getVaccinationStatus().getCitizen_id();
        System.out.println("Please give the reason why vaccination can not be given");
        String note = scanner.nextLine();
        LocalDate date = getNewLastDate();
        vaccinationsDao.insertVaccination(new Vaccination(citizenID, date, Status.NONE, note));
        System.out.println("Thank you. Note is registered.");
    }

    private void saveVaccinationGiven() {
        VaccinationStatus vaccinationStatus = getVaccinationStatus();
        int citizenID = vaccinationStatus.getCitizen_id();
        int numberOfVaccination = vaccinationStatus.getNumberOfVaccination();
        LocalDate lastDate = vaccinationStatus.getLastDate();
        switch (numberOfVaccination) {
            case 2:
                throw new IllegalStateException("Already 2 vaccinations were given");

            case 1:
                saveSecondVaccinationGiven(citizenID, numberOfVaccination, lastDate);
                break;
            case 0:
                saveFirstVaccinationGiven(citizenID, numberOfVaccination);
                break;
        }
    }

    private void saveFirstVaccinationGiven(int citizenID, int numberOfVaccination) {
        System.out.println("No vaccination was given yet");
        System.out.println("Please give the vaccine brand which was given today: ");
        Brand brand = Brand.valueOf(scanner.nextLine());
        LocalDate date = getNewLastDate();
        vaccinationsDao.insertVaccination(new Vaccination(citizenID, date, Status.FIRST, brand));
        updateVaccinationStatus(citizenID, numberOfVaccination + 1, date);
    }

    private void saveSecondVaccinationGiven(int citizenID, int numberOfVaccination, LocalDate lastDate) {
        if (Period.between(lastDate, LocalDate.now()).getDays() < 15) {
            throw new IllegalStateException("Last vaccination was less than 15 days before, on day: " + lastDate);
        } else {
            System.out.println("Last vaccination was on day: " + lastDate);
            Brand brand = vaccinationsDao.getBrandOfPreviousVaccination(citizenID);
            System.out.println("Brand of last vaccination: " + brand);
            LocalDate date = getNewLastDate();
            vaccinationsDao.insertVaccination(new Vaccination(citizenID, date, Status.SECOND, brand));
            updateVaccinationStatus(citizenID, numberOfVaccination + 1, date);
        }
    }

    private VaccinationStatus getVaccinationStatus() {
        System.out.println("Please give the taj number: ");
        String taj = scanner.nextLine();
        PersonValidator.tajCheck(taj);
        VaccinationStatus vaccinationStatus = citizensDao.getVaccinationStatusByTaj(taj);
        return vaccinationStatus;
    }

    private void updateVaccinationStatus(int citizenID, int numberOfVaccination, LocalDate date) {

        citizensDao.updateVaccinationStatus(new VaccinationStatus(citizenID, numberOfVaccination, date));
        System.out.println("Thank you. It was registered.");

    }

    private LocalDate getNewLastDate() {
        System.out.println("Please give the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please give the month: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please give the day: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    private void generateListOfCitizensToVaccinate() {
        System.out.println("Please give the zip number: ");
        String zip = scanner.nextLine();
        PersonValidator.zipCheck(zip, dataSource);

        System.out.println("Please give the file name to save the report in: ");
        String file = scanner.nextLine();

        List<Person> citizens = citizensDao.getCitizensToVaccinateByZip(zip);

        saveListOfCitizensToVaccinate(zip, file);
    }

    private void saveListOfCitizensToVaccinate(String zip, String file) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(file))) {
            FileHandler.writeLines(zip, writer, dataSource);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private void registrationWithFile() {
        String path = checkPath();
        List<Person> citizens = readRegistrationFile(path);

        citizensDao.insertCitizens(citizens);

        System.out.println("Registration completed");
    }

    private String checkPath() {
        System.out.println("Please give the filepath: ");
        List<Person> citizens;
        String path = scanner.nextLine();
        if (!Files.exists(Path.of(path))) {
            throw new IllegalArgumentException("Path given does not exists");
        }
        return path;
    }

    private List<Person> readRegistrationFile(String path) {
        List<Person> citizens;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            citizens = FileHandler.readLines(reader, dataSource);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return citizens;
    }

    private void registrationByPerson() {
        String name = getNameInput();

        String zip = getZipInput();

        int age = getAgeInput();

        String email = getEmailInput();

        String taj = getTajInput();

        List<Person> citizens = new ArrayList<>();
        citizens.add(new Person(name, zip, age, email, taj));

        citizensDao.insertCitizens(citizens);

        System.out.println("Registration completed");

    }

    private String getNameInput() {
        System.out.println("Please give me your full name: ");
        String name = scanner.nextLine();
        PersonValidator.emptyCheck(name);
        return name;
    }

    private String getZipInput() {
        System.out.println("Please give me your zip number: ");
        String zip = scanner.nextLine();
        PersonValidator.emptyCheck(zip);
        PersonValidator.zipCheck(zip, dataSource);
        System.out.println("Your city is: " + citiesDao.listCityNames(zip));
        return zip;
    }

    private int getAgeInput() {
        System.out.println("Please give me your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        PersonValidator.ageCheck(age);
        return age;
    }

    private String getEmailInput() {
        System.out.println("Please give me your email: ");
        String email1 = scanner.nextLine();
        PersonValidator.emailCheck(email1);

        System.out.println("Please give me your email again for validation: ");
        String email2 = scanner.nextLine();
        PersonValidator.sameEmailCheck(email1, email2);
        return email1;
    }

    private String getTajInput() {
        System.out.println("Please give me your taj number: ");
        String taj = scanner.nextLine();
        PersonValidator.tajCheck(taj);
        return taj;
    }

    public static void main(String[] args) {
        MenuServiceMain menuServiceMain = new MenuServiceMain();
        menuServiceMain.menu();
    }
}
