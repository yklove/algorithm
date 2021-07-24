package cn.yklove.leetcode.contest.biweekly52;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int[] memLeak(int memory1, int memory2) {
            for (int i = 1; i < Integer.MAX_VALUE - 1; i++) {
                if (memory1 > 0 && memory2 > 0) {
                    if (memory1 >= memory2 && (memory1 - i) >= 0) {
                        memory1 -= i;
                    } else if (memory2 - i >= 0) {
                        memory2 -= i;
                    } else {
                        return new int[]{i, memory1, memory2};
                    }
                } else if (memory1 > 0) {
                    if (memory1 - i >= 0) {
                        memory1 -= i;
                    } else {
                        return new int[]{i, memory1, memory2};
                    }
                } else {
                    if (memory2 - i >= 0) {
                        memory2 -= i;
                    } else {
                        return new int[]{i, memory1, memory2};
                    }
                }
            }
            return new int[]{};
        }
    }

}
