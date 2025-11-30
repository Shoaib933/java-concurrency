package cyclicbarrierPro;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String [] s) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> {
            System.out.println("Barrier Reached!!!");
        });
        System.out.println("Startting ..........");
        new MyThread(cyclicBarrier, "A");
        new MyThread(cyclicBarrier, "B");
        new MyThread(cyclicBarrier, "C"); // if we comment this line notend 7 waiting binfinite time
    }
}

class MyThread{
    CyclicBarrier cbar;
    String name;

    public MyThread(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;
        new Thread(() -> {
            System.out.println(name);
            try {
                cbar.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


}
