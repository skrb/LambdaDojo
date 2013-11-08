package answers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamInsteadOfFor {
    
    public StreamInsteadOfFor() {
        simpleStream1();
        simpleStream2();
        processStatistics();
        fileRead("src/StreamInsteadOfFor.java");
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

        int ave = 0;
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
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextDouble());
        }
        
        double ave = 0.0;
        for (Double x: numbers) {
            ave += x;
        }
        ave /= numbers.size();
        
        double div = 0.0;
        for (Double x: numbers) {
            div += (x - ave) * (x -ave);                    
        }
        div /= numbers.size();
        
        // Answer 1
        double ave2 = numbers.stream()
                             .mapToDouble(x -> x)
                             .sum() / numbers.size();
        div = numbers.stream()
                     .mapToDouble(x -> (x - ave2)*(x - ave2))
                     .sum() / numbers.size();
        
        // Answer 2
        double ave3 = numbers.stream()
                             .mapToDouble(x -> x)
                             .average()
                             .getAsDouble();
        
        div = numbers.stream()
                     .mapToDouble(x -> (x - ave3)*(x - ave3))
                     .average()
                     .getAsDouble();
        
        // 乱数の配列を Stream で作る場合
        double[] numbers2 = IntStream.range(0, 101)
                           .mapToDouble(x -> random.nextDouble())
                           .toArray();

        // 乱数のリストを Stream で作る場合 1
        List<Double> numbers3 = IntStream.range(0, 101)
                           .mapToObj(x -> new Double(random.nextDouble()))
                           .collect(Collectors.toList());

        // 乱数のリストを Stream で作る場合 2
        List<Double> numbers4 = IntStream.range(0, 101)
                           .mapToDouble(x -> random.nextDouble())
                           .boxed()
                           .collect(Collectors.toList());
        
        // 乱数のリストを Stream で作る場合 3
        List<Double> numbers5 = DoubleStream.generate(random::nextDouble)
                                            .limit(100)
                                            .boxed()
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
    }

    public static void main(String[] args) { 
        new StreamInsteadOfFor(); 
    }
}
