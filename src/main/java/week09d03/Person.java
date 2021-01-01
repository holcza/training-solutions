package week09d03;

import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        checkName(name);
        checkAge(age);

        this.name = name;
        this.age = age;
    }

    public void setPresent(){
        if (age>=14){
            present = Present.NoPresent;
        } else {
            Random random = new Random();
            int presentNumber = random.nextInt(3);
            present = Present.values()[presentNumber];
        }
    }

    private void checkName(String name){
        if (name==null||name.isBlank()){
            throw new IllegalArgumentException("Name is required");
        }
    }

    private void checkAge (int age){
        if(age<0||age>120){
            throw new IllegalArgumentException("Not correct age");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", present=" + present +
                '}';
    }
}
