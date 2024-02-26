import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void initialise() {
        this.list = new CircularListImpl();
    }

    @Test
    void newlyCreatedListIsEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void addElementIncreasesListLength() {
        this.list.add(42);
        assertEquals(1, this.list.size());
    }

    @Test
    void nextElementOfEmptyListIsEmptyOptional() {
        assertTrue(this.list.next().isEmpty());
    }

    @Test
    void nextElementIsLastAddedElement() {
        this.list.add(42);
        var element = this.list.next();
        assertAll(
                () -> assertTrue(element.isPresent()),
                () -> assertEquals(42, this.list.next().get())
        );
    }

}
