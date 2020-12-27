import java.util.concurrent.atomic.*;

public class Lucky {
    static AtomicInteger z = new AtomicInteger(0);
    static AtomicInteger count = new AtomicInteger(0);
    static class LuckyThread extends Thread {
        public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }

    @Override
        public void run() {
            while (true) {
                int zValue = z.getAndIncrement();
                if (zValue > 999999) break;
                if ((zValue % 10) + (zValue / 10) % 10 + (zValue / 100) % 10 == (zValue / 1000)
                        % 10 + (zValue / 10000) % 10 + (zValue / 100000) % 10) {
                    System.out.println(zValue);
                    count.incrementAndGet();
                }
            }
        }
    }
}