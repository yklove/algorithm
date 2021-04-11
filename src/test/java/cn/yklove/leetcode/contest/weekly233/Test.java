package cn.yklove.leetcode.contest.weekly233;

/**
 * @author qinggeng
 */
public class Test {

    public static void main(String[] args) {
        int[] in = new int[]{1, 99, 1, 1, 99};
        // 暴力递归
        System.out.println(process(in, false, 0));
        // 动态规划
        int[][] dp = new int[in.length + 1][2];
        for (int i = in.length - 1; i >= 0; i--) {
            dp[i][1] = dp[i + 1][0];
            dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] + in[i]);
        }
        System.out.println(dp[0][0]);
    }

    private static int process(int[] in, boolean flag, int i) {
        if (i == in.length) {
            return 0;
        }
        if (flag) {
            return process(in, false, i + 1);
        }
        return Math.max(process(in, false, i + 1), process(in, true, i + 1) + in[i]);
    }

}
