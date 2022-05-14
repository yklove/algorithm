package cn.yklove.leetcode.contest.weekly267;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author beamjl
 */
public class LeetCode4 {

    class Solution {
        public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
            int[] fa = new int[n];
            int[] restrictionsFn = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                restrictionsFn[i] = i;
            }
            boolean[][] xxx = new boolean[n][n];
            for (int[] restriction : restrictions) {
                xxx[restriction[0]][restriction[1]] = true;
                xxx[restriction[1]][restriction[0]] = true;
            }
            boolean[] ans = new boolean[requests.length];
            for (int i = 0; i < requests.length; i++) {
                int x = requests[i][0];
                int y = requests[i][1];
                if (xxx[x][y] || xxx[y][x]) {
                    continue;
                }
                if (find(restrictionsFn, x) == find(restrictionsFn, y)) {
                    continue;
                }
                ans[i] = true;
                unionSet(fa, x, y);
                for (int j = 0; j < n; j++) {
                    if(xxx[x][j]){
                        unionSet(restrictionsFn, x, j);
                    }
                    if(xxx[y][j]){
                        unionSet(restrictionsFn, y, j);
                    }
                }
                unionSet(restrictionsFn, x, y);
            }
            return ans;
        }

        private int find(int[] fn, int x) {
            if (fn[x] != x) {
                fn[x] = find(fn, fn[x]);
            }
            return fn[x];
        }

        private void unionSet(int[] fn, int x, int y) {
            x = find(fn,x);
            y = find(fn,y);
            fn[x] = y;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
//        solution.friendRequests(18, new int[][]{{14, 2}, {1, 8}, {4, 5}, {16, 6}, {10, 8}, {10, 3}, {17, 14}, {13, 2}, {5, 1}, {0, 4}, {8, 12}, {6, 5}, {7, 9}, {12, 16}, {17, 16}, {15, 11}, {5, 7}, {9, 16}, {14, 7}, {7, 8}, {2, 7}, {3, 5}, {9, 13}, {10, 13}, {2, 3}, {2, 17}, {12, 3}, {9, 10}, {15, 4}, {11, 13}, {13, 7}, {7, 1}, {13, 6}, {10, 11}, {10, 17}, {11, 2}, {7, 17}, {0, 10}, {15, 1}, {9, 3}, {1, 11}, {11, 0}, {7, 6}, {8, 0}, {6, 15}, {0, 13}, {9, 15}, {5, 11}, {6, 12}, {17, 15}, {2, 12}, {15, 0}, {4, 7}, {16, 5}, {9, 5}, {4, 3}, {12, 5}, {1, 2}, {13, 5}, {10, 7}, {12, 15}, {11, 17}, {12, 0}, {9, 14}, {17, 12}, {4, 6}, {13, 15}, {4, 10}, {11, 7}, {8, 5}, {5, 17}, {8, 3}, {15, 7}, {13, 12}, {9, 0}, {17, 3}, {11, 8}, {8, 16}, {2, 16}, {4, 12}, {3, 1}, {8, 14}, {15, 3}, {14, 11}, {6, 0}, {12, 7}, {0, 2}, {0, 7}, {5, 14}, {8, 2}, {13, 17}, {17, 8}, {4, 13}, {1, 0}, {7, 16}, {5, 2}, {9, 11}, {12, 9}, {16, 3}, {5, 15}, {2, 15}, {3, 6}, {17, 9}, {4, 16}, {4, 2}}
//                , new int[][]{{12, 0}, {4, 7}, {9, 0}, {4, 5}, {4, 6}, {0, 16}, {2, 15}, {1, 2}, {12, 15}, {16, 6}, {13, 3}, {2, 12}, {12, 15}, {9, 15}, {2, 16}, {1, 8}, {12, 5}, {2, 16}, {14, 13}, {9, 13}, {3, 1}, {13, 16}, {8, 13}, {9, 16}, {5, 2}, {4, 14}, {9, 10}, {6, 5}, {5, 7}, {12, 3}, {8, 2}, {12, 0}, {0, 17}, {12, 16}, {9, 15}, {4, 3}, {11, 7}, {4, 13}, {4, 6}, {10, 13}, {14, 12}, {15, 0}, {9, 6}, {4, 10}, {7, 8}, {4, 3}, {10, 17}, {4, 10}, {1, 2}, {11, 12}, {6, 5}, {5, 2}, {9, 10}, {14, 7}, {17, 15}, {2, 17}, {11, 0}, {14, 0}, {14, 11}, {15, 7}, {13, 6}, {4, 14}, {0, 4}, {17, 3}, {11, 17}, {8, 12}, {6, 11}, {3, 11}, {17, 15}, {17, 16}, {4, 5}, {12, 7}, {0, 17}, {15, 11}, {0, 4}, {10, 16}, {15, 7}, {14, 12}, {1, 6}, {11, 13}, {10, 13}, {0, 5}, {1, 0}, {10, 11}, {2, 17}, {1, 11}, {13, 2}, {0, 5}, {12, 7}, {17, 14}, {12, 9}, {0, 17}, {15, 10}, {5, 2}, {16, 6}, {0, 13}, {17, 6}, {1, 11}, {13, 17}, {11, 8}, {0, 16}, {13, 17}, {6, 11}, {0, 7}, {13, 12}, {11, 16}, {8, 13}, {17, 6}, {8, 13}, {9, 8}, {9, 0}, {17, 16}, {4, 13}});
//        solution.friendRequests(7, new int[][]{{0, 6}, {6, 2}}, new int[][]{{0, 2}, {2, 3}, {0, 2}, {6, 4}, {6, 4}});
        solution.friendRequests(5, new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[][]{{0, 4}, {1, 2}, {3, 1}, {3, 4}});
    }
}
