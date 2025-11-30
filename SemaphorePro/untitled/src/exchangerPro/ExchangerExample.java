package exchangerPro;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static final Exchanger<String> exchanger = new Exchanger<>();
    static void main() {
    Thread t1 = new Thread(()-> {
            exchangeData("Thread1 Sending Data", "Data from thread1");
        });

        Thread t2 = new Thread(()-> {
            exchangeData("Thread2 Sending Data", "Data from thread2");
        });
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void exchangeData(String message, String dataToSend) {

        try {
            System.out.println(message+ " : " +dataToSend);
            String receivedData = exchanger.exchange(dataToSend);
            System.out.println(message+ " : Received - "+receivedData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
