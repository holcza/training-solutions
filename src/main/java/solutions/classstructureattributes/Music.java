package solutions.classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Song song = new Song();
        System.out.println("Give me the band name playing your favorite song");
        song.band=scanner.nextLine();
        System.out.println("Give me the title of your favorite song");
        song.title =scanner.nextLine();
        System.out.println("Give me the length of your favorite song in minutes");
        song.length=scanner.nextInt();
        System.out.println(song.band+" - "+song.title+" ( "+song.length+" mp )");

    }
}
