package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CovidAnalitics {
    private static String replaceCountryName(String s) {
        return s.replace("Bonaire, Saint", "Bonaire Saint");
    }

    public List<CovidItems> getCasesByCountry(BufferedReader reader) throws IOException {
        List<CovidItems> casesByCountry = reader.lines()
                .skip(1)
                .map(CovidAnalitics::replaceCountryName)
                .map(this::parse)
                .filter(this::invalidPopulation)
                .collect(Collectors.toMap(CovidItems::getCountry, Function.identity(),CovidItems::addCovidItems))
                .values()
                .stream()
                .sorted(Comparator.comparing(CovidItems::getRate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return casesByCountry;
    }

    private boolean invalidPopulation(CovidItems covidItems) {
        return covidItems.getPopulation() !=0;
    }

    private CovidItems parse(String s) {
        String [] parts = s.split(",");
        String country = parts[4];
        int population = parts[7].isBlank() ? 0 :Integer.parseInt(parts[7]);
        int cases = Integer.parseInt(parts[2]);
        return new CovidItems(country,population,cases);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("data.csv"))) {
            System.out.println(new CovidAnalitics().getCasesByCountry(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
