package cn.yklove.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class Problem35 {

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node tmp = head;
            // 存下每个元素的位置
            Map<Node, Integer> originNodeMap = new HashMap<>();
            int index = 0;
            while (tmp != null) {
                originNodeMap.put(tmp, index++);
                tmp = tmp.next;
            }
            // 记录每个位置下一个node的位置
            int[] randomArrays = new int[index];
            index = 0;
            tmp = head;
            while (tmp != null) {
                randomArrays[index++] = originNodeMap.getOrDefault(tmp.random, -1);
                tmp = tmp.next;
            }

            Node[] copyNodeArrays = new Node[index];
            for (Map.Entry<Node, Integer> nodeIntegerEntry : originNodeMap.entrySet()) {
                // 复制val
                copyNodeArrays[nodeIntegerEntry.getValue()] = new Node(nodeIntegerEntry.getKey().val);
            }
            for (int i = 0; i < copyNodeArrays.length - 1; i++) {
                // 建立next关系
                copyNodeArrays[i].next = copyNodeArrays[i + 1];
            }
            for (int i = 0; i < copyNodeArrays.length; i++) {
                // 建立random
                copyNodeArrays[i].random = randomArrays[i] != -1 ? copyNodeArrays[randomArrays[i]] : null;
            }
            return copyNodeArrays[0];
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
