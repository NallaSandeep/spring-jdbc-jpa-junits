package deeplearning.jpa.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertExamples {

    @Test
    public void testAssertEquals() {
        assertEquals("dude", "test", "test");
    }

    @Test
    public void testAssertNull() {
        String str = null;
        assertNull(str, "Should be null");
    }

    @Test
    public void testAssertTrue() {
        boolean str = true;
        assertTrue(true, "Should be true");
    }

    @Test
    public void testAssertAll() {
        assertAll("testAssertAll",
                () -> assertTrue(true),
                () -> assertTrue(false),
                () -> assertEquals("test", "dude", "failed"));
    }

    @Test
    public void testAssertThrows() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Illegal Argument Exception Occurred");
        });
        assertEquals("Illegal Argument Exception Occurred", exception.getMessage());
    }
}
