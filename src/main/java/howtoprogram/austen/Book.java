package howtoprogram.austen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Reads a book from a text file and produces word usage information.
 */
public class Book {

    private Histogram histogram = new Histogram();

    public Book(Path bookFile) throws IOException {
        List<String> lines = Files.readAllLines(bookFile);
        int numberOfLines = lines.size();
        for (int i=0; i< numberOfLines; i++) {
            Line line = new Line(lines.get(i));
            List<String> wordsInLine = line.words();
            for (int j=0; j<wordsInLine.size(); j++) {
                histogram.record(wordsInLine.get(j));
            }
        }
    }

    public Histogram histogram() {
        return histogram;
    }
}
