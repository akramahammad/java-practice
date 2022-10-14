package streams.io;

import java.io.*;
import java.util.StringTokenizer;

public class Streams {
    public static void main(String[] args) {
        try(
                FileInputStream fis=new FileInputStream(new File("C:/Users/akram/Documents/istock.jpg"));
                FileOutputStream fos=new FileOutputStream(new File("C:/Users/akram/Documents/istock-copy.jpg"));
                FileReader reader=new FileReader(new File("C:/Users/akram/Documents/test.txt"));
                FileWriter writer=new FileWriter(new File("C:/Users/akram/Documents/test-copy.txt"));
                BufferedReader bufferedReader= new BufferedReader(new FileReader(new File("C:/Users/akram/Documents/test1.txt")));
                BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(new File("C:/Users/akram/Documents/test1-copy.txt")));
                ){
            //copying text file using character streams
            int ch;
            while((ch=reader.read())!=-1){
                System.out.print((char) ch);
                writer.write(ch);
            }
            System.out.println(" copy completed");

            //copying image file byte stream
            while((ch=fis.read())!=-1){
                fos.write(ch);
            }
            System.out.println(" copy completed");

            //copying text file using buffer
            String line;
            while((line=bufferedReader.readLine())!=null){
                StringTokenizer tokenizer=new StringTokenizer(line," ");
                while (tokenizer.hasMoreTokens()){
                    System.out.println(tokenizer.nextToken());
                }
                bufferedWriter.write(line);
            }
            System.out.println(" copy completed");
        }
        catch (IOException e){
            System.out.println("Exception occurred");
        }


    }
}
