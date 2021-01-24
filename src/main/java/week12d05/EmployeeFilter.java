package week12d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {



    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee e : employees) {
            if (e.getSkillLevel() > 2 && e.getSkills().contains("programming")) {
                filteredEmployees.add(e);
            }
        }

        return filteredEmployees;
    }

}
