package cn.yklove.leetcode.contest.weekly221;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int ans = 0;
            for (int i = 0; i < apples.length; i++) {
                treeMap.put(i + days[i] - 1, treeMap.getOrDefault(i + days[i] - 1, 0) + apples[i]);
                while (treeMap.size() != 0) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.firstEntry();
                    if (integerIntegerEntry.getValue() > 0) {
                        ans++;
                        treeMap.put(integerIntegerEntry.getKey(), integerIntegerEntry.getValue() - 1);
                        break;
                    } else {
                        treeMap.remove(integerIntegerEntry.getKey());
                    }
                }
                treeMap.remove(i);
            }
            for (int i = apples.length; treeMap.size() != 0; i++) {
                while (treeMap.size() != 0) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.firstEntry();
                    if (integerIntegerEntry.getValue() > 0) {
                        ans++;
                        treeMap.put(integerIntegerEntry.getKey(), integerIntegerEntry.getValue() - 1);
                        break;
                    } else {
                        treeMap.remove(integerIntegerEntry.getKey());
                    }
                }
                treeMap.remove(i);
            }
            return ans;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(7, solution.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(31, solution.eatenApples(new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5},
                new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7}));
    }

}
