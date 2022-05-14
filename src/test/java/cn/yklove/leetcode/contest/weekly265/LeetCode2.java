package cn.yklove.leetcode.contest.weekly265;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beamjl
 */
public class LeetCode2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode tmp = head;
            while (tmp != null) {
                list.add(tmp.val);
                tmp = tmp.next;
            }
            if (list.size() < 4) {
                return new int[]{-1, -1};
            }
            List<Integer> indexList = new ArrayList<>();
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                    indexList.add(i);
                } else if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                    indexList.add(i);
                }
            }
            if (indexList.size() < 2) {
                return new int[]{-1, -1};
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < indexList.size(); i++) {
                min = Math.min(min, indexList.get(i) - indexList.get(i - 1));
            }
            return new int[]{min, indexList.get(indexList.size() - 1) - indexList.get(0)};
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
