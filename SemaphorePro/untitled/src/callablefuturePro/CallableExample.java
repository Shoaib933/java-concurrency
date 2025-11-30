package callablefuturePro;

import java.util.concurrent.*;

public class CallableExample {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        System.out.println("Starting.......");
        Future<Integer> sum = ex.submit(new Sum(10));
        Future<Double> sqr = ex.submit(new SquareRoot(16));
        Future<Integer> fact = ex.submit(new Factorial(5));

        System.out.println("SUMM : "+sum.get());
        System.out.println("square root  : "+sqr.get());
        System.out.println("Factotrial : "+fact.get());

        ex.shutdown();
        System.out.println("ENEDDDD");


    }


}

//sum

class Sum implements Callable<Integer> {


    int stop;

    public Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum =0;
       for (int i=0; i<=stop; i++) {
           sum += stop;
       }
       return sum;
    }
}

//square root

class SquareRoot implements Callable<Double> {


    double  num;

    public SquareRoot(double  num) {
        this.num = num;
    }

    @Override
    public Double call() throws Exception {
      return Math.sqrt(num);
    }
}

//factorial

class Factorial implements Callable<Integer> {


    int stop;

    public Factorial(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int fact =1;
        for (int i=2; i<=stop; i++) {
            fact *= i;
        }
        return fact;
    }
}