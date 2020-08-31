package cn.yklove.nowcoder.course1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class Problem6 {

    /**
     * 给定一个函数f，可以1~5的数字等概率返回一个。请加工出1~7的数字等概率 返回一个的函数g。
     * 给定一个函数f，可以a~b的数字等概率返回一个。请加工出c~d的数字等概率 返回一个的函数g。
     * 给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的函数g。思路：这个可以随机两次，如果是01，认为是0，如果是10，认为是1，其他情况重新随机2次
     */
    class Solution {

        public int f() {
            return (int) (Math.random() * 6);
        }

        /**
         * 思路，将随机返回的结果转换成0和1，如果0或1多了，就不要了，重新随机一次； 新结果通过多次随机产生的0和1拼二进制位来生成想要的数字。
         * 1~7=0~6+1=2个二进制位，所以需要随机出两个二进制数字
         * 
         * @return
         */
        public int g() {
            while (true) {
                int a1 = 0;
                int a2 = 0;
                int a3 = 0;
                while (true) {
                    int t = f();
                    if (t == 1 || t == 3) {
                        a1 = 0;
                        break;
                    } else if (t == 2 || t == 4) {
                        a1 = 1;
                        break;
                    }
                }
                while (true) {
                    int t = f();
                    if (t == 1 || t == 3) {
                        a2 = 0;
                        break;
                    } else if (t == 2 || t == 4) {
                        a2 = 1;
                        break;
                    }
                }
                while (true) {
                    int t = f();
                    if (t == 1 || t == 3) {
                        a3 = 0;
                        break;
                    } else if (t == 2 || t == 4) {
                        a3 = 1;
                        break;
                    }
                }
                int ans = 1 * a1 + 2 * a2 + 4 * a3;
                if (ans < 7) {
                    return ans + 1;
                }
            }
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10000000;i++){
            list.add(solution.g());
        }
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        System.out.println(collect);
    }
}