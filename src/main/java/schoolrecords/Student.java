package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String returnString = name;
        for (int i = 0; i < marks.size(); i++) {
            returnString += " marks: " + marks.get(i).getSubject().getSubjectName() + ": " + marks.get(i).toString();
        }
        return returnString;
    }

    public double calculateAverage() {
        double average = 0;
        int toDivide = 0;
        for (int i = 0; i < marks.size(); i++) {
            average += marks.get(i).getMarkType().getValue();
            toDivide++;
        }

        average = toDivide == 0 ? 0.0 : Math.round(average / toDivide * 100) / 100.0;
        return average;
    }

    public double calculateSubjectAverage(Subject subject) {

        double average = 0;
        int toDivide = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getSubject().getSubjectName().equals(subject.getSubjectName())) {
                average += marks.get(i).getMarkType().getValue();
                toDivide++;
            }
        }
        average = toDivide == 0 ? 0.0 : Math.round(average / toDivide * 100) / 100.0;
        return average;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String name) {
        if (name == "") {
            return true;
        }
        return false;
    }

}
