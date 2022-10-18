package java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {

    public static void main(String[] args) {
        //lamba expression to express functional interfaces
        FunctionalInterfaces fs=(a,b)->{
            System.out.println("Implementing abstract method add, sum = "+(a+b));
        };
        fs.add(4,5);

        //If any class overrides default method, then it should be public and not default
        DefaultMethodInterface di=()-> System.out.println("Hello");
        di.print();
        di.printOverride();

        //FI that returns boolean and takes an arg
        Predicate<Integer> p =(i)-> i>20;
        Predicate<Integer> p1 =(i)-> i%2==0;
        System.out.println(p.and(p1).test(21));

        //Function - FI that takes arg and returns value
        Function<String,Integer> f= s -> s.length();
        System.out.println(f.apply("hello"));

        //Method Referencing - only parameter needs to be same for class and interface
        FunctionalInterfaces fs2=LambdaExpressions::myMethod;
        fs2.add(7,9);

        //Constructor referencing
        ConstructorInterface ci=LambdaExpressions::new;
        ci.getInstance("from constructor referencing");
    }

    static int myMethod(int a, int b){
        System.out.println("Inside myMethod"+(a+b));
        return a+b;
    }

    public LambdaExpressions (String s){
        System.out.println("Inside constructor "+s);
    }
}
