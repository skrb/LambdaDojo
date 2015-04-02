package questions.section2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class S204LambdaInsteadOfAnonClass {

    public S204LambdaInsteadOfAnonClass() {
        rewriteByLambda();
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
        for (String word: words) {
            average += function.apply(word);
        }
        average /= words.size();
        System.out.println("Average: " + average);
    }

    public static void main(String... args) {
        new S204LambdaInsteadOfAnonClass();
    }
}
