package cn.yklove.leetcode.contest.weekly218;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {

        public int concatenatedBinary(int n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                stringBuilder.append(Integer.toBinaryString(i));
            }
            char[] chars = stringBuilder.reverse().toString().toCharArray();
            BigInteger bigInteger = new BigInteger("0");
            BigInteger tmpTow = new BigInteger("1");
            BigInteger tow = new BigInteger("2");
            for (int i = 0; i < chars.length; i++) {
                BigInteger tmp = (chars[i] == '1' ? tmpTow : BigInteger.ZERO);
                tmpTow = tmpTow.multiply(tow);
                bigInteger = bigInteger.add(tmp);
            }
            return bigInteger.mod(new BigInteger(String.valueOf(1000000000 + 7))).intValue();
        }
    }

    Solution solution = new Solution();


    @Test
    public void test() {
        Assert.assertEquals(1, solution.concatenatedBinary(1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(27, solution.concatenatedBinary(3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(505379714, solution.concatenatedBinary(12));
    }

    @Test
    public void test4() {
        Assert.assertEquals(849490032, solution.concatenatedBinary(6397));
    }

    @Test
    public void test5() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new File("a.txt"));
        for (int i = 1; i <= 100000; i++) {
            printStream.print(solution.concatenatedBinary(i) + ",");
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
        printStream.flush();
        printStream.close();
    }

    @Test
    public void test6() {
        System.out.println(Integer.toBinaryString(505379714));
        System.out.println(Integer.toBinaryString(1000000000 + 7));
    }

    @Test
    public void test7() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new File("b.txt"));
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }
        String collect = list.parallelStream()
                .map(i -> {
                    if (i % 1000 == 0) {
                        System.out.println(i);
                    }
                    return solution.concatenatedBinary(i);
                })
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
        printStream.println(collect);
        printStream.flush();
        printStream.close();
    }
}
