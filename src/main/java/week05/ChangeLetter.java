package week05;

public class ChangeLetter {

    private final static String VOWELS = "aeiou";

    private final static String REPlACE ="*";

    public String changeVowels (String stg){
        StringBuilder stringBuilder =new StringBuilder();

        for (int i =0; i<stg.length();i++){
            String c=stg.substring(i,i+1);
            if (VOWELS.contains(c)){
                stringBuilder.append(REPlACE);
            } else{
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
