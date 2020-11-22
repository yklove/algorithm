package cn.yklove;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] arr = new char[n][m];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextLine().toCharArray();
            }
            System.out.println(arrive(arr) ? "YES" : "NO");
        }
    }

    private static boolean arrive(char[][] arr) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        return process(arr, x, y);
    }

    private static boolean process(char[][] arr, int x, int y) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return false;
        }
        if (arr[x][y] == 'E') {
            return true;
        }
        if (arr[x][y] == '#') {
            return false;
        }
        arr[x][y] = '#';
        return process(arr, x + 1, y) || process(arr, x - 1, y) || process(arr, x, y + 1) || process(arr, x, y - 1);
    }
}
