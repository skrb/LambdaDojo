package answers.section2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class S204LambdaInsteadOfAnonClass {

    public S204LambdaInsteadOfAnonClass() {
        rewriteByLambda();
        rewriteByLambdaAnswer1();
        rewriteByLambdaAnswer2();
        rewriteByLambdaAnswer3();
    }

    // 2-4 Lambda 式で書きかえてみましょう
    private void rewriteByLambda() {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String word) {
                return word.length();
            }
        };

        List<String> words = Arrays.asList("one thing was certain that the white kitten had had nothing to do with it".split(" "));
        double average = 0.0;
        for (String word : words) {
            average += function.apply(word);
        }
        average /= words.size();
        System.out.println("Average: " + average);
    }

    private void rewriteByLambdaAnswer1() {
        // Lambda 式で置き換え
        // 引数の型は省略
        // また 1 式なので、波カッコと return 文も省略
        Function<String, Integer> function = (word) -> word.length();

        List<String> words = Arrays.asList("one thing was certain that the white kitten had had nothing to do with it".split(" "));
        double average = 0.0;
        for (String word : words) {
            average += function.apply(word);
        }
        average /= words.size();
        System.out.println("Average: " + average);
    }

    private void rewriteByLambdaAnswer2() {
        // 引数が 1 つなので、丸カッコも省略
        Function<String, Integer> function = word -> word.length();

        List<String> words = Arrays.asList("one thing was certain that the white kitten had had nothing to do with it".split(" "));
        double average = 0.0;
        for (String word : words) {
            average += function.apply(word);
        }
        average /= words.size();
        System.out.println("Average: " + average);
    }

    private void rewriteByLambdaAnswer3() {
        // メソッド参照を使用
        Function<String, Integer> function = String::length;

        List<String> words = Arrays.asList("one thing was certain that the white kitten had had nothing to do with it".split(" "));
        double average = 0.0;
        for (String word : words) {
            average += function.apply(word);
        }
        average /= words.size();
        System.out.println("Average: " + average);
    }

    public static void main(String... args) {
        new S204LambdaInsteadOfAnonClass();
    }
}
