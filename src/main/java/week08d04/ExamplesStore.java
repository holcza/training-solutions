package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {
    private final static String TITLES_MARKER = "#";
    private List<String> titles = new ArrayList<>();

    public List<String> getTitles() {
        return titles;
    }

    public void getTitlesOfExamples() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                ExamplesStore.class.getResourceAsStream("examples.md")
        ))) {

            String line;
            while ((line = reader.readLine()) != null) {
                addToTitles(line);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void addToTitles(String line) {

        if (line.startsWith(TITLES_MARKER)) {
            String newLine = line.replace(TITLES_MARKER, "");
            titles.add(newLine);
        }
    }

    public static void main(String[] args) {
        ExamplesStore examplesStore = new ExamplesStore();
        examplesStore.getTitlesOfExamples();
        System.out.println(examplesStore.getTitles());
    }
}
