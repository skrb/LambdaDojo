package answers;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachInsteadOfFor {
    public ForEachInsteadOfFor() {
        simpleLoop1();
        simpleLoop2();
        simpleLoop3();
    }
    
    int sum2 = 0;

    private void simpleLoop1() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        System.out.println(builder.toString());

        // Answer
        
        StringBuilder builder2 = new StringBuilder();
        strings.forEach(s -> builder2.append(s));
        System.out.println(builder2.toString());
    }
    
    private void simpleLoop2() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        int sum = 0;
        for (Integer number: numbers) {
            sum += number;
        }
        System.out.println(sum);

        // Answer
        
        numbers.forEach(n -> sum2 += n);
        System.out.println(sum2);
    }
    
    private void simpleLoop3() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
        
        // Answer 1
        
        IntStream.range(0, 10).forEach(i -> System.out.print(i));
        System.out.println();
        
        // Answer 2

        IntStream.range(0, 10).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String... args) {
        new ForEachInsteadOfFor();
    }
}
