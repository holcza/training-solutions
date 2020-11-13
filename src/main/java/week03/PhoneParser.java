package week03;

public class PhoneParser {
    public Phone parse (String telNumber){

        Phone phone = new Phone(telNumber.split("-")[0], telNumber.split("-")[1]);

        return phone;
    }
}
