package howtoprogram.austen.test;

import howtoprogram.austen.Book;
import howtoprogram.austen.Histogram;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class BookTest {

    @Test
    public void shortStory() throws IOException {
        Book book = new Book(Paths.get("src/test/resources/books/ShortStory.txt"));
        //This book has just four distinct words, spread over three lines.
        Histogram histogram = book.histogram();
        Assert.assertEquals(4, histogram.allWords().size());
        Assert.assertTrue(histogram.allWords().contains("the"));
        Assert.assertTrue(histogram.allWords().contains("beginning"));
        Assert.assertTrue(histogram.allWords().contains("middle"));
        Assert.assertTrue(histogram.allWords().contains("end"));
    }
}
