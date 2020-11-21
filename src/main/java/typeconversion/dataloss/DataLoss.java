package typeconversion.dataloss;

public class DataLoss {
    public void dataLoss(){
        long i=0;
        int count=0;
        while(count<3){
            float j = i;
            long k= (long)j;
            if (i!=k){
                System.out.println(i);
                System.out.println(Long.toBinaryString(i));
                System.out.println(Long.toBinaryString(k));
                count++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();
        dataLoss.dataLoss();
    }
}
