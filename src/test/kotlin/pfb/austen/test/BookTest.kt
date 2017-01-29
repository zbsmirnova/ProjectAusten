package pfb.austen.test

import org.junit.Assert
import org.junit.Test
import pfb.austen.Book
import java.nio.file.Paths

class BookTest {
    @Test fun shortStory() {
        val book = Book(Paths.get("src/test/resources/books/ShortStory.txt"))
        val histogram = book.histogram()
        val allWords = histogram.allWords()

        Assert.assertEquals(4, allWords.size)

        Assert.assertTrue(allWords.contains("the"))
        Assert.assertTrue(allWords.contains("beginning"))
        Assert.assertTrue(allWords.contains("middle"))
        Assert.assertTrue(allWords.contains("end"))

        Assert.assertEquals(3, histogram.numberOfTimesGiven("the"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("beginning"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("middle"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("end"));
    }

    @Test fun horrorStory() {
        val book = Book(Paths.get("src/test/resources/books/HorrorStory.txt"))
        val histogram = book.histogram()
        val allWords = histogram.allWords()

        Assert.assertEquals(7, allWords.size)

        Assert.assertTrue(allWords.contains("it"))
        Assert.assertTrue(allWords.contains("was"))
        Assert.assertTrue(allWords.contains("a"))
        Assert.assertTrue(allWords.contains("and"))
        Assert.assertTrue(allWords.contains("stormy"))
        Assert.assertTrue(allWords.contains("night"))
        Assert.assertTrue(allWords.contains("dark"))

        Assert.assertEquals(1, histogram.numberOfTimesGiven("it"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("was"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("a"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("dark"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("and"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("stormy"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("night"));
    }

    @Test
    fun littleBookOfCalmTest() {
        val book = Book(Paths.get("src/test/resources/books/TheLittleBookOfCalm.txt"))
        //This book has two lines with several repeated words.
        //There is also a blank line.
        //The two non-blank lines end in full stops.
        val histogram = book.histogram()
        Assert.assertEquals(2, histogram.numberOfTimesGiven("this"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("is"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("a"))
        Assert.assertEquals(3, histogram.numberOfTimesGiven("very"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("short"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("book"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("we"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("hope"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("that"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("you"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("find"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("calming"))
    }
}