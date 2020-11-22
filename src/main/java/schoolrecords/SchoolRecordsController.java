package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    ClassRecords classRecords;
    List<Subject> subjects = new ArrayList<>();
    List<Tutor> tutors = new ArrayList<>();

    public void initSchool() {
        classRecords = new ClassRecords("1A", new Random());
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
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Kit keresel?");
                    try {

                        System.out.println(classRecords.findStudentByName(scanner.nextLine()).toString());
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Add meg a nevét");
                    boolean result = classRecords.addStudent(new Student(scanner.nextLine()));
                    if (!result) {
                        System.out.println("Már van ilyen nevű diák");
                    } else {
                        System.out.println("Kész");
                    }
                    break;
                case 4:
                    System.out.println("Add meg a nevét");
                    try {
                        boolean result2 = classRecords.removeStudent(classRecords.findStudentByName(scanner.nextLine()));
                        if (result2) {
                            System.out.println("Törlés megtörtént");
                        } else {
                            System.out.println("Nincs ilyen nevű diák");
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case 5:
                    try {

                        Student student = classRecords.repetition();
                        System.out.println("A tanuló, aki felel: " + student.getName());
                        System.out.println("Mi az érdemjegy?");
                        String mark = scanner.nextLine();
                        System.out.println("Mi a tantárgy?");
                        String subject = scanner.nextLine();
                        System.out.println("Ki az oktató?");
                        String tutor = scanner.nextLine();
                        int iSubject = -1;
                        int iTutor = -1;
                        for (int i = 0; i < subjects.size(); i++) {
                            if (subjects.get(i).getSubjectName().equals(subject)) {
                                iSubject = i;
                            }
                        }
                        for (int i = 0; i < tutors.size(); i++) {
                            if (tutors.get(i).getName().equals(tutor)) {
                                iTutor = i;
                            }
                        }
                        Mark markNew = new Mark(mark, subjects.get(iSubject), tutors.get(iTutor));
                        student.grading(markNew);
                        System.out.println("Érdemjegy felvéve");
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    } catch (IndexOutOfBoundsException aio) {
                        System.out.println("nincs ilyen tantárgy vagy oktató");
                    }


                    break;
                case 6:
                    try {
                        System.out.println("Az osztályátlag: " + classRecords.calculateClassAverage());

                    } catch (ArithmeticException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Add meg a tantárgy nevét");
                    try {

                        System.out.println("Az átlag: " + classRecords.calculateClassAverageBySubject(new Subject(scanner.nextLine())));
                    } catch (ArithmeticException ae) {
                        System.out.println(ae.getMessage());
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    }

                    break;
                case 8:
                    List<StudyResultByName> studyResultsByName = classRecords.listStudyResults();

                    for (StudyResultByName s : studyResultsByName) {
                        System.out.println(s.getStudentName() + " átlag: " + s.getStudyAverage());
                    }

                    break;
                case 9:
                    System.out.println("Add meg a tanuló nevét");
                    try {
                        System.out.println(classRecords.findStudentByName(scanner.nextLine()).calculateAverage());
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("Add meg a tanuló nevét");
                    String name = scanner.nextLine();
                    System.out.println("Add meg a tantárgy nevét");
                    String subject = scanner.nextLine();
                    try {
                        System.out.println(classRecords.findStudentByName(name).calculateSubjectAverage(new Subject(subject)));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case 11:
                    exit = true;
                    break;
                default:
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
