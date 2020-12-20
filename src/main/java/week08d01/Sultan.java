package week08d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sultan {
    private boolean[] doorsOpen = new boolean[100];

    public Sultan() {
        for (boolean d:doorsOpen){
            d = false;
        }
    }

    public boolean[] getDoorsOpen() {
        return doorsOpen;
    }

    public void changeDoors (int number){
        for (int i =1;i<=doorsOpen.length;i++){
            if (i%number==0){
                if (doorsOpen[i-1]==false){
                    doorsOpen[i-1]=true;
                } else if (doorsOpen[i-1]==true){
                    doorsOpen[i-1]=false;
                }
            }
        }
    }

    public void changeDoorsMoreTimes (int numberOfTimes){
        for (int i=0;i<numberOfTimes;i++){
            changeDoors(i+1);
        }
    }

    public List<Integer> getDoorsOpenWithNumber (){
        List<Integer> openDoors = new ArrayList<>();
        for (int i =0;i<doorsOpen.length;i++){
            if (doorsOpen[i]==true){
                openDoors.add(i+1);
            }
        }
        return openDoors;
    }

    @Override
    public String toString() {
        return "Sultan{" +
                "doorsOpen=" + Arrays.toString(doorsOpen) +
                '}';
    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan();
        System.out.println(sultan.toString());
        sultan.changeDoors(2);
        System.out.println(sultan.toString());
        sultan.changeDoors(3);
        System.out.println(sultan.toString());

        Sultan sultan2 = new Sultan();
        sultan2.changeDoorsMoreTimes(3);
        System.out.println(sultan2.toString());

        Sultan sultan3 = new Sultan();
        sultan3.changeDoorsMoreTimes(100);
        System.out.println(sultan3.toString());
        System.out.println(sultan3.getDoorsOpenWithNumber());
    }
}
