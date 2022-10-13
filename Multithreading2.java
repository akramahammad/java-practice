
public class Multithreading2 extends Thread{

    static synchronized void syncmethod() throws InterruptedException {
        System.out.println("Inside sync");
        Thread.sleep(2000);
        System.out.println("Ending sync");
    }

    public static void main(String[] args) throws InterruptedException {
         new Multithreading2().start();
        new Multithreading2().start();
        new Multithreading2().start();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Multithreading 2");
        Thread.yield();
        System.out.println("Inside new thread "+ Thread.currentThread().getName());
        try {
            Multithreading2.syncmethod();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("Ending new thread");
    }
}
