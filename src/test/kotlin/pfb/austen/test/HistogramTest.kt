package pfb.austen.test

import org.junit.Assert
import org.junit.Test
import pfb.austen.Histogram

public class HistogramTest {
    @Test
    fun emptyToStartWith() {
        val histogram = Histogram()
        Assert.assertEquals(0, histogram.allWords().size)
    }

    @Test
    fun unknownWord() {
        val histogram = Histogram()
        val given = histogram.numberOfTimesGiven("xylophone")
        Assert.assertEquals(0, given)
    }

    @Test
    fun recordOneWord() {
        val histogram = Histogram()
        histogram.record("piano")
        val words = histogram.allWords()
        Assert.assertEquals(1, words.size)
        Assert.assertTrue(words.contains("piano"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("piano"))
    }

    @Test
    fun recordOneWordTwice() {
        val histogram = Histogram()
        histogram.record("piano")
        histogram.record("piano")
        val words = histogram.allWords()
        Assert.assertEquals(1, words.size)
        Assert.assertTrue(words.contains("piano"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("piano"))
    }

    @Test
    fun recordTwoWords() {
        val histogram = Histogram()
        histogram.record("piano")
        histogram.record("violin")
        val words = histogram.allWords()
        Assert.assertEquals(2, words.size.toLong())
        Assert.assertTrue(words.contains("piano"))
        Assert.assertTrue(words.contains("violin"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("piano"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("violin"))
    }
}