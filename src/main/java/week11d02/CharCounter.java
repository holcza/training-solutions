package week11d02;

public class CharCounter {
    public int countChars(String[] chars){
        int result = 0;
        boolean check;
        for (char c: chars[0].toCharArray()){
            check = true;
            for (String s:chars){
                if (!s.contains(""+c)){
                    check = false;
                }
            }
            if (check){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String [] chars = new String[]{"abc", "cba", "ab"};
        CharCounter charCounter = new CharCounter();
        System.out.println(charCounter.countChars(chars));
    }
}
