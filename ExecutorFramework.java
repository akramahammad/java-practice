import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(2);
        for(int i=0;i<=5;i++) {
            es.submit(new ExecutorFramework());
        }

        es.shutdown();
    }

    @Override
    public void run() {
        System.out.println("Inside thread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending thread");
    }
}
