package questions.section4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S406StreamInsteadOfFor {

    public S406StreamInsteadOfFor() {
        wordCount();
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
            String[] splitedSentence  = sentence.split("[\\.,\\? ]");
            for (String word: splitedSentence) {
                String lowerWord = word.toLowerCase();
                int count = result.getOrDefault(lowerWord, 0);
                result.put(lowerWord, count+1);
            }
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) {
        new S406StreamInsteadOfFor();
    }
}
