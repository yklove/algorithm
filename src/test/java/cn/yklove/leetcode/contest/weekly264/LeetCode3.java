package cn.yklove.leetcode.contest.weekly264;

import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class Solution {

        Map<Integer, TreeNode> map;

        public int countHighestScoreNodes(int[] parents) {
            map = new HashMap<>();
            for (int i = 0; i < parents.length; i++) {
                map.put(i, new TreeNode(i));
            }
            for (int i = 1; i < parents.length; i++) {
                TreeNode fatherNode = map.get(parents[i]);
                fatherNode.childs.add(map.get(i));
            }
            process(map.get(0));
            Optional<Long> max = map.values().stream().map(treeNode -> treeNode.grade).max(Long::compareTo);
            return (int) map.values().stream().map(treeNode -> treeNode.grade).filter(v -> v.equals(max.get())).count();
        }

        private long process(TreeNode treeNode) {
            long count = 0;
            long ans = 1;
            for (TreeNode child : treeNode.childs) {
                long process = process(child);
                count += process;
                ans *= process;
            }
            ans *= Math.max(map.size() - count - 1, 1);
            treeNode.grade = ans;
            return count + 1;
        }

        class TreeNode {
            int n;
            long grade;
            List<TreeNode> childs = new ArrayList<>();

            public TreeNode(int n) {
                this.n = n;
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
//        solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
        solution.countHighestScoreNodes(new int[]{});
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
//        Solution solution = new Solution();
//        System.out.println(solution.countHighestScoreNodes(ints));;

    }


}
