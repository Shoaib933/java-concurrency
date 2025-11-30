package semaphorePro;

import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class SemaphoreSharedcounterExample {
    public static  void main(String[] args) {

        IO.println(String.format("Hello and welcome!"));

        //Semaphore Example

//        Semaphore semaphore = new Semaphore(1);
//        new semaphorePro.IncrementCount(semaphore, "A");
//        new semaphorePro.DecrementCount(semaphore, "B");

        //CountDownLatchExample


    }
}

class Shared {
    static int count = 0;
}

class IncrementCount {
    String name;
    Semaphore sem;

    public IncrementCount(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
        new Thread(r1).start();
    }

    Runnable r1 = () -> {


        try {
            System.out.println(name+ " waiting for permit");
            sem.acquire();
            System.out.println(name+ " gets permit");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name+ ":"+Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+ " release the permit");
        sem.release();
    };
}

class DecrementCount {
    String name;
    Semaphore sem;

    public DecrementCount(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
        new Thread(r2).start();
    }

    Runnable r2 = () -> {


        try {
            System.out.println(name+ " waiting for permit");
            sem.acquire();
            System.out.println(name+ " gets permit");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name+ ":"+Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+ " release the permit");
        sem.release();
    };
}

