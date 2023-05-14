package cn.yklove.leetcode.contest.weekly306;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public String smallestNumber(String pattern) {
            List<Integer> process = process(pattern.toCharArray(), 0, new ArrayList<>());
            String collect = process.stream().map(Object::toString).collect(Collectors.joining());
            return collect;
        }

        private List<Integer> process(char[] pattern, int index, List<Integer> list) {
            if (index == pattern.length + 1) {
                return list;
            }
            if (index == 0) {
                for (int i = 1; i <= 9; i++) {
                    list.add(i);
                    List<Integer> process = process(pattern, index + 1, list);
                    if (Objects.nonNull(process)) {
                        return process;
                    }
                }
            }
            if (pattern[index - 1] == 'I') {
                for (int i = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1; i <= 9; i++) {
                    if (list.contains(i)) {
                        continue;
                    }
                    list.add(i);
                    List<Integer> process = process(pattern, index + 1, list);
                    if (Objects.nonNull(process)) {
                        return process;
                    }
                }
            }
            if (pattern[index - 1] == 'D') {
                for (int i = 1; i <= (list.size() == 0 ? 9 : list.get(list.size() - 1) - 1); i++) {
                    if (list.contains(i)) {
                        continue;
                    }
                    list.add(i);
                    List<Integer> process = process(pattern, index + 1, list);
                    if (Objects.nonNull(process)) {
                        return process;
                    }
                }
            }
            list.remove(list.size() - 1);
            return null;
        }

    }

    Solution solution = new Solution();

    @Test
    public void test() {
        String iiididdd = solution.smallestNumber("IIIDIDDD");
        Assert.assertEquals("123549876", iiididdd);
    }

}
