package cn.yklove.leetcode.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode841 {

    /**
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     * <p>
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中
     * N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     * <p>
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     * <p>
     * 你可以自由地在房间之间来回走动。
     * <p>
     * 如果能进入每个房间返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入: [[1],[2],[3],[]] 输出: true 解释: 我们从 0 号房间开始，拿到钥匙 1。 之后我们去 1 号房间，拿到钥匙 2。
     * 然后我们去 2 号房间，拿到钥匙 3。 最后我们去了 3 号房间。 由于我们能够进入每个房间，我们返回 true。
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/keys-and-rooms
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {

        /**
         * 暴力求解
         */
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[] roomArray = new int[rooms.size()];
            List<Integer> keys = rooms.get(0);
            int count = 1;
            roomArray[0] = 1;
            while (keys != null && keys.size() > 0) {
                List<Integer> tmp = new ArrayList<>();
                for (int var : keys) {
                    if (roomArray[var] == 0) {
                        roomArray[var] = 1;
                        count++;
                        tmp.addAll(rooms.get(var));
                    }
                }
                keys = tmp;
            }
            return count == rooms.size();
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.canVisitAllRooms(
                Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));

    }

}