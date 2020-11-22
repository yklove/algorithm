package cn.yklove.leetcode.contest.weekly215;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    class OrderedStream {

        String[] strings;
        int start;

        public OrderedStream(int n) {
            strings = new String[n];
        }

        public List<String> insert(int id, String value) {
            strings[id - 1] = value;
            int i = start;
            for (; i < strings.length; i++) {
                if (strings[i] == null) {
                    break;
                }
            }
            List<String> list = Arrays.asList(Arrays.copyOfRange(strings, start, i));
            start = i;
            return list;
        }
    }

    @Test
    public void test() {

    }
}
