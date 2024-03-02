package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.step2.CircularList;
import tdd.step2.CircularListImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    public void initialise() {
        this.list = new CircularListImpl();
    }

    @Test
    public void newlyCreatedListIsEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    public void addElementIncreasesListLength() {
        this.list.add(42);
        assertEquals(1, this.list.size());
    }

    @Test
    public void nextElementOfEmptyListIsEmptyOptional() {
        assertFalse(this.list.forwardIterator().hasNext());
    }

    @Test
    public void nextElementIsLastAddedElement() {
        this.list.add(42);
        var iterator = this.list.forwardIterator();
        assertAll(
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(42, iterator.next())
        );
    }

    @Test
    public void previousElementOfEmptyListIsEmptyOptional() {
        assertFalse(this.list.backwardIterator().hasNext());
    }

    @Test
    public void previousElementIsLastAddedElement() {
        this.list.add(42);
        var iterator = this.list.backwardIterator();
        assertAll(
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(42, iterator.next())
        );
    }

    @Test
    public void forwardIteratorMultipleNextOrderIsPreserved() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        var iterator = this.list.forwardIterator();

        assertAll(
                () -> assertEquals(1, iterator.next()),
                () -> assertEquals(2, iterator.next()),
                () -> assertEquals(3, iterator.next())
        );
    }

    @Test
    public void forwardIteratorMultipleNextWraparound() {
        this.list.add(1);
        this.list.add(2);

        var iterator = this.list.forwardIterator();

        assertAll(
                () -> assertEquals(1, iterator.next()),
                () -> assertEquals(2, iterator.next()),
                () -> assertEquals(1, iterator.next())
        );
    }

    @Test
    public void backwardsIteratorMultipleNextOrderIsPreserved() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        var iterator = this.list.backwardIterator();

        assertAll(
                () -> assertEquals(3, iterator.next()),
                () -> assertEquals(2, iterator.next()),
                () -> assertEquals(1, iterator.next())
        );
    }

    @Test
    public void backwardsIteratorMultipleNextWraparound() {
        this.list.add(1);
        this.list.add(2);

        var iterator = this.list.backwardIterator();

        assertAll(
                () -> assertEquals(2, iterator.next()),
                () -> assertEquals(1, iterator.next()),
                () -> assertEquals(2, iterator.next())
        );
    }

}
