package cn.yklove.leetcode.contest.weekly215;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class Solution {
        public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
            int[][] array = new int[m][n];
            for (int i = 0; i < introvertsCount; i++) {
                int x = 0;
                int y = 0;
                int grade = getGrade2(array, x, y);
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int tmpGrade = getGrade2(array, j, k);
                        if (tmpGrade > grade) {
                            grade = tmpGrade;
                            x = j;
                            y = k;
                        }
                    }
                }
                array[x][y] = 1;
            }
            for (int i = 0; i < extrovertsCount; i++) {
                int x = 0;
                int y = 0;
                int grade = getGrade(array, x, y);
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int tmpGrade = getGrade(array, j, k);
                        if (tmpGrade > grade) {
                            grade = tmpGrade;
                            x = j;
                            y = k;
                        }
                    }
                }
                array[x][y] = 2;
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] == 1) {
                        ans += getGrade2Ans(array, i, j);
                    } else if (array[i][j] == 2) {
                        ans += getGradeAns(array, i, j);
                    }
                }
            }
            return ans;
        }

        private int getGrade(int[][] array, int j, int k) {
            int grade = 40;
            if (array[j][k] != 0) {
                return Integer.MIN_VALUE;
            }
            if (j + 1 < array.length) {
                if (array[j + 1][k] == 2) {
                    grade += 40;
                } else if (array[j + 1][k] == 1) {
                    grade -= 10;
                }
            }
            if (j - 1 >= 0) {
                if (array[j - 1][k] == 2) {
                    grade += 40;
                } else if (array[j - 1][k] == 1) {
                    grade -= 10;
                }
            }
            if (k + 1 < array[0].length) {
                if (array[j][k + 1] == 2) {
                    grade += 40;
                } else if (array[j][k + 1] == 1) {
                    grade -= 10;
                }
            }
            if (k - 1 >= 0) {
                if (array[j][k - 1] == 2) {
                    grade += 40;
                } else if (array[j][k - 1] == 1) {
                    grade -= 10;
                }
            }
            return grade;
        }

        private int getGradeAns(int[][] array, int j, int k) {
            int grade = 40;
            if (j + 1 < array.length) {
                if (array[j + 1][k] != 0) {
                    grade += 20;
                }
            }
            if (j - 1 >= 0) {
                if (array[j - 1][k] != 0) {
                    grade += 20;
                }
            }
            if (k + 1 < array[0].length) {
                if (array[j][k + 1] != 0) {
                    grade += 20;
                }
            }
            if (k - 1 >= 0) {
                if (array[j][k - 1] != 0) {
                    grade += 20;
                }
            }
            return grade;
        }

        private int getGrade2(int[][] array, int j, int k) {
            int grade = 120;
            if (array[j][k] != 0) {
                return Integer.MIN_VALUE;
            }
            if (j + 1 < array.length) {
                if (array[j + 1][k] == 2) {
                    grade -= 10;
                } else if (array[j + 1][k] == 1) {
                    grade -= 60;
                }
            }
            if (j - 1 >= 0) {
                if (array[j - 1][k] == 2) {
                    grade -= 10;
                } else if (array[j - 1][k] == 1) {
                    grade -= 60;
                }
            }
            if (k + 1 < array[0].length) {
                if (array[j][k + 1] == 2) {
                    grade -= 10;
                } else if (array[j][k + 1] == 1) {
                    grade -= 60;
                }
            }
            if (k - 1 >= 0) {
                if (array[j][k - 1] == 2) {
                    grade -= 10;
                } else if (array[j][k - 1] == 1) {
                    grade -= 60;
                }
            }
            return grade;
        }

        private int getGrade2Ans(int[][] array, int j, int k) {
            int grade = 120;
            if (j + 1 < array.length) {
                if (array[j + 1][k] != 0) {
                    grade -= 30;
                }
            }
            if (j - 1 >= 0) {
                if (array[j - 1][k] != 0) {
                    grade -= 30;
                }
            }
            if (k + 1 < array[0].length) {
                if (array[j][k + 1] != 0) {
                    grade -= 30;
                }
            }
            if (k - 1 >= 0) {
                if (array[j][k - 1] != 0) {
                    grade -= 30;
                }
            }
            return grade;
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(240, solution.getMaxGridHappiness(2, 3, 1, 2));
    }
}
