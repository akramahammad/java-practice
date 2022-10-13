import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MultiReaderWriter{

    int remainder;
    static int index=0;
    List<Integer> numbers;

    public static void main(String[] args)  {

        List<Integer> numbers= new ArrayList<>();

        Runnable reader=new Runnable() {
            @Override
            public void run() {
                Date date=new Date();
                synchronized (numbers){
                    while(new Date().getSeconds()-date.getSeconds()<=1){
                        while (numbers.isEmpty()){
                            try {
                                numbers.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Reader"+Thread.currentThread().getName()+" :: "+numbers.get(numbers.size()-1));
                        numbers.remove(numbers.size()-1);
                        numbers.notifyAll();
                    }


                }
            }
        };


        Runnable writer=new Runnable() {
            @Override
            public void run() {
                Date date=new Date();
                synchronized (numbers){
                    while(new Date().getSeconds()-date.getSeconds()<=1){
                        while (numbers.size()>=10){
                            try {
                                numbers.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (numbers.isEmpty()) numbers.add(1);
                        else numbers.add(numbers.get(numbers.size()-1)+1);

                        System.out.println("Writer "+Thread.currentThread().getName()+" :: "+numbers.get(numbers.size()-1));
                        numbers.notifyAll();

                    }


                }
            }
        };

        Thread r1=new Thread(reader);
        r1.start();
        new Thread(reader).start();
        new Thread(reader).start();
        new Thread(writer).start();
        new Thread(writer).start();
        new Thread(writer).start();
    }

}
