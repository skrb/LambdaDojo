package questions;

import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.Callable;

public class LambdaInsteadOfAnonClass {
    public LambdaInsteadOfAnonClass() {
        writeLambda1();
        writeLambda2();
        writeLambda3();
        writeLambda4();
    }
    
    private void writeLambda1() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        };
    }
    
    private void writeLambda2() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                doSomething();
            }
        };
    }
    
    private void writeLambda3() {
        Callable<Date> callable1 = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return new Date();
            }
        };
    }
    
    private void writeLambda4() {
        Doubler<Double> doubler = new Doubler<Double>() {
            @Override
            public Double doDouble(Double x) {
                return 2.0 * x;
            }
        };
    }
    
    private void doSomething() {
        System.out.println("Do Somethings");
    }
    
    public static void main(String... args) {
        new LambdaInsteadOfAnonClass();
    }
}
