package solutions.stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix ="Hello";
        String name ="John Doe";
        String message=prefix+name;
        message =message+444;
        boolean b = message.equals("HelloJohn Doe");
        boolean c = message.equals("HelloJohn Doe444");
        System.out.println(b);
        System.out.println(c);
        String empty = ""+"";
        System.out.println(empty);
        System.out.println(empty.length());
        String Abcde = "Abcde";
        System.out.println(Abcde.length());
        System.out.println(Abcde.substring(0,1)+"-"+Abcde.substring(2,3));
        System.out.println(Abcde.substring(0,3));

    }
}
