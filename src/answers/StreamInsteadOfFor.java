package answers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        for (Integer x: numbers) {
            if (x % 2 == 0) {
                System.out.print(x);
            }
        }
        System.out.println();
        
        // Answer 1
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .forEach(x -> System.out.print(x));
        System.out.println();
        
        // Answer 2
        numbers.stream()
               .filter(x -> x % 2 == 0)
               .forEach(System.out::print);
        System.out.println();
        
        // Answer 3
        IntStream.range(0, 11)
                 .filter(x -> x % 2 == 0)
                 .forEach(System.out::print);
        System.out.println();
    }
    
    private void simpleStream2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double ave = 0.0;
        for (Integer x: numbers) {
            ave += x;
        }
        System.out.println(ave/numbers.size());
        
        // Answer 1
        ave = numbers.stream()
                     .reduce(0, (x, y) -> x + y);
        System.out.println(ave/numbers.size());

        // Answer 2
        ave = numbers.stream()
                     .mapToInt(x -> x)
                     .reduce(0, (x, y) -> x + y);
        System.out.println(ave/numbers.size());

        // Answer 3
        ave = numbers.stream()
                     .mapToInt(x -> x)
                     .sum();
        System.out.println(ave/numbers.size());
        
        // Answer 4
        ave = IntStream.range(0, 11)
                       .reduce(0, (x, y) -> x + y);
        System.out.println(ave/numbers.size());
                
        // Answer 5
        ave = IntStream.range(0, 11)
                       .sum();
        System.out.println(ave/numbers.size());
        
        // Answer 5
        IntStream.range(0, 11)
                 .average().ifPresent(System.out::println);
    }
    
    private void processStatistics() {
        // 乱数のリストを作成
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextDouble());
        }

        // Answer 1 乱数の配列を Stream で作成
        double[] numbers2 = IntStream.range(0, 100)
                           .mapToDouble(x -> random.nextDouble())
                           .toArray();

        // Answer 2 乱数のリストを Stream で作成
        List<Double> numbers3 = IntStream.range(0, 100)
                           .mapToObj(x -> random.nextDouble())
                           .collect(Collectors.toList());

        // Answer 3 乱数のリストを Stream で作成 2
        List<Double> numbers4 = IntStream.range(0, 100)
                           .mapToDouble(x -> random.nextDouble())
                           .boxed()
                           .collect(Collectors.toList());
        
        // Answer 4 乱数のリストを Stream で作る場合 3
        List<Double> numbers5 = DoubleStream.generate(() -> random.nextDouble())
                                            .limit(100)
                                            .boxed()
                                            .collect(Collectors.toList());

        List<Double> numbers6 = DoubleStream.generate(random::nextDouble)
                                            .limit(100)
                                            .boxed()
                                            .collect(Collectors.toList());

        // 平均を算出
        double ave = 0.0;
        for (Double x: numbers) {
            ave += x;
        }
        ave /= numbers.size();
        
        // Answer 1
        ave = numbers.stream()
                     .reduce(0.0, (previous, present) -> previous + present) / numbers.size();

        // Answer 2 オートボクシングを減らす
        ave = numbers.stream()
                     .mapToDouble(x -> x)
                     .reduce(0.0, (previous, present) -> previous + present) / numbers.size();

        // Answer 3 プリミティブ型に対応したストリームにのみ定義されたメソッドを使用
        ave = numbers.stream()
                     .mapToDouble(x -> x)
                     .sum() / numbers.size();
        
        // Answer 4
        ave = numbers.stream()
                     .mapToDouble(x -> x)
                     .average()
                     .getAsDouble();
        
        // Answer 5 collectを使用
        ave = numbers.stream()
                     .collect(Collectors.reducing(0.0, (previous, present) -> previous + present))
                      / numbers.size();

        // Answer 5 collectを使用
        ave = numbers.stream()
                     .collect(Collectors.averagingDouble(x -> x));

        // 分散を算出
        double div = 0.0;
        for (Double x: numbers) {
            div += (x - ave) * (x -ave);                    
        }
        div /= numbers.size();

        // 実質的finalのave2を定義しておく
        double ave2 = ave;
        
        // Answer 1
        div = numbers.stream()
                     .map(x -> (x - ave2)*(x - ave2))
                     .reduce(0.0, (prev, pres) -> prev + pres) / numbers.size();
        
        // Answer 2
        div = numbers.stream()
                     .mapToDouble(x -> (x - ave2)*(x - ave2))
                     .reduce(0.0, (prev, pres) -> prev + pres) / numbers.size();
        
        // Answer 3
        div = numbers.stream()
                     .mapToDouble(x -> (x - ave2)*(x - ave2))
                     .sum() / numbers.size();

        // Answer 4
        div = numbers.stream()
                     .mapToDouble(x -> (x - ave2)*(x - ave2))
                     .average()
                     .getAsDouble();
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
        
        // Answer
        words = sentences.stream()
                         .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                         .map(w -> w.toLowerCase())
                         .collect(Collectors.toList());
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
        
        // Answer 1
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = reader.lines()            
                                  .mapToInt(l -> l.split(" ").length)
                                  .reduce(0, (x, y) -> x + y);
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }        

        // Answer 2
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = reader.lines()            
                                  .mapToInt(l -> l.split(" ").length)
                                  .sum();
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }        
        
        // Answer 3
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = reader.lines()            
                                  .flatMap(l -> Arrays.stream(l.split(" ")))
                                  .mapToInt(w -> 1)
                                  .sum();
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }        

        // Answer 4
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = (int)reader.lines()            
                                       .flatMap(l -> Arrays.stream(l.split(" ")))
                                       .count();
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }        
        
        // Answer 4
        // NIO.2 Path & Files を使用する
        try {
            Files.lines(Paths.get(filename))
                 .flatMap(l -> Arrays.stream(l.split(" ")))
                 .count();
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
        
        // Answer 1
        Map<String, Integer> result1 = new HashMap<>();
        sentences.stream()
                 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                 .map(word -> word.toLowerCase())
                 .forEach(word -> {
                     int count = result1.getOrDefault(word, 0);
                     result.put(word, count);
                 });
        
        // Answer 2
        Map<String, Integer> result2 = new HashMap<>();
        sentences.stream()
                 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                 .map(word -> word.toLowerCase())
                 .collect(Collectors.groupingBy(word -> word))
                 .entrySet()
                 .stream()
                 .forEach(entry -> result2.put(entry.getKey(), entry.getValue().size()));

        // Answer 3
        Map<String, Integer> result4 = sentences.stream()
                 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                 .map(word -> word.toLowerCase())
                 .collect(Collectors.groupingBy(word -> word))
                 .entrySet()
                 .stream()
                 .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().size()));

        // Answer 4
        Map<String, Integer> result3 = sentences.stream()
                 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                 .map(word -> word.toLowerCase())
                 .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));
    }
    
    public static void main(String[] args) { 
        new StreamInsteadOfFor(); 
    }
}
