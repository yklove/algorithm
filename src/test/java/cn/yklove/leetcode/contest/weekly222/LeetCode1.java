package cn.yklove.leetcode.contest.weekly222;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            List<Info> list = new ArrayList<>();
            for (int[] boxType : boxTypes) {
                list.add(new Info(boxType[0], boxType[1]));
            }
            list.sort((o1, o2) -> Integer.compare(o2.size, o1.size));
            int count = 0;
            int ans = 0;
            for (Info info : list) {
                if (count < truckSize) {
                    int max = Math.min(info.count, truckSize - count);
                    ans += max * info.size;
                    count += max;
                } else {
                    break;
                }
            }
            return ans;
        }

        class Info {
            int count;
            int size;

            public Info(int count, int size) {
                this.count = count;
                this.size = size;
            }
        }
    }
}
