package solutions.list;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String > titles=new ArrayList<>();

    public void add(String title){
        titles.add(title);
    }

    public List<String > findAllByPrefix (String prefix){
        List<String> titlesWithPrefix = new ArrayList<>();
        for (int i=0;i<titles.size();i++){
            if (titles.get(i).indexOf(prefix)==0){
                titlesWithPrefix.add(titles.get(i));
            }
        }
        return titlesWithPrefix;
    }

    public List<String > getTitles(){
        return titles;
    }

    public void removeByPrefix (String prefix){
        List<String> titlesWithPrefix = new ArrayList<>();

        for (int i=0;i<titles.size();i++){
            if (titles.get(i).indexOf(prefix)==0){
                titlesWithPrefix.add(titles.get(i));
            }
        }

        titles.removeAll(titlesWithPrefix);
    }

    



    public static void main(String[] args) {
        Books books = new Books();

        books.add("Bevezetés a Java-ba");
        books.add("Bekeretezett képek");
        books.add("A város");
        books.add("Az titokzatos autó");

        books.titles=books.findAllByPrefix("Be");

        System.out.println(books.getTitles());

        books.removeByPrefix("Bev");
        System.out.println(books.getTitles());

    }

}
