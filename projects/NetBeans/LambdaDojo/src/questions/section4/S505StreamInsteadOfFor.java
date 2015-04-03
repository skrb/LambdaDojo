package questions.section4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class S505StreamInsteadOfFor {

    public S505StreamInsteadOfFor() {
        fileRead("src/questions/section4/S505StreamInsteadOfFor.java");
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
        new S505StreamInsteadOfFor();
    }
}
