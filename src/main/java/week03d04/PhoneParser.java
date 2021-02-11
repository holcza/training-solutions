package week03d04;

import week03d04.Phone;

public class PhoneParser {
    public Phone parse (String telNumber){

        Phone phone = new Phone(telNumber.split("-")[0], telNumber.split("-")[1]);

        return phone;
    }
}
