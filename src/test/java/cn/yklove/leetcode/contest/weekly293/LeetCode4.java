package cn.yklove.leetcode.contest.weekly293;

import java.util.Objects;
import java.util.TreeMap;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class CountIntervals {

        TreeMap<Integer, Integer> leftTreeMap;
        int ans;

        public CountIntervals() {
            ans = 0;
            leftTreeMap = new TreeMap<>();
        }

        public void add(int left, int right) {
            Integer x = leftTreeMap.lowerKey(left);
            // 寻找左侧区间
            if (Objects.nonNull(x) && leftTreeMap.get(x) >= left) {
                if (leftTreeMap.get(x) >= right) {
                    return;
                } else {
                    ans += (right - leftTreeMap.get(x));
                    leftTreeMap.put(x, right);
                }
            }
            x = leftTreeMap.floorKey(right);
            if (Objects.nonNull(x) && x >= left) {
//                if(leftTreeMap.get(left) >)
            }

        }

        public int count() {
            return 0;
        }
    }

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */

}
