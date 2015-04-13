package answers.section4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S402StreamInsteadOfFor {

    public S402StreamInsteadOfFor() {
        sum();
        sumAnswer1();
        sumAnswer2();
        sumAnswer3();
        sumAnswer4();
    }

    private void sum() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0;
        for (Integer x : numbers) {
            sum += x;
        }
        System.out.println(sum);
    }

    private int sum = 0;
    private void sumAnswer1() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 単純に for 文を forEach メソッドに置き換え
        // ただし、外部の変数へのアクセスがあるためお勧めしない
        numbers.stream()
               .forEach(x -> sum += x);

        System.out.println(sum);
    }

    private void sumAnswer2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 加算を reduce メソッドで置き換え
        int sum = numbers.stream()
                         .reduce(0, (x, y) -> x + y);

        System.out.println(sum);
    }

    private void sumAnswer3() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 加算を collect メソッドで置き換え
        // summingInt メソッドの引数には、int型を返すラムダ式を指定する
        // ここでは Integer -> int をオートボクシングで行うので、そのままを返す
        int sum = numbers.stream()
                         .collect(Collectors.summingInt(x -> x));

        System.out.println(sum);
    }

    private void sumAnswer4() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // mapToInt メソッドで Integer クラスのストリームから、int のストリームに変換し
        // IntStream クラスの sum メソッドで合計を算出する
        int sum = numbers.stream()
                         .mapToInt(x -> x)
                         .sum();

        System.out.println(sum);
    }

    public static void main(String[] args) {
        new S402StreamInsteadOfFor();
    }
}
