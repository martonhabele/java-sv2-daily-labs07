package day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testNameIsInvalid() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Human(null, 1980));
        assertEquals("Name invalid!", iae.getMessage());
    }

    @Test
    void testYoBIsInvalid() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Human("Géza", 1750));
        assertEquals("Cannot be older than 120!", iae.getMessage());
    }

    @Test
    void testEverythingIsOkay() {
        Human human = new Human("Béla", 1980);
        assertEquals("Béla", human.getName());
        assertEquals(1980, human.getYoB());
    }
}