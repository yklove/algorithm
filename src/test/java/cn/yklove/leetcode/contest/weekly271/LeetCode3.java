package cn.yklove.leetcode.contest.weekly271;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int indexAlice = 0;
            int indexBob = plants.length - 1;
            int capacityAlice = capacityA;
            int capacityBob = capacityB;
            int ansAlice = 0;
            int ansBob = 0;
            while (indexAlice < indexBob) {
                if (capacityAlice < plants[indexAlice]) {
                    ansAlice++;
                    capacityAlice = capacityA;
                }
                capacityAlice -= plants[indexAlice];
                indexAlice++;

                if (capacityBob < plants[indexBob]) {
                    ansBob++;
                    capacityBob = capacityB;
                }
                capacityBob -= plants[indexBob];
                indexBob--;
            }
            if (indexAlice == indexBob) {
                if (capacityAlice >= capacityBob) {
                    if (capacityAlice < plants[indexAlice]) {
                        ansAlice++;
                    }
                } else {
                    if (capacityBob < plants[indexBob]) {
                        ansBob++;
                    }
                }
            }
            return ansAlice + ansBob;
        }
    }

}
