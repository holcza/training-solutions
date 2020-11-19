package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        boolean isTeaching = false;
        for (int i = 0; i < taughtSubjects.size(); i++) {
            if (subject.getSubjectName() == taughtSubjects.get(i).getSubjectName()) {
                isTeaching = true;
            }
        }
        return isTeaching;
    }
}
