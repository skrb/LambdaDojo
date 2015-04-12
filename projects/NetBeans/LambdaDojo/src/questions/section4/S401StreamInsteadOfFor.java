package questions.section4;

import java.util.Arrays;
import java.util.List;

public class S401StreamInsteadOfFor {

    public S401StreamInsteadOfFor() {
        filterEven();
    }

    private void filterEven() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer x : numbers) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new S401StreamInsteadOfFor();
    }
}
