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
public void oneWord() {
    Line line = new Line("hello");
    List<String> words = line.words();
    Assert.assertEquals(1, words.size());
    Assert.assertEquals("hello", words.get(0));
}

@Test
public void twoWords() {
    Line line = new Line("hello there");
    List<String> words = line.words();
    Assert.assertEquals(2, words.size());
    Assert.assertEquals("hello", words.get(0));
    Assert.assertEquals("there", words.get(1));
}

@Test
public void doubleSpace() {
    Line line = new Line("a  b");
    List<String> words = line.words();
    Assert.assertEquals(2, words.size());
    Assert.assertEquals("a", words.get(0));
    Assert.assertEquals("b", words.get(1));
}

    @Test
public void wordsAreLowerCase() {
    Line line = new Line("Hello THERE");
    List<String> words = line.words();
    Assert.assertEquals(2, words.size());
    Assert.assertEquals("hello", words.get(0));
    Assert.assertEquals("there", words.get(1));
}

    @Test
    public void repeatedWordsAreIncluded() {
        Line line = new Line("Hello there and hello again");
        List<String> words = line.words();
        Assert.assertEquals(5, words.size());
        Assert.assertEquals("hello", words.get(0));
        Assert.assertEquals("there", words.get(1));
        Assert.assertEquals("and", words.get(2));
        Assert.assertEquals("hello", words.get(3));
        Assert.assertEquals("again", words.get(4));
    }

    @Test
    public void ignorePunctuation() {
        Line line = new Line("Hello. Goodbye! Yes? No, no.");
        List<String> words = line.words();
        Assert.assertEquals(5, words.size());
        Assert.assertEquals("hello", words.get(0));
        Assert.assertEquals("goodbye", words.get(1));
        Assert.assertEquals("yes", words.get(2));
        Assert.assertEquals("no", words.get(3));
        Assert.assertEquals("no", words.get(4));
    }

    @Test
    public void morePunctuation() {
        Line line = new Line("Hello; _Goodbye_!");
        List<String> words = line.words();
        Assert.assertEquals(2, words.size());
        Assert.assertEquals("hello", words.get(0));
        Assert.assertEquals("goodbye", words.get(1));
    }

    @Test
    public void doubleQuotes() {
        Line line = new Line("\"It's not.\"");
        List<String> words = line.words();
        System.out.println("words = " + words);
        Assert.assertEquals(2, words.size());
        Assert.assertEquals("it's", words.get(0));
        Assert.assertEquals("not", words.get(1));
    }
}
