package solutions.stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        boolean validUsername= userValidator.isValidUsername(scanner.nextLine());
        System.out.println("The username is : "+(validUsername==true ? "valid" : "not correct"));
        System.out.println("Password: ");
        String password1 = scanner.nextLine();
        System.out.println("Password again: ");
        String password2 = scanner.nextLine();
        System.out.println("The password is : "+(userValidator.isValidPassword(password1,password1)==true ? "valid" : "not correct"));
        System.out.println("Email: ");
        System.out.println("The email is : "+(userValidator.isValidEmail(scanner.nextLine())==true ? "valid" : "not correct"));




    }
}
