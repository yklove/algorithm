package cn.yklove.meituan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        System.out.println(list.size());
        list.add(0, 3);
        System.out.println(list.size());
        System.out.println(list);
    }

}
