package multithreading;

public class Deadlock implements Runnable{
    String s1;
    String s2;

    public Deadlock(String s1,String s2){
        this.s1=s1;
        this.s2=s2;
    }

    public static void main(String[] args) {
        new Thread(new Deadlock("Hello","World")).start();
        new Thread(new Deadlock("World","Hello")).start();
    }
    @Override
    public void run() {
        synchronized (s1){
                    System.out.println("Inside first sync");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (s2){
                System.out.println("Inside second sync");
            }
        }
    }
}
