package week03.enaplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<String > students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student){
        boolean addStudentInClass= false;
        for (String st: students) {
            if (st==student.getName()){
                addStudentInClass = true;
            }
        }
        if (addStudentInClass==false){
            students.add(student.getName());
        }
        return addStudentInClass;
    }

    public boolean removeStudent (Student student){
        boolean removeStudentInClass= true;
        for (String st: students) {
            if (st==student.getName()){
                removeStudentInClass = false;
            }
        }
        if (removeStudentInClass==false){
            students.remove(student.getName());
        }
        return removeStudentInClass;
    }

    public  double calculateClassAverage (){
        double average=0;
        int numberToDivideBy=0;
        for (int i=0;i<students.size();i++){
            average +=new Student(students.get(i)).calculateAverage();

            numberToDivideBy++;
        }
        average = numberToDivideBy==0 ? 0.0 : Math.round(average/numberToDivideBy*100)/100.0;
        return average;
    }

    public double calculateClassAverageBySubject(Subject subject){
        double average=0;
        int numberToDivideBy=0;
        for (int i=0;i<students.size();i++){
            average +=new Student(students.get(i)).calculateSubjectAverage(subject);

            numberToDivideBy++;
        }
        average = numberToDivideBy==0 ? 0.0 : Math.round(average/numberToDivideBy*100)/100.0;
        return average;
    }

    public Student findStudentByName (String name){
        boolean find = false;
        for (int i=0;i<students.size();i++){
            if (students.get(i)==name){
                find = true;
            }

        }
        return find== true ? new Student("") : null;
    }

    private boolean isEmpty(String name){
        return  true;
    }

    public String listStudentNames(){
        return "";
    }

    public List<StudyResultByName> listStudyResults(){
        return new ArrayList<>();
    }

    public Student repetition(){
        return new Student("");
    }
}
