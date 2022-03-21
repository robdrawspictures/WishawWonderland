package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor child;
    Visitor adult;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        child = new Visitor(10, 90, 10.0);
        adult = new Visitor(21, 190, 30.0);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canChargeCorrectly(){
        dodgems.charge(child);
        assertEquals(7.75, child.getMoney(), 0);
        dodgems.charge(adult);
        assertEquals(25.50, child.getMoney(), 0);
    }
}
