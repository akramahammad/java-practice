package collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> listIterator=list.listIterator();
        while(listIterator.hasPrevious()){
//            System.out.print(listIterator.previous()+ " " );
        }

        Set<Integer> set=new TreeSet<>();
        set.add(5);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println(set);

        Map<String,Integer> map=new LinkedHashMap<>();
        map.put("1",1);
        map.put("3",3);
        map.put("2",2);
        map.put("5",5);

        System.out.println(map);

        Set<String> set1=new TreeSet<String>(new CustomComparator());
        set1.add("hello");
        set1.add("abc");
        set1.add("cd");
        set1.add("hensdfaef");

//        for(String s:set1){
//            System.out.println(s);
//        }
        System.out.println(genericMethod("1"));
    }

    public static <T> T genericMethod(T arg){
        return arg;
    }
}
