package answers.section4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S404StreamInsteadOfFor {

    public S404StreamInsteadOfFor() {
        splitSentences();
        splitSentencesAnswer1();
        splitSentencesAnswer2();
        splitSentencesAnswer3();
        splitSentencesAnswer4();
    }

    private void splitSentences() {
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

        Set<String> words = new HashSet<>();
        for (String sentence : sentences) {
            String[] splitedSentence = sentence.split("[\\.,\\? ]");
            for (String word : splitedSentence) {
                words.add(word.toLowerCase());
            }
        }

        System.out.println(words);
    }

    private void splitSentencesAnswer1() {
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

        Set<String> words = new HashSet<>();

        // 単純に forEach メソッドで置き換え
        sentences.stream()
                 .forEach(sentence -> {
                     String[] splitedSentence = sentence.split("[\\.,\\? ]");
                     for (String word : splitedSentence) {
                         words.add(word.toLowerCase());
                     }
                 });

        System.out.println(words);
    }

    private void splitSentencesAnswer2() {
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

        Set<String> words = new HashSet<>();

        // 行から単語を切り出す処理を map メソッドで行う
        // しかし、forEach メソッド内で、for 文を使用しているのが美しくない
        sentences.stream()
                 .map(sentence -> sentence.split("[\\.,\\? ]"))
                 .forEach(splitedSentence -> {
                     for (String word : splitedSentence) {
                         words.add(word.toLowerCase());
                     }
                 });

        System.out.println(words);
    }

    private void splitSentencesAnswer3() {
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

        Set<String> words = new HashSet<>();

        // 行から単語を切り出す処理を flatMap メソッドで行う
        // flatMap メソッドを使用することで、forEach メソッド内のループを消すことができる
        sentences.stream()
                 .flatMap(sentence -> Stream.of(sentence.split("[\\.,\\? ]")))
                 .forEach(word ->words.add(word.toLowerCase()));

        System.out.println(words);
    }

    private void splitSentencesAnswer4() {
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

        // collect メソッドと Collectors.toSet メソッドを使用することで、
        // 外部変数へのアクセスをなくすことが可能
        Set<String> words = sentences.stream()
                                     .flatMap(sentence -> Stream.of(sentence.split("[\\.,\\? ]")))
                                     .map(word -> word.toLowerCase())
                                     .collect(Collectors.toSet());

        System.out.println(words);
    }

    public static void main(String[] args) {
        new S404StreamInsteadOfFor();
    }
}
