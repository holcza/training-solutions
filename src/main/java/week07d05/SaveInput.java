package week07d05;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> read(){
        List<String > lines = new ArrayList<>();

        for (int i = 0;i<3;i++){
            System.out.println("The "+(i+1)+". line:");
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public Path readFileName(){

        System.out.println("The name of the file: ");
        String file = scanner.nextLine();

        Path path = Path.of(file);
        return path;
    }

    public void write (Path path, List<String> lines){
        try {
            Files.write(path,lines);
        }catch (IOException ioe){
            throw new IllegalStateException("File can not be written");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.read();
        Path path = saveInput.readFileName();
        saveInput.write(path,lines);
    }
}
