package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    List<Country> countryList = new ArrayList<>();

    public CountryStatistics(String path) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(path),StandardCharsets.UTF_8)){
            String line ="";
            while ((line = br.readLine()) != null){
                countryList.add(createCountry(line));
            }
        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public Country createCountry (String s){
        Scanner scanner = new Scanner(s);
        String name = scanner.next();
        int numberOfPopulation = scanner.nextInt();
        int numberOfColorInFlag = scanner.nextInt();
        int numberOfNeighbours = scanner.nextInt();
        return new Country(name,numberOfPopulation,numberOfColorInFlag,numberOfNeighbours);
    }

    public Country maxPopulation(){

        Country maxPopulationCountry = countryList.get(0);
        for (int i = 0; i<countryList.size();i++){
            if (maxPopulationCountry.getNumberOfPopulation()<countryList.get(i).getNumberOfPopulation()){
                maxPopulationCountry = countryList.get(i);
            }
        }
        return maxPopulationCountry;
    }

    public static void main(String[] args) {
        CountryStatistics countryStatistics = new CountryStatistics("countries.txt");
        System.out.println(countryStatistics.getCountryList());
        System.out.println(countryStatistics.maxPopulation());
    }
}
