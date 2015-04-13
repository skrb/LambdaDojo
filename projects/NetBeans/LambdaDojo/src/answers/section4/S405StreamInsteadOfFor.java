package answers.section4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S405StreamInsteadOfFor {

    public S405StreamInsteadOfFor() {
        fileRead("src/questions/section4/S405StreamInsteadOfFor.java");
        fileReadAnswer1("src/questions/section4/S405StreamInsteadOfFor.java");
        fileReadAnswer2("src/questions/section4/S405StreamInsteadOfFor.java");
        fileReadAnswer3("src/questions/section4/S405StreamInsteadOfFor.java");
    }

    private void fileRead(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = 0;

            for (;;) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String[] words = line.split("[\\.,\\?; ]");
                wordCount += words.length;
            }
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
    }

    private int wordCount = 0;
    private void fileReadAnswer1(String filename) {

        // Files.lines メソッドを使用して、ストリームを生成し
        // forEach メソッドで単語数を数える
        // しかし、wordCount 変数をフィールドとして宣言しなくてはいけないので、お勧めしない
        Path path = Paths.get(filename);
        try (Stream<String> stream = Files.lines(path)) {

            stream.forEach(line -> {
                String[] words = line.split("[\\.,\\?; ]");
                wordCount += words.length;
            });
            
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
    }

    private void fileReadAnswer2(String filename) {

        Path path = Paths.get(filename);
        try (Stream<String> stream = Files.lines(path)) {

            // S404StreamInsteadOfFor と同様に flatMap で単語を切り出し、
            // count メソッドで単語数を数える
            // count メソッドの返り値が long 型であることに注意
            long wordCount = stream.flatMap(line -> Stream.of(line.split("[\\.,\\?; ]")))
                                   .count();
            
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
    }

    private void fileReadAnswer3(String filename) {

        Path path = Paths.get(filename);
        try (Stream<String> stream = Files.lines(path)) {

            // collector メソッドと Collectors.counting メソッドで単語数を数える
            // これも返り値が long 型であることに注意
            long wordCount = stream.flatMap(line -> Stream.of(line.split("[\\.,\\?; ]")))
                                   .collect(Collectors.counting());
            
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
    }

    public static void main(String[] args) {
        new S405StreamInsteadOfFor();
    }
}
