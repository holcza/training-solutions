package debug;

public class CompanyMain {

    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Employee("Kis János", 1984));
        company.addEmployee(new Employee("Nagy Béla", 1991));
        company.addEmployee(new Employee("Kerti Virág", 1977));
        company.addEmployee(new Employee("Kovács Anna", 1995));

        System.out.println(company.findEmployeeByName("Kovács Anna").getName() + " , " + company.findEmployeeByName("Kovács Anna").getYearOfBirth());


        System.out.println(company.listEmployeeNames());
    }
}
