package answers.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class S201LambdaInsteadOfAnonClass {

    public S201LambdaInsteadOfAnonClass() {
        rewriteByLambda();
        rewriteByLambdaAnswer1();
        rewriteByLambdaAnswer2();
        rewriteByLambdaAnswer3();
        rewriteByLambdaAnswer4();
    }

    // 2-1 Qusetion Lambda 式で書きかえてみましょう
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

    private void rewriteByLambdaAnswer1() {
        // 匿名クラスを Lambda 式で置き換え
        Comparator<Integer> comparator = (Integer x, Integer y) -> {
                return Integer.compare(x, y);
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

    private void rewriteByLambdaAnswer2() {
        // Lambda 式の引数の型を省略
        // 省略する場合、すべての引数の型を省略する
        // 一部だけ省略することは NG
        Comparator<Integer> comparator = (x, y) -> {
                return Integer.compare(x, y);
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

    private void rewriteByLambdaAnswer3() {
        // メソッドの本体が 1 つの式だけの場合、波カッコと return 文を省略可能
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

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

    private void rewriteByLambdaAnswer4() {
        // メソッドの本体で、他のメソッドコールを行っているだけなので、
        // メソッド参照が使える
        Comparator<Integer> comparator = Integer::compare;

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
