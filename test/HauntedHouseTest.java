import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HauntedHouseTest {
    //static is making it so this is shared across all the instances
    static HauntedHouse house;

    @BeforeEach
    void setUp() {
         house = new HauntedHouse();
    }

    @Test
    void isGhostPresentTest() {
        boolean presence = house.isGhostPresent(); // actual value
        assertTrue(presence);
    }

    @Test
    void scareAwayGhostTest() {
        boolean presence = house.isGhostPresent(); // actual value before scaring away
        assertTrue(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // value after scare away
        assertFalse(presence);
    }
    @Test
    void scareAwayGhostTestWhenNoGhost() { // second scenario where there is no ghost and we scare anyway
        house = new HauntedHouse(); // new instance of house since last test method messes w ghost
        boolean presence = house.isGhostPresent(); // actual value before scaring away
        assertTrue(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // value after scare away
        assertFalse(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // value after scare away no ghost present
        assertFalse(presence);
    }

    @Test
    void refillCandyBowlPos() {
        house = new HauntedHouse();
        assertEquals(10, house.getCandyCount());
        house.refillCandyBowl(10);
        assertEquals(20, house.getCandyCount());
    }

    @Test
    void refillCandyBowlNeg() {
        house = new HauntedHouse();
        assertEquals(10, house.getCandyCount());
        house.refillCandyBowl(-10);
        assertEquals(0, house.getCandyCount());
    }

    @Test
    void refillCandyBowlNeg2() {
        assertEquals(10, house.getCandyCount());
        house.refillCandyBowl(-1);
        assertEquals(10, house.getCandyCount());
    }

    @Test
    void trickOrTreatTest() {
        assertEquals(10, house.getCandyCount());
        house.trickOrTreat(10);
        assertEquals(0, house.getCandyCount());
    }

    @Test
    void trickOrTreatTestNeg() {
        assertEquals(10, house.getCandyCount());
        house.trickOrTreat(20);
        assertEquals(-10, house.getCandyCount());
    }

    @Test
    void tooManyPeople(){
        house = new HauntedHouse();
        assertEquals(10, house.getCandyCount());
        int remainingCandy = house.trickOrTreat(15);
        assertEquals(0, house.getCandyCount(), "Candy count shouldn't drop below zero");

    }

    @Test
    void getGhostPresence(){
        house = new HauntedHouse();
        house.isGhostPresent(); // initial
        house.scareAwayGhost(); // no more ghost
        house.isGhostPresent(); // check
        house.hauntThem(); // ghost back
        house.isGhostPresent();
    }

    @Test
    void getCandyCount() {
    }

    @Test
    void spookySound() {
        assertEquals("Boo!", house.spookySound());
    }

}