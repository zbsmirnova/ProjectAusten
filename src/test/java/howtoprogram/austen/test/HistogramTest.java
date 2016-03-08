package howtoprogram.austen.test;

import howtoprogram.austen.Histogram;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class HistogramTest {

    @Test
    public void emptyToStartWith() {
        Histogram histogram = new Histogram();
        Assert.assertEquals(0, histogram.allWords().size());
    }

    @Test
    public void countIsZeroForWordNotGiven() {
        Histogram histogram = new Histogram();
        Assert.assertEquals(0, histogram.numberOfTimesGiven("xylophone"));
    }

    @Test
    public void recordOneWord() {
        Histogram histogram = new Histogram();
        histogram.record("piano");
        Set<String> words = histogram.allWords();
        Assert.assertEquals(1, words.size());
        Assert.assertTrue(words.contains("piano"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("piano"));
    }

    @Test
    public void recordOneWordTwice() {
        Histogram histogram = new Histogram();
        histogram.record("piano");
        histogram.record("piano");
        Set<String> words = histogram.allWords();
        Assert.assertEquals(1, words.size());
        Assert.assertTrue(words.contains("piano"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("piano"));
    }

    @Test
    public void recordTwoWords() {
        Histogram histogram = new Histogram();
        histogram.record("piano");
        histogram.record("violin");
        Set<String> words = histogram.allWords();
        Assert.assertEquals(2, words.size());
        Assert.assertTrue(words.contains("piano"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("piano"));
        Assert.assertTrue(words.contains("violin"));
        Assert.assertEquals(1, histogram.numberOfTimesGiven("violin"));
    }

}
