package java8;

public interface DefaultMethodInterface {
    default void print(){
        System.out.println("Inside default interface method");
    }
    void printOverride();
}
