package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName==""||fullName==null){
            throw new IllegalArgumentException("Invalid Name: "+fullName);
        }
        this.fullName = fullName;
    }

    public void changeFistName (String firstname){
        fullName=fullName.substring(0,fullName.indexOf(" "))+" "+firstname;
    }

    public String getFullName() {
        return fullName;
    }
}
