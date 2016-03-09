package howtoprogram.austen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 * Reads a book from a text file and produces word usage information.
 */
public class Book {

    public static void main(String[] args) throws IOException {
        Book book = new Book(Paths.get("src/main/resources/books/PrideAndPrejudice.txt"));
        Histogram histogram = book.histogram();
        Set<String> allWords = histogram.allWords();
        for (String word: allWords) {
            int count = histogram.numberOfTimesGiven(word);
            System.out.println(word + " " + count);
        }
    }

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
