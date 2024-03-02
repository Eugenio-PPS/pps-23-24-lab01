package tdd.step3;

import tdd.CircularList;
import tdd.step1.CircularListImpl;

import java.util.Optional;
import java.util.function.Function;

public final class FilteredCircularListImpl implements CircularList {
    CircularList list = new CircularListImpl();

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return list.next();
    }

    @Override
    public Optional<Integer> previous() {
        return list.previous();
    }

    @Override
    public void reset() {
        list.reset();
    }

    public Optional<Integer> filteredNext(Function<Integer, Boolean> test) {
        Optional<Integer> element = Optional.empty();
        while (element.isEmpty() || !test.apply(element.get())) {
            element = this.next();
        }
        return element;
    }
}
