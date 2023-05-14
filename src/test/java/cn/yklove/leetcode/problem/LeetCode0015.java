package cn.yklove.leetcode.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode0015 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            int i = 0;
            int x = i + 1;
            int y = nums.length - 1;
            while (i < nums.length - 2) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    i++;
                    if (i >= nums.length - 2) {
                        break;
                    }
                    x = i + 1;
                    continue;
                }
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    y = y - 1;
                    while (nums[y] == nums[y + 1]) {
                        y--;
                        if (y <= x) {
                            break;
                        }
                    }
                    x = x + 1;
                    while (nums[x] == nums[x - 1]) {
                        x++;
                        if (x >= y) {
                            break;
                        }
                    }
                    if (x >= y) {
                        i++;
                        x = i + 1;
                        y = nums.length - 1;
                        continue;
                    }
                    continue;
                } else if (sum > 0) {
                    y = y - 1;
                    while (nums[y] == nums[y + 1]) {
                        y--;
                        if (y <= x) {
                            break;
                        }
                    }
                    if (y <= x) {
                        i++;
                        x = i + 1;
                        y = nums.length - 1;
                        continue;
                    }
                } else {
                    x = x + 1;
                    while (nums[x] == nums[x - 1]) {
                        x++;
                        if (x >= y) {
                            break;
                        }
                    }
                    if (x >= y) {
                        i++;
                        x = i + 1;
                        y = nums.length - 1;
                        continue;
                    }
                }
            }
            return list;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}), Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void test2() {
        Assert.assertEquals(solution.threeSum(new int[]{0, 1, 1}),
                Arrays.asList());
    }

    @Test
    public void test3() {
        Assert.assertEquals(solution.threeSum(new int[]{0, 0, 0}),
                Arrays.asList(Arrays.asList(0, 0, 0)));
    }

    @Test
    public void test4() {
        Assert.assertEquals(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}),
                Arrays.asList());
    }

}
