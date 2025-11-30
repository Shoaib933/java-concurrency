package runnableExWithFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class RunnableWithFuture {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Runnable task = ()-> {

            try {
                System.out.println(Thread.currentThread().getName()+" - : Waiting...");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" - : task completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Future<?> future = ex.submit(task);
        future.get(); // if we comment this line that means main thread does not wait child thtread
//        System.out.println(future.get());
        System.out.println(Thread.currentThread().getName()+" - : task Has completed successfully");

    }
}
