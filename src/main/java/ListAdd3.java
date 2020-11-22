
import sun.misc.Contended;

import java.util.ArrayList;
import java.util.List;

public class ListAdd3 {

    // 1 定义的承装字符串的容器
    private  volatile List list = new ArrayList();

    // 2 追加方法
    public void add() {
        list.add("bfxy");
    }

    public int size() {
        return list.size();
    }

    private static ListAdd3 list1;

    public static void main(String[] args) throws InterruptedException {


        for (int count = 0; count < 10000; count++) {
            list1 = new ListAdd3();

            // 线程A
            Thread A = new Thread(() -> {

                for (int i = 0; i < 10; i++) {
                    list1.add();
//                    System.out.println("当前线程：" + Thread.currentThread().getName() + ", 添加了一个元素..");
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }, "A");

            // 线程B
            Thread B = new Thread(() -> {
                try {
                    while (true) {
                        if (list1.size() == 5) {
                            System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                            throw new RuntimeException();
                        }
                    }
                }catch (Exception e){

                }

            }, "B");

            B.start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A.start();

            A.join();
            B.join();
            System.out.println("--------------------");
        }


    }


}