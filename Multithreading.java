
public class Multithreading extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Multithreading();
        System.out.println("Creating new thread t1");
        t1.start();
//        t1.join();
        for(int i=0;i<100;i++){
            System.out.print(i + " ");
        }
        System.out.println("Ending main");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Multithreading 1");
        Thread.yield();
        System.out.println("Inside new thread "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("Ending new thread");
    }
}
