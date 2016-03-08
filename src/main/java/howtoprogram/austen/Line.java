package howtoprogram.austen;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a line of text read in from a book.
 */
public class Line {
    private List<String> words = new ArrayList<>();

    public Line(String text) {

    }

    public List<String> words() {
        return words;
    }
}
