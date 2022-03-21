package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor child;
    Visitor beast;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        child = new Visitor(10, 90, 10.0);
        beast = new Visitor(69, 160, 10.0);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void canKeepOutNonces(){
        assertEquals(false, playground.isAllowed(beast));
        assertEquals(true, playground.isAllowed(child));
    }
}
