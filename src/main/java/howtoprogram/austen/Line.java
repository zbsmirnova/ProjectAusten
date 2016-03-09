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
            if (isWordTerminator(c)) {
                addWord(wordBuilder);
                wordBuilder = new StringBuilder();
            } else {
                wordBuilder.append(lowerCase.charAt(i));
            }
        }
        addWord(wordBuilder);
    }

    public List<String> words() {
        return words;
    }

    private void addWord(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            words.add(stringBuilder.toString());
        }
    }

    private boolean isWordTerminator(char c) {
        if (c == ' ') return true;
        if (c == '.') return true;
        if (c == ',') return true;
        if (c == '!') return true;
        if (c == '?') return true;
        if (c == '\"') return true;
        if (c == '_') return true;
        if (c == ';') return true;
        return false;
    }
}
