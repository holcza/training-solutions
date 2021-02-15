package exam03;

import java.io.*;

public class Histogram {
    public String createHistogram(BufferedReader reader) throws IOException {
        String result = "";

        String line;
        while ((line = reader.readLine()) != null) {

            result = processLine(result, line);
        }


        return result;
    }

    private String processLine(String result, String line) {
        int numberOfStars = Integer.parseInt(line);
        for (int i = 0; i < numberOfStars; i++) {
            result += "*";
        }
        result += "\n";
        return result;
    }


}
