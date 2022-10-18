package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections implements Runnable{
    static List<Integer> list=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ConcurrentCollections()).start();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        ListIterator iterator=list.listIterator();
        while (iterator.hasNext()){
            Thread.sleep(1000);
            System.out.println(iterator.next());
        }
        System.out.println(list);

        //Similar concurrent collections - CopyOnWriteArraySet for set and ConcurrentHashMap for map
    }
    @Override
    public void run() {
        System.out.println("Inside thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(10);
    }
}
