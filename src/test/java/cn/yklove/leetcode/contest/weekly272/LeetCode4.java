package cn.yklove.leetcode.contest.weekly272;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int kIncreasing(int[] arr, int k) {
            int ans = 0;
            List<Integer>[] lists = new List[k];
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < arr.length; i++) {
                lists[i % k].add(arr[i]);
            }
            for (int i = 0; i < lists.length; i++) {
                List<Integer> list = lists[i];
                int[] tmp = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    tmp[j] = list.get(j);
                }
                ans += (tmp.length - lengthOfLIS(tmp));
            }
            return ans;
        }

        public int lengthOfLIS(int[] nums) {
            int len = 1, n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; ++i) {
                if (nums[i] >= d[len]) {
                    d[++len] = nums[i];
                } else {
                    int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] <= nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    d[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test2() {
        Assert.assertEquals(4, solution.kIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
    }

    @Test
    public void test() {
        Assert.assertEquals(12, solution.kIncreasing(new int[]{12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3}, 1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, solution.kIncreasing(new int[]{2, 2, 2, 2, 2, 1, 1, 4, 4, 3, 3, 3, 3, 3}, 1));
    }


}
