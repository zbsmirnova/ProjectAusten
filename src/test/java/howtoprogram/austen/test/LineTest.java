package howtoprogram.austen.test;

import howtoprogram.austen.Line;
import org.junit.Assert;
import org.junit.Test;

public class LineTest {
    @Test
    public void testEmpty() {
        Line line = new Line("");
        Assert.assertEquals(0, line.words().size());
    }
}
