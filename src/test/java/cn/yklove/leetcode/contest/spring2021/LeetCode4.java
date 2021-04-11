package cn.yklove.leetcode.contest.spring2021;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<List<String>> maze = Arrays.asList(
                Arrays.asList(".#.", "#.."),
                Arrays.asList("...", ".#."),
                Arrays.asList(".##", ".#."),
                Arrays.asList("..#", ".#.")
        );
        Assert.assertTrue(solution.escapeMaze(maze));
    }

    @Test
    public void test2() {
        List<List<String>> maze = Arrays.asList(
                Arrays.asList(".#.", "..."),
                Arrays.asList("...", "...")
        );
        Assert.assertFalse(solution.escapeMaze(maze));
    }

    @Test
    public void test3() {
        List<List<String>> maze = Arrays.asList(
                Arrays.asList("...", "...", "..."),
                Arrays.asList(".##", "###", "##."),
                Arrays.asList(".##", "###", "##."),
                Arrays.asList(".##", "###", "##."),
                Arrays.asList(".##", "###", "##."),
                Arrays.asList(".##", "###", "##."),
                Arrays.asList(".##", "###", "##.")
        );
        Assert.assertFalse(solution.escapeMaze(maze));
    }

    @Test
    public void test4() throws FileNotFoundException {
        Scanner in = new Scanner(
                new File(this.getClass().getResource("").getPath() + "/LeetCode4_1.txt"));
        String line = in.nextLine();
//        line.split()

//        Assert.assertFalse(solution.escapeMaze(maze));
    }

    class Solution {

        Map<Info, Boolean> dp;

        public boolean escapeMaze(List<List<String>> maze) {
            dp = new HashMap<>();
            return process(0, 0, 0, maze, true, true, -1, -1);
        }

        /**
         * @param x          坐标点x
         * @param y          坐标点y
         * @param time       当前的时间点
         * @param maze       地图
         * @param temporary  临时卷轴是否可用
         * @param permanent  永久卷轴是否可用
         * @param permanentX 永久卷轴使用时的x
         * @param permanentY 永久卷轴使用时的y
         * @return 是否可以走到终点
         */
        private boolean process(int x,
                                int y,
                                int time,
                                List<List<String>> maze,
                                boolean temporary,
                                boolean permanent,
                                int permanentX,
                                int permanentY) {
            if (dp.containsKey(new Info(x, y, time, temporary, permanent, permanentX, permanentY))) {
                return dp.get(new Info(x, y, time, temporary, permanent, permanentX, permanentY));
            }
            // 到达终点
            if (x == maze.get(time).size() - 1 &&
                    y == maze.get(time).get(0).length() - 1) {
                dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                return true;
            }
            // 超出时间范围
            if (time == maze.size() - 1) {
                dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), false);
                return false;
            }
            // 原地不动
            if (extracted(x, y, time, maze, temporary, permanent, permanentX, permanentY)) {
                dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                return true;
            }
            // 尝试着向左走
            if (y - 1 >= 0) {
                if (extracted(x, y - 1, time, maze, temporary, permanent, permanentX, permanentY)) {
                    dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                    return true;
                }
            }
            if (x - 1 >= 0) {
                if (extracted(x - 1, y, time, maze, temporary, permanent, permanentX, permanentY)) {
                    dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                    return true;
                }
            }
            if (x + 1 < maze.get(0).size()) {
                if (extracted(x + 1, y, time, maze, temporary, permanent, permanentX, permanentY)) {
                    dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                    return true;
                }
            }
            if (y + 1 < maze.get(0).get(0).length()) {
                if (extracted(x, y + 1, time, maze, temporary, permanent, permanentX, permanentY)) {
                    dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), true);
                    return true;
                }
            }
            dp.put(new Info(x, y, time, temporary, permanent, permanentX, permanentY), false);
            return false;
        }

        private boolean extracted(int x, int y, int time, List<List<String>> maze, boolean temporary, boolean permanent, int permanentX, int permanentY) {
            // 检查左是否存在墙,不存在墙，可以走
            if (maze.get(time + 1).get(x).charAt(y) == '.') {
                boolean process = process(x, y, time + 1, maze, temporary, permanent, permanentX, permanentY);
                if (process) {
                    return true;
                }
            } else {
                // 检查下永久卷轴是否可用
                if (permanent) {
                    //使用掉
                    boolean process = process(x, y, time + 1, maze, temporary, false, x, y);
                    if (process) {
                        return true;
                    }
                } else {
                    // 已经被使用了，检查下是否是这个点
                    if (permanentX == x && permanentY == y) {
                        boolean process = process(x, y, time + 1, maze, temporary, permanent, permanentX, permanentY);
                        if (process) {
                            return true;
                        }
                    }
                }
                // 临时卷轴可用
                if (temporary) {
                    boolean process = process(x, y, time + 1, maze, false, permanent, permanentX, permanentY);
                    if (process) {
                        return true;
                    }
                }
            }
            return false;
        }

        class Info {
            private int x;
            private int y;
            private int time;
            private boolean temporary;
            private boolean permanent;
            private int permanentX;
            private int permanentY;

            public Info(int x, int y, int time, boolean temporary, boolean permanent, int permanentX, int permanentY) {
                this.x = x;
                this.y = y;
                this.time = time;
                this.temporary = temporary;
                this.permanent = permanent;
                this.permanentX = permanentX;
                this.permanentY = permanentY;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Info info = (Info) o;
                return x == info.x && y == info.y && time == info.time && temporary == info.temporary && permanent == info.permanent && permanentX == info.permanentX && permanentY == info.permanentY;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y, time, temporary, permanent, permanentX, permanentY);
            }
        }


    }


}
