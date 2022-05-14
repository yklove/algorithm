package cn.yklove.leetcode.contest.weekly285;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
            char[] chars = s.toCharArray();
            Info[] infos = new Info[chars.length];
            for (int i = 0; i < infos.length; i++) {
                infos[i] = new Info(1, null);
            }
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    merge(infos[i], infos[i - 1]);
                }
            }
            char[] toCharArray = queryCharacters.toCharArray();
            int[] ans = new int[queryIndices.length];
            for (int i = 0; i < queryIndices.length; i++) {
                int index = queryIndices[i];
                if (chars[index] == toCharArray[i]) {
                    ans[i] = getMax(infos);
                    continue;
                }
                chars[index] = toCharArray[i];
                // todo 左右减一

                infos[index] = new Info(1, null);
                if (index != 0 && chars[index] == chars[index - 1]) {
                    merge(infos[index - 1], infos[index]);
                }
                if (index != chars.length - 1 && chars[index] == chars[index + 1]) {
                    merge(infos[index + 1], infos[index]);
                }
                ans[i] = getMax(infos);
            }
            return ans;
        }

        private int getMax(Info[] infos) {
            int max = 0;
            for (Info info : infos) {
                max = Math.max(info.getCount(), max);
            }
            return max;
        }

        private void merge(Info x, Info y) {
            Info info = x.getInfo();
            info.count = info.getCount() + y.getCount();
            y.info = info;
        }

        class Info {
            int count;
            Info info;

            public Info getInfo() {
                if (this.info == null) {
                    return this;
                }
                return this.info.getInfo();
            }

            public Info(int count, Info info) {
                this.count = count;
                this.info = info;
            }

            public int getCount() {
                if (this.info == null) {
                    return count;
                } else {
                    return this.info.getCount();
                }
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        int[] ints = solution.longestRepeating("babacc", "bcb", new int[]{1, 3, 3});
        Assert.assertArrayEquals(new int[]{3, 3, 4}, ints);
    }

    @Test
    public void test2() {
        int[] ints = solution.longestRepeating("mm", "bfviuwsr", new int[]{0, 0, 1, 0, 0, 1, 1, 0});
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1}, ints);
    }

}
