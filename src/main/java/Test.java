/**
 * @author qinggeng
 */
public class Test {

//    private static volatile AtomicInteger xx = new AtomicInteger();
//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 10000; j++) {
//                    xx.getAndIncrement();
//                }
//            }).start();
//        }
//        Thread.sleep(5000L);
//        System.out.println(xx.get());
//    }

    static volatile A a = new A();


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    a.i++;
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(a.i);
    }

    static class A {
        volatile int i;
    }
}
