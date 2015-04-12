package answers.section3;

import java.util.Arrays;
import java.util.List;

public class S302ForEachInsteadOfFor {
    public S302ForEachInsteadOfFor() {
        rewriteSimpleLoop();
        rewriteSimpleLoopAnswer1();
    }
    
    private void rewriteSimpleLoop() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        int sum = 0;
        for (Integer number: numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
    
    private int sum = 0;
    private void rewriteSimpleLoopAnswer1() {
        List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
        
        // forEach メソッドで置き換え
        // ローカル変数への再代入ができないため、sum をフィールドで宣言
        // ただし、この方法は外部の変数にアクセスするため、おすすめしない
        // 4 章で扱う Stream API を使用すべきです
        numbers.forEach(number -> {
            sum += number;
        });
        
        System.out.println(sum);
    }

    public static void main(String... args) {
        new S302ForEachInsteadOfFor();
    }
}
