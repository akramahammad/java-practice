package multithreading;

import java.util.concurrent.*;

public class CallableImpl implements Callable<String> {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(2);
        Future<String> future1 = es.submit(new CallableImpl());
        Future<String> future2 = es.submit(new CallableImpl());
        Future<String> future3 = es.submit(new CallableImpl());
        try {
//            future1.cancel(true);
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (Exception e) {
            System.out.println("Error in execution");
        }
        System.out.println("Main method");
        es.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hello there!";
    }
}
