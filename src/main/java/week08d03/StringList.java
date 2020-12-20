package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    public List<String> shortestWords(List<String> words){
        List<String> shortestWordsList = new ArrayList<>();
        int numberOfChar = shortestWordsNumber(words);
        for (String s: words){
            if (s.length()==numberOfChar){
                shortestWordsList.add(s);
            }
        }
        return shortestWordsList;
    }

    private int shortestWordsNumber(List<String> words) {
        int min = Integer.MAX_VALUE;
        for (String s: words){
            if (min>s.length()){
                min = s.length();
            }
        }
        return min;
    }

    public static void main(String[] args) {
        StringList stringList = new StringList();

        List<String> words = List.of("aaa","aa","bb","cccc","dd");
        System.out.println(stringList.shortestWords(words));
    }
}
