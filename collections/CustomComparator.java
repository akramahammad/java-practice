package collections;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        Integer l1=o1.length();
        Integer l2=o2.length();
        if(l1>l2) return 1;
        else if(l1<l2) return -1;
        return o1.compareTo(o2);
    }
}
