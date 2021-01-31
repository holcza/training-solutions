package week13d04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Map;

public class TemplateEngine {

    public static final String STR = "{";
    public static final String STRCLOSE = "}";

    void merge(BufferedReader reader, Map<String, Object> toChange, BufferedWriter writer){
        try {
            String line = "";
            while ((line = reader.readLine())!= null){
                changeTemplateLine(line, toChange, writer);
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Can not read file",ioe);
        }
    }

    private void changeTemplateLine(String line, Map<String, Object> toChange, BufferedWriter writer) {
        int openIndex = line.indexOf(STR);
        while(openIndex>=0){
            int closeIndex = line.indexOf(STRCLOSE);
            String key = line.substring(openIndex+1,closeIndex);
            String value = toChange.get(key).toString();
            line = line.replace(STR+ key + STRCLOSE,value);
            openIndex = line.indexOf(STR);
        }
        System.out.println(line);
        writeTemplateLine(line, writer);
    }

    private void writeTemplateLine(String line, BufferedWriter writer) {

        try{
            writer.write(line +"\n");
        } catch (IOException ioe){
            throw new IllegalStateException("Can not write file");
        }
    }

    public static void main(String[] args) {
        TemplateEngine te = new TemplateEngine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("final_template.txt"));){

            Map<String , Object> map = Map.of("nev","XY","datum", LocalDate.now(),"osszeg",456,"hatarido",LocalDate.now());
            te.merge(Files.newBufferedReader(Path.of("template.txt")),map,bw);

        } catch (IOException ioe){
            throw new IllegalStateException("");
        }
    }
}
