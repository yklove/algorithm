package cn.yklove.leetcode.contest.weekly274;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public int numberOfBeams(String[] bank) {
            int current = 0;
            int ans = 0;
            for (int i = 0; i < bank.length; i++) {
                String s = bank[i];
                char[] chars = s.toCharArray();
                int count = 0;
                for (char aChar : chars) {
                    if(aChar == '1'){
                        count++;
                    }
                }
                if(count > 0){
                    ans += (count * current);
                    current = count;
                }
            }
            return ans;
        }
    }

}
