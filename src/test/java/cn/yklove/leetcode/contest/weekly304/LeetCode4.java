package cn.yklove.leetcode.contest.weekly304;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int longestCycle(int[] edges) {
            Map<Integer,Long> tm = new HashMap<>();
            int ans = -1;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < edges.length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, 0);
                int tmpAns;
                int index = i;
                int count = 0;
                while (true) {
                    if(set.contains(index)){
                        tmpAns = -1;
                        break;
                    }
                    set.add(index);
                    if (edges[index] == -1) {
                        tmpAns = -1;
                        break;
                    }
                    if (map.containsKey(edges[index])) {
                        tmpAns = count + 1 - map.get(edges[index]);
                        break;
                    }
                    map.put(edges[index], count + 1);
                    index = edges[index];
                    count = count + 1;
                }
                ans = Math.max(tmpAns, ans);
            }
            return ans;
        }


    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.longestCycle(new int[]{2, -1, 3, 1}), -1);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/test/java/cn/yklove/leetcode/contest/weekly304/LeetCode4-test3.txt"));
        String s = in.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split(",");
        System.out.println(split.length);
        int[] tmp = new int[split.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = Integer.parseInt(split[i]);
        }
        long l = System.currentTimeMillis();
        Assert.assertEquals(solution.longestCycle(tmp), 43242);
        System.out.println(System.currentTimeMillis() - l);
    }
}
