package cn.yklove.nowcoder.course2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

    class Soluion {

        /**
         * 给定一个数组arr，求差值为k的去重数字对。
         * 
         */
        public List<List<Integer>> differenceValue(int[] arr, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (Integer tmp : set) {
                if (set.contains(tmp + k)) {
                    ans.add(Arrays.asList(tmp, tmp + k));
                }
            }
            return ans;
        }

    }

}