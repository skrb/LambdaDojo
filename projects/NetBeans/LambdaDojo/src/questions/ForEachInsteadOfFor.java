package questions;

import java.util.Arrays;
import java.util.List;

public class ForEachInsteadOfFor {
    public ForEachInsteadOfFor() {
        simpleLoop1();
        simpleLoop2();
        simpleLoop3();
    }
    
    private void simpleLoop1() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }
    
    private void simpleLoop2() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        int sum = 0;
        for (Integer number: numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
    
    private void simpleLoop3() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String... args) {
        new ForEachInsteadOfFor();
    }
}
