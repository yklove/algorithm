package cn.yklove.offer58;

import org.junit.Test;

import java.util.*;

/**
 * @author qinggeng
 */
public class Main1 {

    class Solution {
        public int[] removeDuplicate(int[] array) {
            Set<Integer> set = new HashSet<>();
            List<Integer> ans = new LinkedList<>();
            for (int i = array.length - 1; i >= 0; i--) {
                if (!set.contains(array[i])) {
                    set.add(array[i]);
                    ans.add(array[i]);
                }
            }
            int[] arr = new int[ans.size()];
            Iterator<Integer> iterator = ans.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                arr[arr.length - count++ - 1] = iterator.next();
            }
            return arr;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] ints = solution.removeDuplicate(new int[]{1, 1, 1, 2, 1});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }


}
