package cn.yklove.leetcode.contest.test1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {

        public int paintingPlan(int n, int k) {
            int count = 0;
            boolean key = true;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i * n + j * n - i * j == k) {
                        if (i == n || j == n) {
                            if (key) {
                                key = false;
                                count += 1;
                            }
                            continue;
                        }
                        count += (C(n, i) * C(n, j));
                    }
                }
            }
            return count;
        }

        public int A(int first, int second) {
            int tmp = first;
            int result = first;
            int count = 0;
            while (count < second - 1) {
                count++;
                tmp--;
                result = result * tmp;
            }
            return result;
        }

        public int factorialA(int number) {
            return A(number, number);
        }

        public double C(int n, int r) {
            int i = factorialA(n - r) * factorialA(r);
            if (i == 0) {
                return 1;
            }
            return factorialA(n) / i;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.paintingPlan(2, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, solution.paintingPlan(2, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, solution.paintingPlan(2, 4));
    }

}
