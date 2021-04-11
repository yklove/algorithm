package cn.yklove.leetcode.contest.weekly222;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {

        private long[] list = new long[]{1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L};

        public int countPairs(int[] deliciousness) {
            Map<Long, Integer> map = new HashMap<>();
            Set<Long> set = new HashSet<>();
            for (long i : deliciousness) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            long ans = 0;
            long ttt = 1000000000 + 7;
            for (Map.Entry<Long, Integer> integerIntegerEntry : map.entrySet()) {
                long value = integerIntegerEntry.getKey();
                Integer count = integerIntegerEntry.getValue();
                for (long l : list) {
                    if (map.containsKey(l - value) && !set.contains(l - value)) {
                        Integer tmpCount = map.get(l - value);
                        if (l - value == value) {
                            if (tmpCount == 1) {
                                // 什么都不做
                            } else {
                                ans += ((long) count * (count - 1)) / (2);
                                ans %= ttt;
                            }
                        } else {
                            ans += ((long) count * tmpCount);
                            ans %= ttt;
                        }
                    }
                }
                set.add(value);
            }
            return (int) (ans % ttt);
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.countPairs(new int[]{1, 3, 5, 7, 9}));
    }

}
