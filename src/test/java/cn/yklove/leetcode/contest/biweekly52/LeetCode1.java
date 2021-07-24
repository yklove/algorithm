package cn.yklove.leetcode.contest.biweekly52;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class Solution {
        public String sortSentence(String s) {
            return Stream.of(s.split(" "))
                    .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.substring(o.length() - 1))))
                    .map(tmp -> tmp.substring(0, tmp.length() - 1))
                    .collect(Collectors.joining(" "));
        }
    }

}
