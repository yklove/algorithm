package cn.yklove;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class Main {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        b.start();
        a.start();
    }


    static class ThreadA extends Thread {

        private ThreadB b;

        public ThreadA(ThreadB b) {
            this.b = b;
        }

        @Override
        public void run() {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println(i);
                if (i == 4) {
                    b.setXx(1);
                }
            }
        }
    }

    static class ThreadB extends Thread {

        private volatile int xx = 0;

        public void setXx(int xx) {
            this.xx = xx;
        }

        @Override
        public void run() {
            while (true) {
                if (xx == 1) {
                    System.out.println("执行业务");
                    throw new RuntimeException();
                }
            }
        }
    }

}
