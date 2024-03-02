package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.step3.FilteredCircularListImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FilteredCircularListTest {

    private FilteredCircularListImpl list;

    @BeforeEach
    public void initialise() {
        this.list = new FilteredCircularListImpl();
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
        assertTrue(this.list.next().isEmpty());
    }

    @Test
    public void nextElementIsLastAddedElement() {
        this.list.add(42);
        var element = this.list.next();
        assertAll(
                () -> assertTrue(element.isPresent()),
                () -> assertEquals(42, element.get())
        );
    }

    @Test
    public void previousElementOfEmptyListIsEmptyOptional() {
        assertTrue(this.list.previous().isEmpty());
    }

    @Test
    public void previousElementIsLastAddedElement() {
        this.list.add(42);
        var element = this.list.previous();
        assertAll(
                () -> assertTrue(element.isPresent()),
                () -> assertEquals(42, element.get())
        );
    }

    @Test
    public void multipleNextOrderIsPreserved() {
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
    public void multipleNextWraparound() {
        this.list.add(1);
        this.list.add(2);

        assertAll(
                () -> assertEquals(1, this.list.next().get()),
                () -> assertEquals(2, this.list.next().get()),
                () -> assertEquals(1, this.list.next().get())
        );
    }

    @Test
    public void multiplePreviousOrderIsPreserved() {
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
    public void multiplePreviousWraparound() {
        this.list.add(1);
        this.list.add(2);

        assertAll(
                () -> assertEquals(2, this.list.previous().get()),
                () -> assertEquals(1, this.list.previous().get()),
                () -> assertEquals(2, this.list.previous().get())
        );
    }

    @Test
    public void backAndForth() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        int val;
        val = this.list.next().get();
        val = this.list.next().get();
        assertEquals(1, this.list.previous().get());
    }

    @Test
    public void backAndForthAtBoundaries() {
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

    @Test
    public void resetReturnsAtTheBeginningOfTheList() {
        this.list.add(1);
        this.list.add(2);

        this.list.next().get();
        this.list.reset();
        assertEquals(1, this.list.next().get());
    }

    @Test
    public void filterListWithMatchingElements() {
        for(int i = 1; i <= 5; i++) {
            this.list.add(i);
        }
        assertEquals(Optional.of(2), this.list.filteredNext((x) -> x % 2 == 0));
    }

}
