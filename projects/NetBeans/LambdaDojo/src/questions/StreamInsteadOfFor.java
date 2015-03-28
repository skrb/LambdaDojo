package questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamInsteadOfFor {

    public StreamInsteadOfFor() {
        simpleStream1();
        simpleStream2();
        processStatistics();
        splitSentences();
        fileRead("src/StreamInsteadOfFor.java");
        wordCount();
    }

    private void simpleStream1() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer x : numbers) {
            if (x % 2 == 0) {
                System.out.print(x);
            }
        }
        System.out.println();
    }

    private void simpleStream2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double ave = 0.0;
        for (Integer x : numbers) {
            ave += x;
        }
        System.out.println(ave / numbers.size());
    }

    private void processStatistics() {
        // 乱数のリストを作成
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextDouble());
        }
        
        // 平均を算出
        double ave = 0.0;
        for (Double x : numbers) {
            ave += x;
        }
        ave /= numbers.size();

        // 分散を算出
        double div = 0.0;
        for (Double x : numbers) {
            div += (x - ave) * (x - ave);
        }
        div /= numbers.size();
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
        
        List<String> words = new ArrayList<>();
        for (String sentence: sentences) {
            String[] splitedSentence  = sentence.split(" ");
            for (String word: splitedSentence) {
                words.add(word.toLowerCase());
            }
        }
    }

    private void fileRead(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = 0;

            for (;;) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String[] words = line.split(" ");
                wordCount += words.length;
            }
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
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
        for (String sentence: sentences) {
            String[] splitedSentence  = sentence.split(" ");
            for (String word: splitedSentence) {
                String lowerWord = word.toLowerCase();
                int count = result.getOrDefault(lowerWord, 0);
                result.put(lowerWord, count+1);
            }
        }
    }

    public static void main(String[] args) {
        new StreamInsteadOfFor();
    }
}
