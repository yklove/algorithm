package cn.yklove.leetcode.contest.weekly280;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int minimumOperations(int[] nums) {
            if (nums.length <= 1) {
                return 0;
            }
            Map<Integer, Integer> map1 = new HashMap<>();
            int count1 = 0;
            for (int i = 0; i < nums.length; i += 2) {
                count1++;
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            }
            int count2 = 0;
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int i = 1; i < nums.length; i += 2) {
                count2++;
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map1.entrySet());
            List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(map2.entrySet());
            list1.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
            list2.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

            List<Map.Entry<Integer, Integer>> list3 = new ArrayList<>();
            List<Map.Entry<Integer, Integer>> list4 = new ArrayList<>();
            long tmp = Long.MAX_VALUE;
            int count = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : list1) {
                if (integerIntegerEntry.getValue().equals(list1.get(0).getValue())) {
                    list3.add(integerIntegerEntry);
                } else {
                    if (count == 0) {
                        tmp = integerIntegerEntry.getValue();
                        count++;
                    }
                    if (integerIntegerEntry.getValue() == tmp) {
                        list3.add(integerIntegerEntry);
                    } else {
                        break;
                    }
                }
            }
            count = 0;
            tmp = Long.MAX_VALUE;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : list2) {
                if (integerIntegerEntry.getValue().equals(list2.get(0).getValue())) {
                    list4.add(integerIntegerEntry);
                } else {
                    if (count == 0) {
                        tmp = integerIntegerEntry.getValue();
                        count++;
                    }
                    if (integerIntegerEntry.getValue() == tmp) {
                        list4.add(integerIntegerEntry);
                    } else {
                        break;
                    }
                }
            }
            Integer count11 = getInteger(map1, count1, count2, map2, list3, list4);
            Integer count12 = getInteger(map1, count1, count2, map2, list4, list3);
            return Math.min(count11,count12);
        }

        private Integer getInteger(Map<Integer, Integer> map1, int count1, int count2, Map<Integer, Integer> map2, List<Map.Entry<Integer, Integer>> list3, List<Map.Entry<Integer, Integer>> list4) {
            for (Map.Entry<Integer, Integer> entry : list3) {
                for (Map.Entry<Integer, Integer> entry2 : list4) {
                    if (entry.getKey().equals(entry2.getKey())) {
                        if (map1.size() == 1 && map2.size() == 1) {
                            return Math.min(count1, count2);
                        }
                        continue;
                    }
                    return count1 - entry.getValue() + count2 - entry2.getValue();
                }
            }
            return Integer.MAX_VALUE;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.minimumOperations(new int[]{3, 1, 3, 2, 4, 3}), 3);

    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.minimumOperations(new int[]{1}), 0);
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.minimumOperations(new int[]{2, 2}), 1);
    }

    @Test
    public void test5() {
        Assert.assertEquals(solution.minimumOperations(new int[]{1,2,1,2,1,2,1,2}), 0);
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.minimumOperations(new int[]{1, 2, 2, 2, 2}), 2);
    }


}
