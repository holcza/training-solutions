package covidproject.service;

public class Person {

    private String name;

    private String zip;

    private int age;

    private String email;

    private String taj;

    public Person(String name, String zip, int age, String email, String taj) {
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.taj = taj;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    @Override
    public String toString() {
        return name + ';' + zip + ';' + age + ';' + email + ';' + taj;
    }
}
