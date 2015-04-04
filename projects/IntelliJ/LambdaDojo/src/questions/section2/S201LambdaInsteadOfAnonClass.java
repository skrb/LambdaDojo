package questions.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class S201LambdaInsteadOfAnonClass {

    public S201LambdaInsteadOfAnonClass() {
        rewriteByLambda();
    }

    // 2-1 Lambda 式で書きかえてみましょう
    private void rewriteByLambda() {
        // この匿名クラスを Lambda 式で書きかえ
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = numbers.remove(random.nextInt(10 - i));
            numbers.add(number);
        }

        System.out.println("Before Sort: " + numbers);

        // 整数のリストをソート
        Collections.sort(numbers, comparator);
        System.out.println("After Sort: " + numbers);
    }

    public static void main(String... args) {
        new S201LambdaInsteadOfAnonClass();
    }
}
