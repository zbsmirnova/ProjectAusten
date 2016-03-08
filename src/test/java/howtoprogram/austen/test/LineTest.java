package howtoprogram.austen.test;

import howtoprogram.austen.Line;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LineTest {
    @Test
    public void testEmpty() {
        Line line = new Line("");
        Assert.assertEquals(0, line.words().size());
    }

    @Test
    public void testOneWord() {
        Line line = new Line("hello");
        List<String> words = line.words();
        Assert.assertEquals(1, words.size());
        Assert.assertEquals("hello", words.get(0));
    }
}
