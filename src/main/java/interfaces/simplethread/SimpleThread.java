package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable{

    private List<String> tasks = new ArrayList<>();


    public SimpleThread(List<String> list) {
        this.tasks = list;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep(){
        if (tasks.size()==0){
            return false;
        } else {

            tasks.remove(tasks.size()-1);
        }
        if(tasks.size()==0){
            return false;
        } else{
            return true;
        }
    }


    @Override
    public void run() {
        while (nextStep()){

        }
    }
}
