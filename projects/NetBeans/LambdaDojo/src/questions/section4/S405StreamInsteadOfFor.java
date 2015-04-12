package questions.section4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class S405StreamInsteadOfFor {

    public S405StreamInsteadOfFor() {
        fileRead("src/questions/section4/S405StreamInsteadOfFor.java");
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

    public static void main(String[] args) {
        new S405StreamInsteadOfFor();
    }
}
