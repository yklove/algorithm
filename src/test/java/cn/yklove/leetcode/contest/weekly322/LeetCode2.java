package cn.yklove.leetcode.contest.weekly322;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public long dividePlayers(int[] skill) {
            int allSum = 0;
            int[] map = new int[1001];
            for (int i : skill) {
                map[i]++;
                allSum += i;
            }
            // 每个队伍的sum
            int sum = allSum / (skill.length / 2);
            if(sum * (skill.length / 2) != allSum){
                return -1;
            }
            long ans = 0;
            for (int i : skill) {
                if (map[i] == 0) {
                    continue;
                }
                map[i]--;
                int tmp = sum - i;
                if (tmp <= 0) {
                    return -1;
                }
                if (map[tmp] == 0) {
                    return -1;
                }
                map[tmp]--;
                ans += (tmp * i);
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(-1, solution.dividePlayers(new int[]{5, 1, 1, 2, 1, 4}));
    }

}
