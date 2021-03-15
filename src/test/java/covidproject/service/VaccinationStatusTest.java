package covidproject.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationStatusTest {

    @Test
    public void testConstructor() {
        VaccinationStatus vaccinationStatus = new VaccinationStatus(2, 1, LocalDate.of(2021, 3, 4));
        assertEquals(vaccinationStatus.getCitizen_id(), 2);
        assertEquals(vaccinationStatus.getNumberOfVaccination(), 1);
        assertEquals(vaccinationStatus.getLastDate(), LocalDate.of(2021, 3, 4));
    }
}