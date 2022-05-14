package cn.yklove.leetcode.contest.weekly292;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {

        private Map<Stack<Character>, Boolean>[][] tmp;

        public boolean hasValidPath(char[][] grid) {
            tmp = new Map[grid.length + 1][grid[0].length + 1];
            Stack<Character> stack = new Stack<>();
            if (grid[0][0] == ')') {
                return false;
            }
            stack.push(grid[0][0]);
            return process(grid, 0, 1, stack) ||
                    process(grid, 1, 0, stack);
        }

        private boolean process(char[][] grid, int x, int y, Stack<Character> stack) {
            if (tmp[x][y] != null) {
                Boolean aBoolean = tmp[x][y].get(stack);
                if (Objects.nonNull(aBoolean)) {
                    return aBoolean;
                }
            }
            if (grid.length + grid[0].length - (x + y) < stack.size()) {
                if (Objects.nonNull(tmp[x][y])) {
                    tmp[x][y].put(stack, false);
                } else {
                    tmp[x][y] = new HashMap<>();
                    tmp[x][y].put(stack, false);
                }
                return false;
            }
            if ((x == grid.length && y == grid[0].length - 1) || (x == grid.length - 1 && y == grid[0].length)) {
                boolean empty = stack.isEmpty();
                if (Objects.nonNull(tmp[x][y])) {
                    tmp[x][y].put(stack, empty);
                } else {
                    tmp[x][y] = new HashMap<>();
                    tmp[x][y].put(stack, empty);
                }
                return empty;
            }
            if (x >= grid.length || y >= grid[0].length) {
                if (Objects.nonNull(tmp[x][y])) {
                    tmp[x][y].put(stack, false);
                } else {
                    tmp[x][y] = new HashMap<>();
                    tmp[x][y].put(stack, false);
                }
                return false;
            }
            char achar;
            achar = grid[x][y];
            int z;
            if (stack.isEmpty()) {
                if (achar == ')') {
                    if (Objects.nonNull(tmp[x][y])) {
                        tmp[x][y].put(stack, false);
                    } else {
                        tmp[x][y] = new HashMap<>();
                        tmp[x][y].put(stack, false);
                    }
                    return false;
                }
                stack.push(achar);
                z = 0;
            } else {
                if (stack.peek().equals('(')) {
                    if (achar == ')') {
                        stack.pop();
                        z = 1;
                    } else {
                        stack.push(achar);
                        z = 0;
                    }
                } else {
                    if (achar == ')') {
                        if (Objects.nonNull(tmp[x][y])) {
                            tmp[x][y].put(stack, false);
                        } else {
                            tmp[x][y] = new HashMap<>();
                            tmp[x][y].put(stack, false);
                        }
                        return false;
                    } else {
                        stack.push(achar);
                        z = 0;
                    }
                }
            }
            boolean result = process(grid, x + 1, y, stack) || process(grid, x, y + 1, stack);
            if (!result) {
                switch (z) {
                    case 1:
                        stack.push('(');
                        break;
                    case 0:
                        stack.pop();
                        break;
                }
            }
            if (Objects.nonNull(tmp[x][y])) {
                tmp[x][y].put(stack, result);
            } else {
                tmp[x][y] = new HashMap<>();
                tmp[x][y].put(stack, result);
            }
            return result;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertTrue(solution.hasValidPath(new char[][]{
                {'(', '(', '('},
                {')', '(', ')'},
                {'(', '(', ')'},
                {'(', '(', ')'}
        }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.hasValidPath(new char[][]{
                {')', ')'},
                {'(', '('}
        }));
    }

    @Test
    public void test3() {
        Assert.assertFalse(solution.hasValidPath(new char[][]{
                {'(', ')', ')', '(', ')', ')', ')'}
        }));
    }

    @Test
    public void test4() {
        Assert.assertFalse(solution.hasValidPath(new char[][]{
                {'(', ')'},
                {'(', ')'}
        }));
    }

    @Test
    public void test5() {
        long time = System.currentTimeMillis();
        Assert.assertFalse(solution.hasValidPath(new char[][]{
                {'(', '(', ')', ')', ')', '(', '(', ')', '(', '(', ')', '(', ')', '(', '(', ')'},
                {')', '(', ')', ')', ')', ')', '(', '(', '(', '(', ')', ')', '(', '(', '(', '('},
                {'(', ')', ')', ')', '(', '(', '(', ')', '(', '(', ')', ')', ')', '(', ')', ')'},
                {'(', '(', ')', ')', ')', ')', '(', '(', '(', ')', '(', '(', '(', ')', '(', '('},
                {'(', '(', '(', '(', '(', '(', ')', ')', ')', '(', '(', ')', ')', '(', ')', ')'},
                {'(', '(', ')', '(', ')', '(', '(', '(', '(', ')', ')', ')', '(', '(', ')', ')'},
                {')', '(', '(', '(', ')', '(', ')', ')', ')', ')', '(', '(', ')', ')', ')', '('},
                {'(', '(', '(', ')', '(', '(', ')', ')', ')', '(', '(', ')', '(', ')', ')', '('},
                {')', ')', '(', ')', ')', ')', '(', '(', '(', ')', '(', '(', ')', '(', ')', ')'},
                {'(', '(', ')', ')', ')', '(', ')', ')', ')', ')', '(', ')', '(', '(', '(', ')'},
                {'(', '(', '(', ')', '(', ')', ')', '(', '(', ')', ')', ')', '(', ')', '(', ')'},
                {'(', ')', ')', ')', ')', ')', ')', '(', ')', ')', ')', ')', '(', ')', ')', ')'},
                {')', '(', ')', ')', '(', '(', '(', '(', '(', ')', '(', ')', '(', ')', '(', ')'},
                {')', ')', ')', ')', '(', ')', ')', '(', ')', ')', ')', ')', '(', '(', ')', ')'}
        }));
        System.out.println(System.currentTimeMillis() - time);
    }

}
