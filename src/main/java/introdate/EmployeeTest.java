package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Name:");
        String name=scanner.nextLine();
        System.out.println("Date of Birth YYYY MM DD :");
        int year=scanner.nextInt();
        int month=scanner.nextInt();
        int day=scanner.nextInt();
        scanner.nextLine();
         Employee employee =new Employee(year,month,day,name);
        System.out.println( "Name :"+employee.getName()+" Date of Birth: "+employee.getDateOfBirth()+" Time when started: "+employee.getBeginEmployment());

    }
}
