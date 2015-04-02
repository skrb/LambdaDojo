package questions.section3;

import java.util.Arrays;
import java.util.List;

public class S301ForEachInsteadOfFor {
    public S301ForEachInsteadOfFor() {
        rewriteSimpleLoop();
    }
    
    private void rewriteSimpleLoop() {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }

    public static void main(String... args) {
        new S301ForEachInsteadOfFor();
    }
}
