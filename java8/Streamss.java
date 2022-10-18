package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streamss {
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> l2=l.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(l2);
        long count=l.stream().filter(i->i%2==0).count();
        System.out.println(count);

        List<String> l3= Arrays.asList("john","ram","jack");
        l3=l3.stream().map(Streamss::upperCase).collect(Collectors.toList());
        System.out.println(l3);

        Comparator<Integer> comp=(o1,o2)-> o2.compareTo(o1);
        l2=l2.stream().sorted(comp).collect(Collectors.toList());
        System.out.println(l2);

    }

    static String upperCase(String s){
        return s.toUpperCase();
    }


}
