package week15d05;

public class CovidItems {
    private String country;
    private int population;
    private int cases;
    private double rate;

    public CovidItems(String country, int population, int cases) {
        this.country = country;
        this.population = population;
        this.cases = cases;
        this.rate = (double)cases/population;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getCases() {
        return cases;
    }

    public double getRate() {
        return rate;
    }

    public CovidItems addCovidItems(CovidItems another){
        return new CovidItems(country,population,another.cases+this.cases);
    }

    @Override
    public String toString() {
        return "CovidItems{" +
                "country='" + country + '\'' +
                ", population=" + population +
                ", cases=" + cases +
                ", rate=" + rate +
                '}';
    }
}
