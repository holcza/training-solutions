package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoReader {
    private Integer[] numberOfNumbers = new Integer[90];

    public LottoReader(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line=br.readLine())!=null){
                Integer[] numbers = new Integer[5];
                numbers = readNumbers(line);
                addToNumberOfNumbers(numbers);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private Integer[] readNumbers (String s){
        Integer[] numbers = new Integer[5];
        String[] sList;
        sList=s.split(";");

        for(int i = 11;i<16;i++){
            numbers[i-11]=Integer.parseInt(sList[i]);
        }

        return numbers;

    }

    private void addToNumberOfNumbers(Integer[] numbers){
        for(int n:numbers){
            numberOfNumbers[n-1]++;
        }
    }

    public int getNumber(int index){
        return numberOfNumbers[index];
    }
}
