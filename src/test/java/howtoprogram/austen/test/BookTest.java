package howtoprogram.austen.test;

import howtoprogram.austen.Book;
import howtoprogram.austen.Histogram;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class BookTest {

    @Test
    public void blackBooksTest() throws IOException {
        Book book = new Book(Paths.get("src/test/resources/books/BlackBooks.txt"));
        //Three lines of text, several different punctuation marks.
        Histogram histogram = book.histogram();
        Assert.assertEquals(2, histogram.numberOfTimesGiven("the"));
        Assert.assertEquals(2, histogram.numberOfTimesGiven("customer"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("said"));
        Assert.assertEquals(2, histogram.numberOfTimesGiven("that"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("he"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("would"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("like"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("to"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("buy"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("a"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("book"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("it's"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("not"));
        Assert.assertEquals(2, histogram.numberOfTimesGiven("that"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("sort"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("of"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("shop"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("replied"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("bernard"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("so"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("scurried"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("away"));
    }

    @Test
    public void littleBookOfCalmTest() throws IOException {
        Book book = new Book(Paths.get("src/test/resources/books/TheLittleBookOfCalm.txt"));
        //This book has two lines with several repeated words.
        //There is also a blank line. The two non-blank lines end in full stops.
        Histogram histogram = book.histogram();
        Assert.assertEquals(2, histogram.numberOfTimesGiven("this"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("is"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("a"));
        Assert.assertEquals(3, histogram.numberOfTimesGiven("very"));
        Assert.assertEquals(2, histogram.numberOfTimesGiven("short"));
        Assert.assertEquals(2, histogram.numberOfTimesGiven("book"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("we"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("hope"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("that"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("you"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("find"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("calming"));
    }

    @Test
    public void horrorStory() throws IOException {
        Book book = new Book(Paths.get("src/test/resources/books/HorrorStory.txt"));
        //This book has just the single line "It was a dark and stormy night"
        Histogram histogram = book.histogram();
        Assert.assertEquals(7, histogram.allWords().size());
        Assert.assertTrue(histogram.allWords().contains("it"));
        Assert.assertTrue(histogram.allWords().contains("was"));
        Assert.assertTrue(histogram.allWords().contains("a"));
        Assert.assertTrue(histogram.allWords().contains("dark"));
        Assert.assertTrue(histogram.allWords().contains("and"));
        Assert.assertTrue(histogram.allWords().contains("stormy"));
        Assert.assertTrue(histogram.allWords().contains("night"));
    }

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
