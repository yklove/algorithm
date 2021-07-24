package cn.yklove.leetcode.contest.weekly246;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            String[] splitStart = startTime.split(":");
            int startHH = Integer.parseInt(splitStart[0]);
            int startMM = Integer.parseInt(splitStart[1]);
            if (startMM % 15 != 0) {
                startMM = startMM + (15 - startMM % 15);
            }
            String[] splitEnd = finishTime.split(":");
            int endHH = Integer.parseInt(splitEnd[0]);
            int endMM = Integer.parseInt(splitEnd[1]);
            int ans = 0;
            // 通宵了…
            if (startHH > endHH || (startHH == endHH && startMM > endMM)) {
                // 先算到0点的
                while (startHH != 24) {
                    ans += (60 - startMM) / 15;
                    startMM = 0;
                    startHH++;
                }
                startHH = 0;

            }
            // 没有通宵
            while (startHH < endHH) {
                // 补齐
                startMM = startMM + (startMM % 15);
                ans += (60 - startMM) / 15;
                startMM = 0;
                startHH++;
            }
            ans += ((endMM - startMM) / 15);
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.numberOfRounds("12:01", "12:44"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(40, solution.numberOfRounds("20:00", "06:00"));
    }

}
