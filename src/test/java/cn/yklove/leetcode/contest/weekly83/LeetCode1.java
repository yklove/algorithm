package cn.yklove.leetcode.contest.weekly83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode1 {

    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * 
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * 
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 
     * 最终结果按照字典顺序输出。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/positions-of-large-groups
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param s
     * @return
     */
    class Solution {

        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ans = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return ans;
            }
            char[] chars = s.toCharArray();
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    count++;
                } else {
                    if (count >= 3) {
                        ans.add(Arrays.asList(i - count, i - 1));
                    }
                    count = 1;
                }
            }
            if (count >= 3) {
                ans.add(Arrays.asList(chars.length - count, chars.length - 1));
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        List<List<Integer>> largeGroupPositions = solution.largeGroupPositions("abbxxxxzzy");
        Assert.assertEquals(1, largeGroupPositions.size());
        List<Integer> list = largeGroupPositions.get(0);
        Assert.assertEquals(2, list.size());
        Assert.assertTrue(3 == list.get(0));
        Assert.assertTrue(6 == list.get(1));
    }

}