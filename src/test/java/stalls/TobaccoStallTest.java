package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor child;
    Visitor old;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", 5, "Jack Jarvis", ParkingSpot.B1);
        child = new Visitor(10, 90, 10.0);
        old = new Visitor(69, 160, 50.0);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void canRestrictSale(){
        tobaccoStall.sellBaccy(child);
        assertEquals(10.0, child.getMoney(), 0);
        tobaccoStall.sellBaccy(old);
        assertEquals(45.0, old.getMoney(), 0);
    }
}
