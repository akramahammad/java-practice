package multithreading;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Multithreading();
        Multithreading2 m2= new Multithreading2();
        Thread t2=new Thread(m2);
        t2.start();
        t1.start();
        int i=0;
        while(i<1000) System.out.print(" "+i++);
        t1.interrupt();
        System.out.println(" ");
    }
}
