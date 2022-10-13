import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Collections {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");

        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> listIterator=list.listIterator();
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
//        System.out.println(list);

    }
}
