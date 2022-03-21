import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Visitor adult;
    Dodgems dodgems;
    TobaccoStall tobaccoStall;
    RollerCoaster rollerCoaster;

    @Before
    public void before(){
        themePark = new ThemePark("Wishaw Wonderland");
        dodgems = new Dodgems("Rubber Baby Buggy Bumpers", 5);
        rollerCoaster = new RollerCoaster("The Big Dipper", 8);
        tobaccoStall = new TobaccoStall("Drum & Monkey", 9, "Mr Nice", ParkingSpot.A1);
        adult = new Visitor(21, 190, 30.0);
    }

    @Test
    public void canGetAttractCount(){
        assertEquals(0, themePark.getAttractCount());
    }

    @Test
    public void canAddAttraction(){
        themePark.addAttraction(dodgems);
        assertEquals(1, themePark.getAttractCount());
    }

    @Test
    public void canRegisterVisits(){
        themePark.addAttraction(dodgems);
        themePark.visit(adult, dodgems);
        assertEquals(1, adult.numAttVisited());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canHashReviews(){
        themePark.addAttraction(dodgems);
        themePark.addAttraction(rollerCoaster);
        themePark.addStall(tobaccoStall);
        themePark.createReviewHash();
        System.out.println(themePark.getReviews());
        assertEquals(3, themePark.getHashSize());
    }
}
