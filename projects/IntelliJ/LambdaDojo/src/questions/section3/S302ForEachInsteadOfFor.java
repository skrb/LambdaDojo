package questions.section3;

import java.util.Arrays;
import java.util.List;

public class S302ForEachInsteadOfFor {
    public S302ForEachInsteadOfFor() {
        rewriteSimpleLoop();
    }
    
    private void rewriteSimpleLoop() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        int sum = 0;
        for (Integer number: numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
    
    public static void main(String... args) {
        new S302ForEachInsteadOfFor();
    }
}
