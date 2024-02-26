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
                () -> assertEquals(42, element.get())
        );
    }

    @Test
    void previousElementOfEmptyListIsEmptyOptional() {
        assertTrue(this.list.previous().isEmpty());
    }

    @Test
    void previousElementIsLastAddedElement() {
        this.list.add(42);
        var element = this.list.previous();
        assertAll(
                () -> assertTrue(element.isPresent()),
                () -> assertEquals(42, element.get())
        );
    }

    @Test
    void multipleNextOrderIsPreserved() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        assertAll(
                () -> assertEquals(1, this.list.next().get()),
                () -> assertEquals(2, this.list.next().get()),
                () -> assertEquals(3, this.list.next().get())
        );
    }

    @Test
    void multipleNextWraparound() {
        this.list.add(1);
        this.list.add(2);

        assertAll(
                () -> assertEquals(1, this.list.next().get()),
                () -> assertEquals(2, this.list.next().get()),
                () -> assertEquals(1, this.list.next().get())
        );
    }

    @Test
    void multiplePreviousOrderIsPreserved() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        assertAll(
                () -> assertEquals(3, this.list.previous().get()),
                () -> assertEquals(2, this.list.previous().get()),
                () -> assertEquals(1, this.list.previous().get())
        );
    }

    @Test
    void multiplePreviousWraparound() {
        this.list.add(1);
        this.list.add(2);

        assertAll(
                () -> assertEquals(2, this.list.previous().get()),
                () -> assertEquals(1, this.list.previous().get()),
                () -> assertEquals(2, this.list.previous().get())
        );
    }

    @Test
    void backAndForth() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        int val;
        val = this.list.next().get();
        val = this.list.next().get();
        assertEquals(1, this.list.previous().get());
    }

    @Test
    void backAndForthAtBoundaries() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        int val;
        val = this.list.next().get();
        val = this.list.next().get();
        val = this.list.next().get();
        val = this.list.next().get();
        assertEquals(3, this.list.previous().get());
    }

}
