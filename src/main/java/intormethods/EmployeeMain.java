package intormethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Kis Katalin",2018,300000);

        employee.raiseSalary(100000);

        System.out.println(employee.toString());
    }
}
