package cn.yklove;


import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 4792 👎 0
public class AddTwoNumbers {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ans = new ListNode(7);
        ans.next = new ListNode(0);
        ans.next.next = new ListNode(8);
        Assert.assertEquals(solution.addTwoNumbers(l1, l2), ans);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carryANumber = 0;
            ListNode head = new ListNode(-1);
            ListNode tmp = head;
            while (l1 != null && l2 != null) {
                int current = l1.val + l2.val + carryANumber;
                tmp.next = new ListNode(current % 10);
                carryANumber = current / 10;
                tmp = tmp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int current = l1.val + carryANumber;
                tmp.next = new ListNode(current % 10);
                carryANumber = current / 10;
                tmp = tmp.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int current = l2.val + carryANumber;
                tmp.next = new ListNode(current % 10);
                carryANumber = current / 10;
                tmp = tmp.next;
                l2 = l2.next;
            }
            if (carryANumber != 0) {
                tmp.next = new ListNode(carryANumber);
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

}
