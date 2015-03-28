package questions;

import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.function.Function;

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

        Comparator<Integer> comparator2 = (Integer x, Integer y) -> x - y;

        Comparator<Integer> comparator3 = (x, y) -> x - y;
    }

    private void writeLambda2() {
        Callable<Date> callable1 = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return new Date();
            }
        };

        Callable<Date> callable2 = () -> {
            return new Date();
        };

        Callable<Date> callable3 = () -> new Date();

        Callable<Date> callable4 = Date::new;
        Function<Double, Double> func = (x)-> Double.valueOf(x);
//        Function<Double, Double> func = Double::valueOf;
    }

    private void writeLambda3() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                doSomething();
            }
        };

        Runnable runnable2 = () -> doSomething();
        Runnable runnable3 = this::doSomething;
    }

    private void writeLambda4() {
        Doubler<Double> doubler = new Doubler<Double>() {
            @Override
            public Double doDouble(Double x) {
                return 2.0 * x;
            }
        };
        Doubler<Double> doubler2 = x -> 2.0 * x;
    }

    private void doSomething() {
        System.out.println("Do Somethings");
    }

    public static void main(String... args) {
        new LambdaInsteadOfAnonClass();
    }
}
