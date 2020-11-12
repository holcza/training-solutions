package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeByName(String name) {
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getName().equals(name)) {
                employee = new Employee(name, employees.get(i).getYearOfBirth());
            }
        }
        return employee;
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            names.add(employees.get(i).getName());
        }
        return names;
    }
}
