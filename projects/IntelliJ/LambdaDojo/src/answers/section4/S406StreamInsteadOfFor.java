package answers.section4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S406StreamInsteadOfFor {

    public S406StreamInsteadOfFor() {
        wordCount();
        wordCountAnswer1();
        wordCountAnswer2();
        wordCountAnswer3();
        wordCountAnswer4();
    }

    private void wordCount() {
        List<String> sentences = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers.",
                "A peck of pickled peppers",
                "Peter Piper picked. ",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked? "
        );

        Map<String, Integer> result = new HashMap<>();
        for (String sentence : sentences) {
            String[] splitedSentence = sentence.split("[\\.,\\? ]");
            for (String word : splitedSentence) {
                String lowerWord = word.toLowerCase();
                int count = result.getOrDefault(lowerWord, 0);
                result.put(lowerWord, count + 1);
            }
        }

        System.out.println(result);
    }

    private void wordCountAnswer1() {
        List<String> sentences = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers.",
                "A peck of pickled peppers",
                "Peter Piper picked. ",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked? "
        );

        Map<String, Integer> result = new HashMap<>();

        // 単純に forEach メソッドで置き換え
        sentences.stream()
                 .forEach(sentence -> {
                     String[] splitedSentence = sentence.split("[\\.,\\? ]");
                     for (String word : splitedSentence) {
                         String lowerWord = word.toLowerCase();
                         int count = result.getOrDefault(lowerWord, 0);
                         result.put(lowerWord, count + 1);
                     }
                 });

        System.out.println(result);
    }

    private void wordCountAnswer2() {
        List<String> sentences = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers.",
                "A peck of pickled peppers",
                "Peter Piper picked. ",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked? "
        );

        Map<String, Integer> result = new HashMap<>();

        // 単語の切り出しを flatMap メソッドで行う
        sentences.stream()
                 .flatMap(sentence -> Stream.of(sentence.split("[\\.,\\? ]")))
                 .forEach(word -> {
                         String lowerWord = word.toLowerCase();
                         int count = result.getOrDefault(lowerWord, 0);
                         result.put(lowerWord, count + 1);
                 });

        System.out.println(result);
    }

    private void wordCountAnswer3() {
        List<String> sentences = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers.",
                "A peck of pickled peppers",
                "Peter Piper picked. ",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked? "
        );

        Map<String, Integer> result = new HashMap<>();

        // map メソッドで単語を小文字に変換
        sentences.stream()
                 .flatMap(sentence -> Stream.of(sentence.split("[\\.,\\? ]")))
                 .map(word -> word.toLowerCase())
                 .forEach(word -> {
                         int count = result.getOrDefault(word, 0);
                         result.put(word, count + 1);
                 });

        System.out.println(result);
    }

    private void wordCountAnswer4() {
        List<String> sentences = Arrays.asList(
                "Peter Piper picked",
                "a peck of pickled peppers.",
                "A peck of pickled peppers",
                "Peter Piper picked. ",
                "If Peter Piper picked",
                "a peck of pickled peppers,",
                "Where's the peck of pickled peppers",
                "Peter Piper picked? "
        );

        // collect メソッドと Collectors.groupingBy メソッドでマップを作成
        // groupingBy メソッドの第 1 引数のラムダ式でマップのキーを返すようにする
        // 第 2 引数のメソッドでは、同じキーの集合に対する処理を記述する
        Map<String, Long> result
                = sentences.stream()
                           .flatMap(sentence -> Stream.of(sentence.split("[\\.,\\? ]")))
                           .map(word -> word.toLowerCase())
                           .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(result);
    }

    public static void main(String[] args) {
        new S406StreamInsteadOfFor();
    }
}
