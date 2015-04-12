package answers.section3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S301ForEachInsteadOfFor {
    public S301ForEachInsteadOfFor() {
        rewriteSimpleLoop();
        rewriteSimpleLoopAnswer1();
        rewriteSimpleLoopAnswer2();
        rewriteSimpleLoopAnswer3();
    }
    
    private void rewriteSimpleLoop() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }

    private void rewriteSimpleLoopAnswer1() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        
        // forEach メソッドで置き換え
        strings.forEach(s -> builder.append(s));

        System.out.println(builder.toString());
    }

    private void rewriteSimpleLoopAnswer2() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        
        // メソッド参照の使用
        strings.forEach(builder::append);
        System.out.println(builder.toString());
    }

    private void rewriteSimpleLoopAnswer3() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        // 参考
        // Stream API を使用した文字列の連結
        // 外部の変数にアクセスしないので、この形式の方が望ましい
        String result = strings.stream()
                               .collect(Collectors.joining());

        System.out.println(result);
    }

    public static void main(String... args) {
        new S301ForEachInsteadOfFor();
    }
}
