package cn.yklove.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author qinggeng
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int ans = 0;
        for (int i = a; i <= b; i++) {
            String s = String.valueOf(i);
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            if (set.size() != 6) {
                continue;
            }
            int x = Integer.valueOf(s.substring(0, 2));
            int y = Integer.valueOf(s.substring(2, 4));
            int z = Integer.valueOf(s.substring(4, 6));
            if (x == 0 || y == 0 || z == 0) {
                continue;
            }
            if (x + y == z) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
