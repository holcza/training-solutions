package covidproject.service;

import java.time.LocalDate;

public class VaccinationStatus {

    private int citizen_id;

    private int numberOfVaccination;

    private LocalDate lastDate;

    public VaccinationStatus(int citizen_id, int numberOfVaccination, LocalDate lastTime) {
        this.citizen_id = citizen_id;
        this.numberOfVaccination = numberOfVaccination;
        this.lastDate = lastTime;
    }

    public int getCitizen_id() {
        return citizen_id;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

}
