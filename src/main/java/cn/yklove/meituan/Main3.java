package cn.yklove.meituan;

import java.util.Scanner;

/**
 * @author qinggeng
 */
public class Main3 {

    // 子序列的那个
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        if (m == 0 && n != 0) {
            System.out.println("No");
            return;
        }
        if (n == 0) {
            System.out.println("Yes");
            System.out.println(0);
            return;
        }
        in.nextLine();
        String t = in.nextLine();
        String s = in.nextLine();
        int i = 0, j = 0;
        long sum = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                sum += (j + 1);
                i++;
            }
            j++;
        }
        System.out.println(i == n ? "Yes" : "No");
        if (i == n) {
            System.out.println(sum);
        }
    }

}
