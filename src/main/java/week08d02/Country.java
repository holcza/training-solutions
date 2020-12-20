package week08d02;

public class Country {
    private String name;
    private int numberOfPopulation;
    private int numberOfColorsInFlag;
    private int numberOfNeighbours;

    public Country(String name, int numberOfPopulation, int numberOfColorsInFlag, int numberOfNeighbours) {
        this.name = name;
        this.numberOfPopulation = numberOfPopulation;
        this.numberOfColorsInFlag = numberOfColorsInFlag;
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPopulation() {
        return numberOfPopulation;
    }

    public int getNumberOfColorsInFlag() {
        return numberOfColorsInFlag;
    }

    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", numberOfPopulation=" + numberOfPopulation +
                ", numberOfColorsInFlag=" + numberOfColorsInFlag +
                ", numberOfNeighbours=" + numberOfNeighbours +
                '}';
    }
}
