package questions.section4;

import java.util.Arrays;
import java.util.List;

public class S402StreamInsteadOfFor {

    public S402StreamInsteadOfFor() {
        sum();
    }

    private void sum() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0;
        for (Integer x : numbers) {
            sum += x;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new S402StreamInsteadOfFor();
    }
}
