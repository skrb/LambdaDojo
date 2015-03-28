package questions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ForEachInsteadOfFor {
    public ForEachInsteadOfFor() {
//        simpleLoop1();
//        simpleLoop2();
        simpleLoop3();
    }
    
    private void simpleLoop1() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        System.out.println(builder.toString());
        
        StringBuilder builder2 = new StringBuilder();
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                builder2.append(t);
            }
        });
        System.out.println(builder2.toString());
    
        StringBuilder builder3 = new StringBuilder();
        strings.forEach(t -> builder3.append(t));
        System.out.println(builder3.toString());

        StringBuilder builder4 = new StringBuilder();
        strings.forEach(builder4::append);
        System.out.println(builder4.toString());
    }
    
        int sum2 = 0;
    private void simpleLoop2() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        int sum = 0;
        for (Integer number: numbers) {
            sum += number;
        }
        System.out.println(sum);

        numbers.forEach(n -> sum2 += n);
        
        System.out.println(sum2);
    }
    
    private void simpleLoop3() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
        
        IntStream.range(0, 10)
                .forEach(n -> System.out.println(n));

        IntStream.range(0, 10)
                .forEach(System.out::println);
    }

    public static void main(String... args) {
        new ForEachInsteadOfFor();
    }
}
