package reflection;

@MyAnnotation(value = "val1",value2 = "val2")
public class Test {

    private int t1;
    private int t2;

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public Test(){
        System.out.println("Default constructor");
    }

    public Test(int s1,int s2){
        this.t1=t1;
        this.t2=t2;
    }

    public String getMessage(){
        return "Hello";
    }

}
