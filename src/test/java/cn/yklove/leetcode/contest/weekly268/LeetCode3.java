package cn.yklove.leetcode.contest.weekly268;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class RangeFreqQuery {

        private int[] arr;

        private Map<Integer, List<Integer>> map;

        public RangeFreqQuery(int[] arr) {
            this.arr = arr;
            this.map = new HashMap<>();
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) {
                List<Integer> count = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    int add = arr[i] == value ? 1 : 0;
                    if (i == 0) {
                        count.add(add);
                    } else {
                        count.add(count.get(i - 1) + add);
                    }
                }
                map.put(value, count);
            }
            List<Integer> list = map.get(value);
            if (left == 0) {
                return list.get(right);
            } else {
                return list.get(right) - list.get(left - 1);
            }
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
}
