import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(0, this.list.size());
    }

    @Test
    void addElementIncreasesListLength() {
        this.list.add(42);
        assertEquals(1, this.list.size());
    }


}
