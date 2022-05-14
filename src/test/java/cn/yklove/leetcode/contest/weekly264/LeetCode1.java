package cn.yklove.leetcode.contest.weekly264;

import com.sun.tools.javac.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author beamjl
 */
public class LeetCode1 {

    class Solution {
        public int countValidWords(String sentence) {
            String[] strings = sentence.split(" ");
            return (int) Arrays.stream(strings).filter(s -> {
                char[] chars = s.toCharArray();
                if(chars.length == 0){
                    return false;
                }
                int count = 0;
                for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
                    char aChar = chars[i];
                    if (!(aChar >= 'a' && aChar <= 'z' || aChar == '-' || aChar == '!' || aChar == '.' || aChar == ',')) {
                        return false;
                    }
                    if (aChar == '-') {
                        count++;
                        if(count > 1){
                            return false;
                        }
                        if (i == 0 || i == charsLength - 1 || !(chars[i-1] >= 'a' &&chars[i-1] <= 'z') || !(chars[i+1] >= 'a' &&chars[i+1] <= 'z')) {
                            return false;
                        }
                    }
                    if (aChar == '!' || aChar == '.' || aChar == ',') {
                        if (i != charsLength - 1) {
                            return false;
                        }
                        if (i>0 && !(chars[i - 1] >= 'a' && chars[i - 1] <= 'z')) {
                            return false;
                        }
                    }
                }
                return true;
            }).count();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test(){
        solution.countValidWords("a-b-c");
    }


}
