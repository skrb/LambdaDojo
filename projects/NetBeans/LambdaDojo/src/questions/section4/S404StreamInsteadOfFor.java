package questions.section4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S404StreamInsteadOfFor {

    public S404StreamInsteadOfFor() {
        splitSentences();
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
        for (String sentence: sentences) {
            String[] splitedSentence  = sentence.split("[\\.,\\? ]");
            for (String word: splitedSentence) {
                words.add(word.toLowerCase());
            }
        }
        
        System.out.println(words);
    }

    public static void main(String[] args) {
        new S404StreamInsteadOfFor();
    }
}
