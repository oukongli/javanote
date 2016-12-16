import java.util.concurrent.CountDownLatch;

/**
 * Created by ou_ko on 2016/12/16.
 */
public class TestThread {

    public static class DemoThread extends Thread {

        private CountDownLatch countDownLatch;

        private String threadName;

        public DemoThread(String threadName, CountDownLatch countDownLatch) {
            this.threadName = threadName;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            calc();
            System.out.println(String.format("sub thread %1$s complete", threadName));
            countDownLatch.countDown();
        }
    }


    // wrong useage
    private static CountDownLatch countDownLatch;

    public static void main(String[] args) throws Exception {
        try {
            for (int i = 0; i < 2; i++) {
                final int j = i;
                new Thread() {
                    @Override
                    public void run() {
                        int threadNum = j == 0 ? 10 : 1;
                        countDownLatch = new CountDownLatch(threadNum);
                        for (int i = 1; i <= threadNum; i++) {
                            if ((i & 1) == 0)
                                calc();
                            new DemoThread(j + 1 + ":" + i, countDownLatch).start();
                        }
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        countDownLatch = null;
                    }
                }.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }


//        calc();
//        calc();
        System.out.println("main thread complete");
    }


    public static void calc() {
        fibonacci(40);
/*        long start = System.nanoTime();
        System.out.println("result=" + fibonacci(45));
        System.out.println((System.nanoTime() - start) * 1.0 / 1000 / 1000 / 1000);*/
    }

    public static long fibonacci(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
