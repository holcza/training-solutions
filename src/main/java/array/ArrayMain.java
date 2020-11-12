package array;

public class ArrayMain {
    public static void main(String[] args) {
        String [] week = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int [] numbers=new int[5];
        for (int i=0;i<numbers.length;i++){
            numbers[i]=2^i;
        }
        for (int number:numbers){
            System.out.println(number);
        }

        boolean[] booleans=new boolean[6];

        for (int i =0;i<booleans.length;i++){
            if (i%2==0){
                booleans[i]=false;
            }else {
                booleans[i]=true;
            }

        }

        for (boolean bool: booleans){
            System.out.println(bool);
        }


    }
}
