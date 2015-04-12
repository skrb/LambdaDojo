package answers.section3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class S303ForEachInsteadOfFor {
    public S303ForEachInsteadOfFor() {
        rewriteSimpleLoop();
        rewriteSimpleLoopAnswer1();
        rewriteSimpleLoopAnswer2();
    }
    
    private void rewriteSimpleLoop() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    private void rewriteSimpleLoopAnswer1() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        numbers.forEach(i -> System.out.print(i));
        System.out.println();

        // メソッド参照を使用
        numbers.forEach(System.out::print);
        System.out.println();
    }

    private void rewriteSimpleLoopAnswer2() {

        // int型に対応する IntStream クラスを使用してループを実現
        IntStream.range(0, 10)
                 .forEach(i -> System.out.print(i));
        System.out.println();

        // メソッド参照を使用
        IntStream.range(0, 10)
                 .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String... args) {
        new S303ForEachInsteadOfFor();
    }
}
