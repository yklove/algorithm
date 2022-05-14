package cn.yklove.leetcode.contest.weekly268;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public long kMirror(int k, int n) {
            long ans = 0;
            int count = 0;
            while (true) {
                for (int i = 1; i < 10; i++) {
                    long max = getMax(i);
                    for (int j = 1; j < max; j++) {
                        // 构造回文数
                        // 奇
                        Long oddNumberEnd = getOddNumberEnd(j);
                        if (String.valueOf(oddNumberEnd).equals(new StringBuilder(String.valueOf(oddNumberEnd)).reverse().toString())
                                && Long.toString(oddNumberEnd, k).equals(new StringBuilder(Long.toString(oddNumberEnd, k)).reverse().toString())
                        ) {
                            count++;
                            ans += oddNumberEnd;
                            if(count == n){
                                return ans;
                            }
                        }
                    }
                    for (int j = 1; j < max; j++) {
                        // 构造回文数
                        // 偶
                        Long oddNumberEnd = getEvenNumberEnd(j);
                        if (String.valueOf(oddNumberEnd).equals(new StringBuilder(String.valueOf(oddNumberEnd)).reverse().toString())
                                && Long.toString(oddNumberEnd, k).equals(new StringBuilder(Long.toString(oddNumberEnd, k)).reverse().toString())
                        ) {
                            count++;
                            ans += oddNumberEnd;
                            if(count == n){
                                return ans;
                            }
                        }
                    }
                }
            }
        }

        private long getMax(int digit) {
            long start = 1;
            for (int i = 0; i < digit; i++) {
                start *= 10;
            }
            return start;
        }

        private Long getOddNumberEnd(long num) {
            if (num < 10) {
                return num;
            }
            String s = String.valueOf(num);
            String substring = s.substring(1);
            return Long.parseLong(new StringBuilder(substring).reverse().toString() + substring);
        }

        private Long getEvenNumberEnd(long num) {
            String s = String.valueOf(num);
            return Long.parseLong(new StringBuilder(s).reverse().toString() + s);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(499, solution.kMirror(3, 7));
    }

}
