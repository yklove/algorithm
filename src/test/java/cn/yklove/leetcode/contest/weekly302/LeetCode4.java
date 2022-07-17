package cn.yklove.leetcode.contest.weekly302;

import org.junit.Test;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int minOperations(int[] nums, int[] numsDivide) {
            List<Integer> numsList = new ArrayList<>();
            Set<Integer> numsDivideList = new HashSet<>();
            for (int num : nums) {
                numsList.add(num);
            }
            for (int num : numsDivide) {
                numsDivideList.add(num);
            }
            numsList.sort(Integer::compareTo);
            for (int i = 0; i < numsList.size(); i++) {
                Integer integer = numsList.get(i);
                boolean key = true;
                for (Integer integer1 : numsDivideList) {
                    if (integer1 % integer != 0) {
                        key = false;
                        break;
                    }
                }
                if (key) {
                    return i;
                }
            }
            return -1;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.minOperations(new int[]{3, 2, 6, 2, 35, 5, 35, 2, 5, 8, 7, 3, 4},
                new int[]{105, 70, 70, 175, 105, 105, 105});
    }

}
