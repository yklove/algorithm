package cn.yklove.leetcode.contest.weekly274;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public int maximumInvitations(int[] favorite) {
            ListNode[] listNodes = new ListNode[favorite.length];
            for (int i = 0; i < favorite.length; i++) {
                listNodes[i] = new ListNode(i);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < favorite.length; i++) {
                set.add(favorite[i]);
                listNodes[i].next = listNodes[favorite[i]];
            }
            int ans = 0;
            if (set.size() == favorite.length) {
                return favorite.length;
            }
            for (int i = 0; i < favorite.length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                ListNode listNode = detectCycle(listNodes[i]);
                int count = 1;
                ListNode pre = listNode;
                while (pre.next != listNode) {
                    pre = pre.next;
                    count++;
                }
                if(count == 2 && listNodes[i] != listNode){
                    count++;
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }

        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(3, solution.maximumInvitations(new int[]{2, 2, 1, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, solution.maximumInvitations(new int[]{3, 0, 1, 4, 1}));
    }


}
