package covidproject.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testConstructor() {
        Person person = new Person("John Doe", "2000", 40, "john.doe@mail.hu", "123456788");
        assertEquals(person.getTaj(), "123456788");
        assertEquals(person.getName(), "John Doe");
        assertEquals(person.getZip(), "2000");
        assertEquals(person.getEmail(), "john.doe@mail.hu");
        assertEquals(person.getAge(), 40);
    }
}