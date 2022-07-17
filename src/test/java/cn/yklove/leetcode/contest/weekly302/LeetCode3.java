package cn.yklove.leetcode.contest.weekly302;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                ans[i] = process(nums, query);
            }
            return ans;
        }

        private int process(String[] nums, int[] query) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(new Node(new BigInteger(nums[i].substring(nums[i].length() - query[1])), i));
            }
            list.sort((o1, o2) -> {
                int i = o1.value.compareTo(o2.value);
                if (i == 0) {
                    return o1.index.compareTo(o2.index);
                }
                return i;
            });

            return list.get(query[0] - 1).index;
        }

        class Node {
            BigInteger value;
            Integer index;

            public Node(BigInteger value, Integer index) {
                this.value = value;
                this.index = index;
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"},
                new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}});
    }

    @Test
    public void test2() {
        solution.smallestTrimmedNumbers(new String[]{"24", "37", "96", "04"},
                new int[][]{{2, 1}, {2, 2}});
    }
    @Test
    public void test3() {
        solution.smallestTrimmedNumbers(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"},
                new int[][]{{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},{13,1},{13,1},{6,1},{5,10}});
    }

}
