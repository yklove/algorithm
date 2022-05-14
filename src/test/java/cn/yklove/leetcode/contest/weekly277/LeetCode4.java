package cn.yklove.leetcode.contest.weekly277;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        int[][] statements;

        public int maximumGood(int[][] statements) {
            this.statements = statements;

            // 从头开始遍历
            for (int i = 0; i < statements.length; i++) {
                int[] ints = new int[statements.length];
                Arrays.fill(ints, -1);
                // 假设为真
                ints[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                extracted(statements, ints, queue, new HashSet<>());
            }


            return 0;
        }

        private boolean extracted(int[][] statements, int[] ints, Queue<Integer> queue, Set<Integer> set) {
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (set.contains(poll)) {
                    continue;
                }
                set.add(poll);
                // poll 是好人
                for (int j = 0; j < statements.length; j++) {
                    if (statements[poll][j] == 0) {
                        if (ints[j] == 1) {
                            // 矛盾了
                            return false;
                        }
                        ints[j] = 0;
                    } else if (statements[poll][j] == 1) {
                        if (ints[j] == 0) {
                            // 矛盾了
                            return false;
                        }
                        ints[j] = 1;
                        queue.add(j);
                    }
                }
            }
            return true;
        }


    }
}
