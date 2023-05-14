package cn.yklove.leetcode.contest.weekly324;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public boolean isPossible(int n, List<List<Integer>> edges) {
            List<Integer>[] maps = build(n, edges);
            int count = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < maps.length; i++) {
                if (maps[i].size() % 2 != 0) {
                    count++;
                    tmp.add(i);
                    if (count > 4) {
                        return false;
                    }
                }
            }
            if (count == 2) {
                if (maps[tmp.get(0)].contains(tmp.get(1))) {
                    if (n <= 2) {
                        return false;
                    }
                    for (int i = 0; i < maps.length; i++) {
                        if (i == tmp.get(0) || i == tmp.get(1)) {
                            continue;
                        }
                        if (!maps[i].contains(tmp.get(0)) && !maps[i].contains(tmp.get(1))) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            for (Integer integer : tmp) {
                if (maps[integer].size() == n - 1) {
                    return false;
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < tmp.size(); i++) {
                if (set.contains(i)) {
                    continue;
                }
                set.add(i);
                boolean key = false;
                for (int j = i + 1; j < tmp.size(); j++) {
                    if (set.contains(j)) {
                        continue;
                    }
                    if (!maps[tmp.get(i)].contains(tmp.get(j))) {
                        key = true;
                        set.add(j);
                        break;
                    }
                }
                if (!key) {
                    return false;
                }
            }
            return true;
        }

        private List<Integer>[] build(int numCourses, List<List<Integer>> prerequisites) {
            List<Integer>[] lists = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                lists[i] = new ArrayList<>();
            }
            for (List<Integer> prerequisite : prerequisites) {
                lists[prerequisite.get(0) - 1].add(prerequisite.get(1) - 1);
                lists[prerequisite.get(1) - 1].add(prerequisite.get(0) - 1);
            }
            return lists;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        boolean possible = solution.isPossible(5, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2),
                Arrays.asList(1, 4),
                Arrays.asList(2, 5)
        ));
        Assert.assertTrue(possible);
    }

    @Test
    public void test2() {
        boolean possible = solution.isPossible(11, Arrays.asList(
                Arrays.asList(5, 9),
                Arrays.asList(8, 1),
                Arrays.asList(2, 3),
                Arrays.asList(7, 10),
                Arrays.asList(3, 6),
                Arrays.asList(6, 7),
                Arrays.asList(7, 8),
                Arrays.asList(5, 1),
                Arrays.asList(5, 7),
                Arrays.asList(10, 11),
                Arrays.asList(3, 7),
                Arrays.asList(6, 11),
                Arrays.asList(8, 11),
                Arrays.asList(3, 4),
                Arrays.asList(8, 9),
                Arrays.asList(9, 1),
                Arrays.asList(2, 10),
                Arrays.asList(9, 11),
                Arrays.asList(5, 11),
                Arrays.asList(2, 5),
                Arrays.asList(8, 10),
                Arrays.asList(2, 7),
                Arrays.asList(4, 1),
                Arrays.asList(3, 10),
                Arrays.asList(6, 1),
                Arrays.asList(4, 9),
                Arrays.asList(4, 6),
                Arrays.asList(4, 5),
                Arrays.asList(2, 4),
                Arrays.asList(2, 11),
                Arrays.asList(5, 8),
                Arrays.asList(6, 9),
                Arrays.asList(4, 10),
                Arrays.asList(3, 11),
                Arrays.asList(4, 7),
                Arrays.asList(3, 5),
                Arrays.asList(7, 1),
                Arrays.asList(2, 9),
                Arrays.asList(6, 10),
                Arrays.asList(10, 1),
                Arrays.asList(5, 6),
                Arrays.asList(3, 9),
                Arrays.asList(2, 6),
                Arrays.asList(7, 9),
                Arrays.asList(4, 11),
                Arrays.asList(4, 8),
                Arrays.asList(6, 8),
                Arrays.asList(3, 8),
                Arrays.asList(9, 10),
                Arrays.asList(5, 10),
                Arrays.asList(2, 8),
                Arrays.asList(7, 11)
        ));
        Assert.assertFalse(possible);
    }

    @Test
    public void test3() {
        boolean possible = solution.isPossible(21, Arrays.asList(
                Arrays.asList(2, 19),
                Arrays.asList(16, 17),
                Arrays.asList(8, 14),
                Arrays.asList(2, 16),
                Arrays.asList(12, 20),
                Arrays.asList(12, 14),
                Arrays.asList(16, 18),
                Arrays.asList(15, 16),
                Arrays.asList(10, 21),
                Arrays.asList(3, 5),
                Arrays.asList(13, 18),
                Arrays.asList(17, 20),
                Arrays.asList(14, 17),
                Arrays.asList(9, 12),
                Arrays.asList(5, 15),
                Arrays.asList(5, 6),
                Arrays.asList(3, 7),
                Arrays.asList(2, 21),
                Arrays.asList(10, 13),
                Arrays.asList(8, 16),
                Arrays.asList(7, 18),
                Arrays.asList(4, 6),
                Arrays.asList(9, 1),
                Arrays.asList(13, 21),
                Arrays.asList(18, 20),
                Arrays.asList(7, 14),
                Arrays.asList(4, 19),
                Arrays.asList(5, 8),
                Arrays.asList(3, 11),
                Arrays.asList(11, 1),
                Arrays.asList(7, 12),
                Arrays.asList(4, 7),
                Arrays.asList(3, 16),
                Arrays.asList(13, 17),
                Arrays.asList(17, 19),
                Arrays.asList(9, 13),
                Arrays.asList(7, 19),
                Arrays.asList(10, 16),
                Arrays.asList(4, 13),
                Arrays.asList(4, 5),
                Arrays.asList(2, 15),
                Arrays.asList(12, 19),
                Arrays.asList(11, 16),
                Arrays.asList(2, 9),
                Arrays.asList(11, 17),
                Arrays.asList(17, 1),
                Arrays.asList(16, 21),
                Arrays.asList(4, 10),
                Arrays.asList(10, 14),
                Arrays.asList(14, 16),
                Arrays.asList(4, 1),
                Arrays.asList(13, 20),
                Arrays.asList(5, 20),
                Arrays.asList(4, 14),
                Arrays.asList(4, 21),
                Arrays.asList(10, 20),
                Arrays.asList(2, 14),
                Arrays.asList(8, 15),
                Arrays.asList(4, 8),
                Arrays.asList(6, 19),
                Arrays.asList(15, 1),
                Arrays.asList(19, 1),
                Arrays.asList(8, 19),
                Arrays.asList(15, 21),
                Arrays.asList(3, 12),
                Arrays.asList(11, 18),
                Arrays.asList(9, 17),
                Arrays.asList(18, 19),
                Arrays.asList(7, 21),
                Arrays.asList(3, 21),
                Arrays.asList(16, 19),
                Arrays.asList(11, 15),
                Arrays.asList(5, 1),
                Arrays.asList(8, 17),
                Arrays.asList(3, 15),
                Arrays.asList(8, 1),
                Arrays.asList(10, 19),
                Arrays.asList(3, 8),
                Arrays.asList(6, 16),
                Arrays.asList(2, 8),
                Arrays.asList(5, 18),
                Arrays.asList(11, 13),
                Arrays.asList(11, 20),
                Arrays.asList(14, 21),
                Arrays.asList(6, 20),
                Arrays.asList(4, 20),
                Arrays.asList(12, 13),
                Arrays.asList(5, 12),
                Arrays.asList(10, 11),
                Arrays.asList(9, 15),
                Arrays.asList(3, 19),
                Arrays.asList(9, 20),
                Arrays.asList(14, 18),
                Arrays.asList(21, 1),
                Arrays.asList(13, 19),
                Arrays.asList(8, 21),
                Arrays.asList(2, 13),
                Arrays.asList(3, 10),
                Arrays.asList(9, 18),
                Arrays.asList(19, 21),
                Arrays.asList(6, 7),
                Arrays.asList(3, 18),
                Arrays.asList(2, 18),
                Arrays.asList(6, 14),
                Arrays.asList(3, 17),
                Arrays.asList(5, 21),
                Arrays.asList(14, 20),
                Arrays.asList(8, 9),
                Arrays.asList(16, 1),
                Arrays.asList(3, 4),
                Arrays.asList(13, 1),
                Arrays.asList(5, 9),
                Arrays.asList(4, 15),
                Arrays.asList(17, 21),
                Arrays.asList(20, 21),
                Arrays.asList(2, 17),
                Arrays.asList(13, 14),
                Arrays.asList(11, 14),
                Arrays.asList(9, 16),
                Arrays.asList(10, 18),
                Arrays.asList(6, 15),
                Arrays.asList(6, 12),
                Arrays.asList(3, 13),
                Arrays.asList(5, 11),
                Arrays.asList(6, 1),
                Arrays.asList(12, 17),
                Arrays.asList(8, 10),
                Arrays.asList(5, 10),
                Arrays.asList(8, 18),
                Arrays.asList(4, 12),
                Arrays.asList(10, 1),
                Arrays.asList(6, 13),
                Arrays.asList(4, 18),
                Arrays.asList(7, 20),
                Arrays.asList(7, 16),
                Arrays.asList(2, 6),
                Arrays.asList(12, 21),
                Arrays.asList(4, 17),
                Arrays.asList(15, 18),
                Arrays.asList(13, 16),
                Arrays.asList(15, 20),
                Arrays.asList(7, 10),
                Arrays.asList(6, 10),
                Arrays.asList(2, 20),
                Arrays.asList(7, 15),
                Arrays.asList(18, 1),
                Arrays.asList(12, 1),
                Arrays.asList(3, 20),
                Arrays.asList(7, 1),
                Arrays.asList(14, 15),
                Arrays.asList(4, 9),
                Arrays.asList(11, 19),
                Arrays.asList(7, 9),
                Arrays.asList(5, 17),
                Arrays.asList(18, 21),
                Arrays.asList(6, 21),
                Arrays.asList(8, 11),
                Arrays.asList(6, 17),
                Arrays.asList(3, 14),
                Arrays.asList(7, 11),
                Arrays.asList(5, 7),
                Arrays.asList(7, 13),
                Arrays.asList(6, 8),
                Arrays.asList(6, 9),
                Arrays.asList(10, 12),
                Arrays.asList(5, 16),
                Arrays.asList(2, 4),
                Arrays.asList(17, 18),
                Arrays.asList(9, 11),
                Arrays.asList(12, 16),
                Arrays.asList(3, 6),
                Arrays.asList(12, 18),
                Arrays.asList(3, 9),
                Arrays.asList(11, 12),
                Arrays.asList(14, 19),
                Arrays.asList(10, 15),
                Arrays.asList(5, 13),
                Arrays.asList(8, 13),
                Arrays.asList(15, 17),
                Arrays.asList(2, 10),
                Arrays.asList(11, 21),
                Arrays.asList(20, 1),
                Arrays.asList(6, 18),
                Arrays.asList(2, 12),
                Arrays.asList(19, 20),
                Arrays.asList(6, 11),
                Arrays.asList(8, 12),
                Arrays.asList(2, 3),
                Arrays.asList(12, 15),
                Arrays.asList(2, 11),
                Arrays.asList(9, 10),
                Arrays.asList(7, 17),
                Arrays.asList(9, 19),
                Arrays.asList(13, 15),
                Arrays.asList(7, 8),
                Arrays.asList(4, 11),
                Arrays.asList(2, 5),
                Arrays.asList(5, 19),
                Arrays.asList(16, 20),
                Arrays.asList(15, 19),
                Arrays.asList(9, 14),
                Arrays.asList(14, 1),
                Arrays.asList(10, 17),
                Arrays.asList(9, 21),
                Arrays.asList(2, 7),
                Arrays.asList(8, 20),
                Arrays.asList(5, 14),
                Arrays.asList(4, 16)
        ));
        Assert.assertTrue(possible);
    }
}
