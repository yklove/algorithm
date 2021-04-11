package cn.yklove.leetcode.contest.weekly236;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    class Solution {
        public int findTheWinner(int n, int k) {
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            Iterator<Integer> iterator = list.iterator();
            int count = 0;
            while (list.size() > 1) {
                if (!iterator.hasNext()) {
                    iterator = list.iterator();
                }
                iterator.next();
                count++;
                if (count == k) {
                    count = 0;
                    iterator.remove();
                }
            }
            return list.get(0);
        }
    }

}
