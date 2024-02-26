package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> storage;
    private int position = -1;

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

    private Optional<Integer> skip(int skip) {
        if(this.isEmpty()) {
            return Optional.empty();
        } else {
            this.position = (this.position + skip) % this.size();
            return Optional.of(this.storage.get(this.position));
        }

    }

    @Override
    public Optional<Integer> next() {
        return skip(1);
    }

    @Override
    public Optional<Integer> previous() {
        return skip(-1);
    }

    @Override
    public void reset() {

    }
}
