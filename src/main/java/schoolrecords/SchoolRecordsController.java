package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    ClassRecords classRecords;
    List<Subject> subjects = new ArrayList<>();
    List<Tutor> tutors = new ArrayList<>();

    public void initSchool() {
        classRecords= new ClassRecords("1A",new Random());
        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("kémia"));

        tutors.add(new Tutor("Nagy Csilla",
                Arrays.asList(new Subject("fizika"),
                        new Subject("matematika"))));

        tutors.add(new Tutor("Kis Mátyás",
                Arrays.asList(new Subject("kémia"),
                        new Subject("matematika"))));
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Diákok nevének listázása\n" +
                    "2. Diák név alapján keresése\n" +
                    "3. Diák létrehozása\n" +
                    "4. Diák név alapján törlése\n" +
                    "5. Diák feleltetése\n" +
                    "6. Osztályátlag kiszámolása\n" +
                    "7. Tantárgyi átlag kiszámolása\n" +
                    "8. Diákok átlagának megjelenítése\n" +
                    "9. Diák átlagának kiírása\n" +
                    "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                    "11. Kilépés");

            Scanner scanner = new Scanner(System.in);

            int menuPoint = Integer.parseInt(scanner.nextLine());

            switch (menuPoint) {
                case 1:
                    try {
                        System.out.println(classRecords.listStudentNames());
                    }catch (NullPointerException npe){
                        System.out.println(npe.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Kit keresel?");
                    classRecords.findStudentByName(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Add meg a nevét");
                    classRecords.addStudent(new Student(scanner.nextLine()));
                    break;
                case 4:
                    System.out.println("Add meg a nevét");
                    classRecords.removeStudent(classRecords.findStudentByName(scanner.nextLine()));
                    break;
                case 5:
                    classRecords.repetition();
                    break;
                case 6:
                    classRecords.calculateClassAverage();
                    break;
                case 7:
                    System.out.println("Add meg a tantárgy nevét");
                    classRecords.calculateClassAverageBySubject(new Subject(scanner.nextLine()));
                    break;
                case 8:
                    classRecords.listStudyResults();
                    break;
                case 9:
                    System.out.println("Add meg a tanuló nevét");
                    classRecords.findStudentByName(scanner.nextLine()).calculateAverage();
                    break;
                case 10:
                    System.out.println("Add meg a tanuló nevét");
                    String name = scanner.nextLine();
                    System.out.println("Add meg a tantárgy nevét");
                    String subject = scanner.nextLine();
                    classRecords.findStudentByName(name).calculateSubjectAverage(new Subject(subject));
                    break;
                case 11:
                    exit = true;
                    break;

            }
        }


    }


    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();

        schoolRecordsController.menu();


    }
}
