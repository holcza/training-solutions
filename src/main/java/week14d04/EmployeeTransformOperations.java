package week14d04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {
    public List<Employee> transformToUppercased(List<Employee> employees) {
        return employees.stream()
                .map(Employee::upperCased)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Jack"));

        System.out.println(employees);
        System.out.println(new EmployeeTransformOperations().transformToUppercased(employees));
    }
}
