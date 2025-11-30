package countdownpro;

import java.util.concurrent.CountDownLatch;

class CountDownLatchExample {
    public static void main(String[] s) {
        CountDownLatch latch = new CountDownLatch(3);
//        for(int i=1; i<3; i++) { task not cpleted & wait
        for(int i=0; i<3; i++) {
            new Thread(() -> {
                System.out.println("Task completed By Thread "+Thread.currentThread().threadId());
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
            System.out.println("All tasks copmleted, proceeding to the next step!!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
