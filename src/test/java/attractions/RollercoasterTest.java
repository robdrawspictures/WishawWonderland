package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor child;
    Visitor manlet;
    Visitor adult;
    Visitor slenderMan;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        child = new Visitor(10, 90, 10.0);
        manlet = new Visitor(21, 120, 10.0);
        adult = new Visitor(18, 190, 10.0);
        slenderMan = new Visitor(21, 201, 30.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRide(){
        rollerCoaster.charge(child);
        assertEquals(10.0, child.getMoney(),0);
        rollerCoaster.charge(manlet);
        assertEquals(10.0, manlet.getMoney(),0.01);
        rollerCoaster.charge(adult);
        assertEquals(1.60, adult.getMoney(),0.01);
        rollerCoaster.charge(slenderMan);
        assertEquals(13.20, slenderMan.getMoney(),0.01);

    }
}
