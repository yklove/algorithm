package cn.yklove.leetcode.contest.weekly324;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int smallestValue(int n) {
            int process = process(n);
            while (process != n) {
                n = process;
                process = process(n);
            }
            return process;
        }

        private int process(int n) {
            int sum = 0;
            int k = 2;
            while (k <= n) {
                if (k == n) {
                    sum += n;
                    break;
                } else if (n % k == 0) {
                    sum += k;
                    n = n / k;
                } else {
                    k++;
                }
            }
            return sum;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.smallestValue(15),5);
    }

}
