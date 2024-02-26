package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> storage;

    public CircularListImpl() {
        this.storage = new ArrayList<Integer>();
    }

    @Override
    public void add(int element) {
        this.storage.add(element);
    }

    @Override
    public int size() {
        return this.storage.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
