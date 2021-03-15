package covidproject.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationTest {
    @Test
    public void testConstructorVaccinationDone() {
        Vaccination vaccination = new Vaccination(2, LocalDate.of(2021, 3, 4), Status.FIRST, Brand.SZPUTNYIK);
        assertEquals(vaccination.getCitizenID(), 2);
        assertEquals(vaccination.getVaccinationDate(), LocalDate.of(2021, 3, 4));
        assertEquals(vaccination.getStatus(), Status.FIRST);
        assertEquals(vaccination.getVaccination_type(), Brand.SZPUTNYIK);
        assertEquals(vaccination.getNote(), "");
    }

    @Test
    public void testConstructorVaccinationSkipped() {
        Vaccination vaccination = new Vaccination(2, LocalDate.of(2021, 3, 4), Status.NONE, "pregnancy");
        assertEquals(vaccination.getCitizenID(), 2);
        assertEquals(vaccination.getVaccinationDate(), LocalDate.of(2021, 3, 4));
        assertEquals(vaccination.getStatus(), Status.NONE);
        assertEquals(vaccination.getVaccination_type(), Brand.NONE);
        assertEquals(vaccination.getNote(), "pregnancy");
    }
}