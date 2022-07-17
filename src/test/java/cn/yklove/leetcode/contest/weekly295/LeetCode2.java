package cn.yklove.leetcode.contest.weekly295;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public String discountPrices(String sentence, int discount) {
            double tmp = 1 - discount * 0.01;
            String[] chars = sentence.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : chars) {
                if (!s.startsWith("$")) {
                    stringBuilder.append(s).append(' ');
                    continue;
                }
                try {
                    long i = Long.parseLong(s.substring(1));
                    double ans = i * tmp;
                    String format = String.format("%1.2f", ans);
                    stringBuilder.append('$').append(format).append(' ');
                } catch (Exception e) {
                    stringBuilder.append(s).append(' ');
                }
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals("there are $0.50 $1.00 and 5$ candies in the shop", solution.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    }

    @Test
    public void test2() {
        Assert.assertEquals("706hzu76jjh7yufr5x9ot60v149k5 $5509377493.92 pw2o $4.32",
                solution.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6",
                        28));
    }

}
