package cn.yklove.leetcode.contest.weekly317;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            if (sum(n) <= target) {
                return 0;
            }
            int index = 0;
            long tmp = n;
            while (true) {
                int x = getIndex(tmp, index);
                if (x == 0) {
                    index++;
                    continue;
                }
                tmp -= pow(x, index);
                tmp += pow(1, index + 1);
                if (sum(tmp) <= target) {
                    return tmp - n;
                }
            }
        }

        private long pow(int x, int i) {
            long tmp = x;
            for (int j = 0; j < i; j++) {
                tmp *= 10;
            }
            return tmp;
        }


        private int getIndex(long n, int index) {
            while (index > 0) {
                n = n / 10;
                index--;
            }
            return (int) (n % 10);
        }

        private int sum(long n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n = n / 10;
            }
            return sum;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.makeIntegerBeautiful(16, 6));
    }
}
