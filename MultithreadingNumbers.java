import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultithreadingNumbers implements Runnable{

    int remainder;
    static int index=0;
    List<Integer> numbers;

    public static void main(String[] args)  {

        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        new Thread(new MultithreadingNumbers(numbers,0)).start();
        new Thread(new MultithreadingNumbers(numbers,1)).start();
        new Thread(new MultithreadingNumbers(numbers,2)).start();

    }

    public MultithreadingNumbers(List<Integer> numbers,int remainder){
        this.numbers=numbers;
        this.remainder=remainder;
    }

    @Override
    public void run() {
        synchronized (numbers) {
            while (index<=numbers.size()-1) {
                if (numbers.get(index) % 3 == remainder) {
                    System.out.println("Thread t"+remainder+" :: "+numbers.get(index));
                    index++;
                    numbers.notifyAll();
                } else {
                    try {
                        numbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
