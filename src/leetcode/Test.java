package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author qingtong
 * @since 2023-08-11 00:05
 **/
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });
        System.out.println(list);
    }

}
