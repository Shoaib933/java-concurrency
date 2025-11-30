package excecutorpro;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    static void main() {

//        for(int i=0; i<10; i++) {
//            Thread t1 = new Thread(new Task(i));
//            t1.start();
//        }
        // We cant start thread more than one time
//        ExecutorService ex = Executors.newFixedThreadPool(10);
//        ExecutorService ex = Executors.newFixedThreadPool(3);
//        ExecutorService ex = Executors.newCachedThreadPool(); // it create thread when each time execute methos called, thread alive for 60 secs.
//        for(int i=0; i<10; i++) {
//            ex.execute(new Task(i));
//        }
//        ex.shutdown();

        ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
        ex.scheduleAtFixedRate(new Task(100), 3, 1, TimeUnit.SECONDS);
    }
}

class Task implements Runnable {

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task : "+taskId+" is running on thtread : "+Thread.currentThread()
                .getName());
    }
}
