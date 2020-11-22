import java.util.concurrent.TimeUnit;

/**
 * @author liweizhi
 * @date 2020/3/4 18:18
 */
public class VolatileObject {
    volatile static Pet pet = new Pet("dahuang", 1);

    public static void main(String[] args) {
        // 多运行几次无论是ageChange还是nameChange,会发现有时候t1不会结束(如果t2不sleep)
        nameChange();
//        ageChange();
    }

    private static void ageChange() {
        new Thread(() -> {
            System.out.println("t1 start "/* + Instant.now()*/);
            while (true) {
                if (pet.getAge() == 5) {
                    break;
                }
            }
            System.out.println("t1 end "/* + Instant.now()*/);
        }, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Pet myPet = pet;
            for (int i = 1; i <= 100; i++) {
                int age = myPet.getAge();
                myPet.setAge(++age);
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println("t2 end "/* + Instant.now()*/);
        }, "t2").start();
    }

    private static void nameChange() {
        new Thread(() -> {
            System.out.println("t1 start "/* + Instant.now()*/);
            while (true) {
                if ("xiaobai8".equals(pet.getName())) {
                    break;
                }
            }
            System.out.println("t1 end "/* + Instant.now()*/);
        }, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            Pet myPet = pet;
            for (int i = 1; i <= 10; i++) {
                myPet.setName("xiaobai" + i);
                /*try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println("t2 end "/* + Instant.now()*/);
        }, "t2").start();
    }

    static class Pet {
        String name;

        int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}