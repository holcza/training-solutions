package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path path){
        List<Band> bandsAll = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String[] band= line.split(";");
                bandsAll.add(new Band(band[0],Integer.parseInt(band[1])));
            }
        }catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
        bands = bandsAll;

    }


    private List<Band> filterBands( int year) {
        List<Band> filteredBands = new ArrayList<>();
        for (Band b: bands){
            if (b.getYear()>=year){
                filteredBands.add(b);
            }
        }

        return filteredBands;
    }

    public void writeBandsBefore(Path path, int year){
        List<Band> filteredBands = filterBands(year);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)){
            for (Band f:filteredBands){
                bufferedWriter.write(f.getName()+","+f.getYear());
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Can not write file");
        }
    }
}
