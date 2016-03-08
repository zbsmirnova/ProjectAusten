package howtoprogram.austen;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a line of text read in from a book.
 */
public class Line {
    private List<String> words = new ArrayList<>();

    public Line(String text) {
        StringBuilder wordBuilder = new StringBuilder();
        int length = text.length();
        String lowerCase = text.toLowerCase();
        for (int i=0; i<length; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                String finishedWord = wordBuilder.toString();
                words.add(finishedWord);
                wordBuilder = new StringBuilder();
            } else {
                wordBuilder.append(lowerCase.charAt(i));
            }
        }
        words.add(wordBuilder.toString());
    }

    public List<String> words() {
        return words;
    }
}
