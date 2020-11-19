package week03;

import org.junit.jupiter.api.Test;
import week03.Phone;
import week03.PhoneParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    void parseTest() {

        PhoneParser phoneParser = new PhoneParser();

        assertEquals("prefix= 20 number= 1234567", phoneParser.parse("20-1234567").toString());


    }
}
