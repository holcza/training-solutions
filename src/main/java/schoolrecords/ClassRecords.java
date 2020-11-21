package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (rnd == null) {
            throw new NullPointerException("Random objektum hiányzik");
        }
        if (isEmpty(className)) {
            throw new IllegalArgumentException("");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("");
        }
        boolean addStudentInClass = true;
        for (Student st : students) {
            if (st.getName() == student.getName()) {
                addStudentInClass = false;
            }
        }
        if (addStudentInClass == true) {
            students.add(student);
        }
        return addStudentInClass;
    }

    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("");
        }
        boolean removeStudentInClass = false;
        for (Student st : students) {
            if (st.getName() == student.getName()) {
                removeStudentInClass = true;
            }
        }
        if (removeStudentInClass == true) {
            students.remove(student);
        }
        return removeStudentInClass;
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double average = 0;
        int numberToDivideBy = students.size();
        for (Student st : students) {
            if (st.marks.size() == 0) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
            average += st.calculateAverage();
        }
        average = numberToDivideBy == 0 ? 0.0 : Math.round(average / numberToDivideBy * 100) / 100.0;
        return average;
    }

    public double calculateClassAverageBySubject(Subject subject) {

        if (subject == null) {
            throw new NullPointerException("");
        }
        if (students == null) {
            throw new ArithmeticException("");
        }
        double average = 0;
        int numberToDivideBy = 0;
        for (Student st : students) {
            if (st.marks == null) {
                throw new ArithmeticException("");
            }
            double averageToAdd = st.calculateSubjectAverage(subject);
            average += averageToAdd;
            if (averageToAdd != 0.0) {
                numberToDivideBy++;
            }

        }
        average = numberToDivideBy == 0 ? 0.0 : Math.round(average / numberToDivideBy * 100) / 100.0;
        return average;
    }

    public Student findStudentByName(String name) {

        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }

        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName() == name) {
                return student;
            }

        }

        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    private boolean isEmpty(String name) {
        if (name == "") {

            return true;
        }
        return false;
    }

    public String listStudentNames() {
        if (students.size()==0){
            throw new NullPointerException("There is no student to list");
        }
        String nameList = "";
        for (Student st : students) {
            nameList += st.getName() + ", ";
        }
        nameList = nameList.substring(0, nameList.length() - 2);
        return nameList;
    }

    public List<StudyResultByName> listStudyResults() {
        if (students==null){
            throw new NullPointerException("There is no student to list");
        }
        List<StudyResultByName> listResult = new ArrayList<>();
        for (Student st : students) {
            listResult.add(new StudyResultByName(st.getName(), st.calculateAverage()));
        }
        return listResult;
    }

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        Student st = students.get(rnd.nextInt(students.size()));
        return st;
    }
}
