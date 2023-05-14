package cn.yklove.leetcode.contest.weekly324;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int similarPairs(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                char[] chars = word.toCharArray();
                List<Character> list = new ArrayList<>();
                for (char aChar : chars) {
                    list.add(aChar);
                }
                String t = list.stream().distinct().sorted().map(Objects::toString).collect(Collectors.joining());
                words[i] = t;
            }
            int ans = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if(words[i].equals(words[j])){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
