package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items = new ArrayList<>();

    private int cursor;

    public SimpleBag(){
       beforeFirst();
    }

    public void putItem(Object item){
        items.add(item);
    }

    public boolean isEmpty(){
        return items.size()==0 ? true : false;
    }

    public int size(){
        return items.size();
    }

    public void beforeFirst(){
        cursor = -1;
    }

    public boolean hasNext(){
        if (items.size()-1>cursor){
            return true;
        } else {
            return false;
        }
    }


    public Object next(){
        cursor++;
        return items.get(cursor);
    }


    public boolean contains(Object item){
        return items.contains(item);
    }


    public int getCursor(){
        return cursor;
    }
}
