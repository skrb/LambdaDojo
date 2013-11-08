package questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
    }
    
    private void simpleStream2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int ave = 0;
        for (Integer x: numbers) {
            ave += x;
        }
        System.out.println(ave/numbers.size());
    }
    
    private void processStatistics() {
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextDouble());
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

    public static void main(String[] args) { 
        new StreamInsteadOfFor(); 
    }
}
