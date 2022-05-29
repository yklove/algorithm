package cn.yklove.leetcode.contest.weekly294;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {

        class Info {
            int x;
            int y;

            public Info(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int minimumLines(int[][] stockPrices) {
            if (stockPrices.length == 0) {
                return 0;
            }
            if (stockPrices.length == 1) {
                return 0;
            }
            if (stockPrices.length == 2) {
                return 1;
            }
            List<Info> list = new ArrayList<>();
            for (int[] stockPrice : stockPrices) {
                list.add(new Info(stockPrice[0], stockPrice[1]));
            }
            list.sort(Comparator.comparingInt(o -> o.x));
            int count = 1;
            for (int i = 2; i < list.size(); i++) {
                int x1 = list.get(i - 2).x;
                int y1 = list.get(i - 2).y;
                int x2 = list.get(i - 1).x;
                int y2 = list.get(i - 1).y;
                int x3 = list.get(i).x;
                int y3 = list.get(i).y;
                if ((y3 - y1) * (x2 - x1) - (y2 - y1) * (x3 - x1) == 0) {
                    // 在一条直线上
                } else {
                    count++;
                }
            }
            return count;
        }
    }

}
