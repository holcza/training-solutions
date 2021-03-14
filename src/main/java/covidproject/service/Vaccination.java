package covidproject.service;

import java.time.LocalDate;

public class Vaccination {

    private int citizenID;

    private LocalDate vaccinationDate;

    private Status status;

    private String note;

    private Brand vaccination_type;

    public Vaccination(int id, LocalDate vaccinationDate, Status status, Brand vaccination_type) {
        this.citizenID = id;
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.vaccination_type = vaccination_type;
        this.note = "";
    }

    public Vaccination(int id, LocalDate vaccinationDate, Status status, String note) {
        this.citizenID = id;
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.note = note;
        this.vaccination_type = Brand.NONE;
    }

    public int getCitizenID() {
        return citizenID;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public Brand getVaccination_type() {
        return vaccination_type;
    }
}
