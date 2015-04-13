package answers.section4;

import java.util.Arrays;
import java.util.List;

public class S401StreamInsteadOfFor {

    public S401StreamInsteadOfFor() {
        filterEven();
        filterEvenAnswer1();
        filterEvenAnswer2();
        filterEvenAnswer3();
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

    private void filterEvenAnswer1() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Stream API で置き換え
        // filter メソッドのラムダ式には if 文の条件をそのまま使用する
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    private void filterEvenAnswer2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // map メソッドを使用して Integer から、後ろに空白を追加した文字列へ変換
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .map(x -> x + " ")
               .forEach(text -> System.out.print(text));
        System.out.println();
    }

    private void filterEvenAnswer3() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // メソッド参照を使用
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .map(x -> x + " ")
               .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        new S401StreamInsteadOfFor();
    }
}
