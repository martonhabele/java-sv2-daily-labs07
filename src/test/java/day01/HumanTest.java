package day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testNameIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Human(null, 1980));
    }

    @Test
    void testYoBIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Human("Géza", 1750));
    }

    @Test
    void testEverythingIsOkay() {
        Human human = new Human("Béla", 1980);
        assertEquals("Béla", human.getName());
        assertEquals(1980, human.getYoB());
    }
}