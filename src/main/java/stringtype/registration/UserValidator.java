package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername (String username){
        boolean isValidUsername = username=="" ? false : true;
        return isValidUsername;
    }

    public boolean isValidPassword (String password1, String password2){
        boolean isValidPassword = password1.length()<8 || password2.length()<8 || !password1.equals(password2)? false:true;
        return isValidPassword;

    }

    public boolean isValidEmail(String email){
        boolean isValidEmail = email.indexOf("@")==-1 || email.indexOf(".")==-1 ||email.indexOf("@")==0 || email.indexOf(".")==email.length()-1||email.indexOf("@")+1==email.indexOf(".") ? false : true;
        return isValidEmail;
    }
}
