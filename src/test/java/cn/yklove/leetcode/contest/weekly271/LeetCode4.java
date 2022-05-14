package cn.yklove.leetcode.contest.weekly271;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            return Math.max(rightMaxTotalFruits(fruits,startPos,k),leftMaxTotalFruits(fruits, startPos, k));
        }

        public int rightMaxTotalFruits(int[][] fruits, int startPos, int k) {
            int max = 0;
            Map<Integer, Integer> fruitsMap = new HashMap<>();
            for (int[] fruit : fruits) {
                fruitsMap.put(fruit[0], fruit[1]);
            }
            int tmpK = k;
            int index = startPos;
            int tmpAns = fruitsMap.getOrDefault(index, 0);
            while (tmpK > 0) {
                index++;
                tmpK--;
                tmpAns += fruitsMap.getOrDefault(index, 0);
            }
            max = Math.max(max,tmpAns);
            int endIndex = index - tmpK;
            while (index > startPos) {
                tmpAns -= fruitsMap.getOrDefault(index, 0);
                index--;
                endIndex --;
                if(endIndex < startPos){
                    tmpAns += fruitsMap.getOrDefault(endIndex, 0);
                }
                endIndex --;
                if(endIndex < startPos){
                    tmpAns += fruitsMap.getOrDefault(endIndex, 0);
                }
                max = Math.max(max,tmpAns);
            }
            return max;
        }

        public int leftMaxTotalFruits(int[][] fruits, int startPos, int k) {
            int max = 0;
            Map<Integer, Integer> fruitsMap = new HashMap<>();
            for (int[] fruit : fruits) {
                fruitsMap.put(fruit[0], fruit[1]);
            }
            int tmpK = k;
            int index = startPos;
            int tmpAns = fruitsMap.getOrDefault(index, 0);
            while (tmpK > 0) {
                index--;
                tmpK--;
                tmpAns += fruitsMap.getOrDefault(index, 0);
            }
            max = Math.max(max,tmpAns);
            int endIndex = index + tmpK;
            while (index < startPos) {
                tmpAns -= fruitsMap.getOrDefault(index, 0);
                index++;
                endIndex ++;
                if(endIndex > startPos){
                    tmpAns += fruitsMap.getOrDefault(endIndex, 0);
                }
                endIndex ++;
                if(endIndex > startPos){
                    tmpAns += fruitsMap.getOrDefault(endIndex, 0);
                }
                max = Math.max(max,tmpAns);
            }
            return max;
        }


    }

}
