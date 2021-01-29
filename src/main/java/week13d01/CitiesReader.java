package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitiesReader {
    private List<City> cityList = new ArrayList<>();

    public void findFirstCityFromFile (InputStream is) throws IOException{

        readFromFile(is);
        cityList.sort(new NameCompare());

        if (cityList ==null){
            throw new IllegalArgumentException("There is no city");
        }
        System.out.println(cityList.get(0));
    }

    private void readFromFile (InputStream is){
        cityList.clear();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            createCitiesFromFile(reader);

        } catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
    }

    private void createCitiesFromFile(BufferedReader reader) throws IOException {
        readFirstLineFromFile(reader);
        String line;
        while ((line= reader.readLine())!=null){
            String[] cityFromLine = line.split(";");
            cityList.add(new City(cityFromLine[0],cityFromLine[1]));
        }
    }

    private void readFirstLineFromFile (BufferedReader reader) throws IOException{
        reader.readLine();
    }

    public static void main(String[] args) throws IOException {
        CitiesReader cr = new CitiesReader();
        cr.findFirstCityFromFile(CitiesReader.class.getResourceAsStream("cities.csv"));
    }
}
