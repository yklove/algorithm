package cn.yklove.leetcode.contest.weekly267;

import org.junit.Test;

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
        public ListNode reverseEvenLengthGroups(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            List<ListNode> listNodeList = new ArrayList<>();
            while (head != null) {
                listNodeList.add(new ListNode(head.val));
                head = head.next;
            }
            ListNode ans = listNodeList.get(0);
            ListNode tmp = ans;
            int end = 2;
            int i = 1;
            while (i < listNodeList.size()) {
                int key = Math.min(end, listNodeList.size() - i);

                // 偶数
                if (key % 2 == 0) {
                    for (int j = Math.min(i + end, listNodeList.size()) - 1; j >= i; j--) {
                        tmp.next = listNodeList.get(j);
                        tmp = tmp.next;
                    }
                } else {
                    for (int j = i; j < Math.min(i + end, listNodeList.size()); j++) {
                        tmp.next = listNodeList.get(j);
                        tmp = tmp.next;
                    }
                }
                i = i + end;
                end++;
            }
            return ans;
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

    Solution solution = new Solution();

    @Test
    public void test() {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(1);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next.next.next.next = new ListNode(8);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(4);
        solution.reverseEvenLengthGroups(listNode);
    }

}
